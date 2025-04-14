package Week4lab;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static void main(String[] args)  {
        LinkedStack<String> stack = new LinkedStack<>(); // For storing tag names as Strings
        FileInputStream fis = null;
        /*
        * regex:
        * +: preceding one or more
        * (...)? preceding optional
        * *: preceding zero or more
        * .*?: any optional characters
        * */

        String regex = "<([a-zA-Z]+)(\\s+.*?)?>"; //<div    class="container" id=4>
        String regex2 = "</([a-zA-Z]+)(\\s*)?>"; // </div   >
        String regex3 = "<([a-zA-Z]+)(\\s+.*?)?/>"; // //<img/   >  self-closing tag
        Pattern OPEN_TAG = Pattern.compile(regex);
        Pattern CLOSE_TAG = Pattern.compile(regex2);
        Pattern SELF_CLOSING_TAG = Pattern.compile(regex3);
        try{
            fis = new FileInputStream("C:\\Users\\jake\\Documents\\test.html");
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }


        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8));
            String line;

            int lineNum = 1;

            while( (line =  reader.readLine()) != null) {
                    Matcher OPENMatcher = OPEN_TAG.matcher(line);
                    Matcher CLOSEMatcher = CLOSE_TAG.matcher(line);
                    Matcher SELFMatcher = SELF_CLOSING_TAG.matcher(line);
                    while (SELFMatcher.find()) {
                        System.out.println("Ignored self-closing tags:" + SELFMatcher.group(1));
                    }


                    while (OPENMatcher.find()) {
                        String openTag = OPENMatcher.group(1).toLowerCase(); // toLowerCase in case the tag is <DIV> etc.
                        stack.push(openTag);
                        System.out.println("Push tag: " + openTag + " at line: " + lineNum);
                    }
                    while(CLOSEMatcher.find()) {
                       // Several different cases for closing tags.
                       // 1. stack empty: Couldn't find the opening tag for current closing tag.
                       // 2. peek equals to matching tag, then pop
                        // 2.1 if doesn't match, out put error
                        String closeTag = CLOSEMatcher.group(1).toLowerCase();
                        if (stack.isEmpty()){
                            System.out.println("ERROR: stack is empty at line: " + lineNum);
                        }
                        else {
                            String expectedTag = stack.peek();// store the current peek to output error msg.
                            if (expectedTag.equals(closeTag)){
                                stack.pop();
                                System.out.println("Pop tag: " +"</"+ closeTag +">"+ " at line: " + lineNum);
                            }
                            else {
                                System.out.println("ERROR: expected </" + expectedTag +">" +" but got " + stack.peek() + " at line: " + lineNum);
                            }
                        }
                    }
                    lineNum++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (stack.isEmpty()) {
            System.out.println("File is valid!");
        }
        else {
            System.out.println("File is not valid! Remaining tags: " + stack);
        }
    }
}
