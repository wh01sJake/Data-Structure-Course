package CA1Sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isXML = selectValidationMode(sc);
        validateFile(isXML);



    }


    private static boolean selectValidationMode(Scanner sc) {
        System.out.println("Please select a valid mode: ");
        System.out.println("1. XML Validation");
        System.out.println("2. HTML Validation");

        System.out.println("Please enter 1 or 2");
        String input = sc.nextLine();

        while (true){
            if (input.equals("1")) {
                System.out.println("***********Processing XML Validation***********");
                return true;
            }
            else if (input.equals("2")) {
                System.out.println("***********Processing HTML Validation***********");
                return false;
            }
            else {
                System.out.println("Invalid mode!");
            }
        }
    }

    private static void validateFile(boolean isXML) {
        Stack<String> stack = new Stack<>();

        String tagNameRegex = isXML ? "[a-zA-Z_:\\-]+" : "[a-zA-Z]+";

        Pattern openTag = Pattern.compile("<(" + tagNameRegex + ")(\\s+.*?)?>");
        Pattern closeTag = Pattern.compile("</(" + tagNameRegex + ")(\\s*)?>");
        Pattern selfClosing = Pattern.compile("<(" + tagNameRegex + ")(\\s+.*?)?/>");

        try {
            Scanner fileScanner = new Scanner(new File("C:\\Users\\jake\\Documents\\testXML.xml"));
            int lineNum = 1;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // skip comment line for XML file
                if (isXML && line.startsWith("<!--")){
                    continue;
                }

                Matcher openMatcher = openTag.matcher(line);
                Matcher closeMatcher = closeTag.matcher(line);
                Matcher selfClosingMatcher = selfClosing.matcher(line);

              while(selfClosingMatcher.find()){
                  String tag = processingTagName(selfClosingMatcher.group(1), isXML);
                  System.out.println("Ignored self-closing tag: " + tag);
                  line = line.replace(selfClosingMatcher.group(), "");
              }

              while(openMatcher.find()){
                  String tag = processingTagName(openMatcher.group(1), isXML);
                  stack.push(tag);
                  System.out.println("Pushed tag: " + tag +" at line: " + lineNum);
              }

                while (closeMatcher.find()) {
                    if (stack.isEmpty()) {
                        System.out.println("ERROR: Unexpected closing tag </" + closeMatcher.group(1) + "> at line: " + lineNum);
                    } else {
                        String expectedTag = stack.peek();
                        String actualTag = processingTagName(closeMatcher.group(1), isXML);
                        if (expectedTag.equals(actualTag)) {
                            stack.pop();
                            System.out.println("Pop tag: " + actualTag + " at line: " + lineNum);
                        } else {
                            System.out.println("ERROR: Expected </" + expectedTag + "> but found </" + actualTag + "> at line: " + lineNum);
                        }
                    }
                }
              lineNum++;

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Validation Result");
        if (stack.isEmpty()){
            System.out.println("File is valid");
        }
        else {
            System.out.println("File is not valid remaining tag " +stack);
        }


    }

    private static String processingTagName(String rawName, boolean isXML) {
        return isXML ? rawName : rawName.toLowerCase();

    }

}
