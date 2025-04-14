package CA1Sample.KiethSolution;

import java.util.Stack;  // Stack is used to track open tags
import java.util.regex.*; // Regular Expressions (Regex) for pattern matching

public class HTMLValidator {
    
    // Method to check if an HTML string is valid
    public static boolean isValidHTML(String html) {
        // Stack to store opening tags (Last In, First Out structure)
        Stack<String> stack = new Stack<>();

        // Regex pattern to detect opening, closing, and self-closing tags
        // <(/?) captures whether the tag is closing (e.g., </tag>)
        // ([a-zA-Z0-9]+) captures the tag name (e.g., div, p, h1)
        // ([^>]*) captures additional attributes inside the tag (e.g., <img src="image.jpg"/>)
        String tagPattern = "<(/?)([a-zA-Z0-9]+)([^>]*)>";
        Pattern pattern = Pattern.compile(tagPattern);
        Matcher matcher = pattern.matcher(html);

        // Iterate through all found tags in the input HTML
        while (matcher.find()) {
            String fullTag = matcher.group();   // The full tag (e.g., <div>, </p>, <img/>)
            String isClosing = matcher.group(1); // "/" if it's a closing tag, otherwise empty
            String tagName = matcher.group(2); // The tag name (e.g., div, p, h1)
            String attributes = matcher.group(3); // Any attributes inside the tag (e.g., class="test")

            // Check if it's a self-closing tag (it ends with "/>")
            boolean isSelfClosing = attributes.trim().endsWith("/");

            if (isSelfClosing) {
                continue; // Move to the next tag
            }
            if (isClosing.isEmpty()) {
                stack.push(tagName); // Push the tag name to track it
            } 
            else {
                // If stack is empty, it means there is no matching opening tag -> Invalid HTML
                if (stack.isEmpty()) return false;

                // Pop the last opened tag from the stack
                String openTag = stack.pop();

                // Check if the last opened tag matches the closing tag
                if (!openTag.equals(tagName)) { 
                    return false; // Mismatched tags (e.g., <div> closed with </span>)
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Example 1: Valid HTML (Properly nested and closed tags)
        String validHTML = "<html><body><h1>Title</h1><p>Paragraph</p><img src='image.jpg'/></body></html>";
        System.out.println("Valid HTML: " + isValidHTML(validHTML)); // Expected Output: true

        // Example 2: Invalid HTML (Closing tag doesn't match)
        String invalidHTML = "<html><body><h1>Title</h1><p>Paragraph</h2></body></html>";
        System.out.println("Invalid HTML: " + isValidHTML(invalidHTML)); // Expected Output: false

        // Example 3: Invalid HTML (Missing closing tag for <p>)
        String missingClosingTag = "<html><body><h1>Title</h1><p>Paragraph</body></html>";
        System.out.println("Invalid HTML (Missing Closing): " + isValidHTML(missingClosingTag)); // Expected Output: false

        // Example 4: Valid HTML with self-closing tags
        String validSelfClosing = "<html><head><meta charset='utf-8'/></head><body><br/><hr/></body></html>";
        System.out.println("Valid HTML with Self-Closing Tags: " + isValidHTML(validSelfClosing)); // Expected Output: true
    }
}


