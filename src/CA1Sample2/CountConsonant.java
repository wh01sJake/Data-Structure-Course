package CA1Sample2;

public class CountConsonant {
    public static void main(String[] args) {
        String s = "aeiouwghjklmn";
        System.out.println(CountConsonantIterative(s));
        System.out.println(CountConsonantRecursive(s,0));


    }


    private static int CountConsonantIterative(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o'|| ch == 'u') {
                count++;
            }
        }
        return count;
    }

    private static int CountConsonantRecursive(String input, int index) {
        if (index >= input.length()) {
            return 0;
        }
        char ch = input.charAt(index);
        int count = 0;
        if (ch == 'a' || ch == 'e' || ch == 'i'|| ch == 'o'|| ch == 'u') {
            count++;
        }

        return count + CountConsonantRecursive(input, index + 1);
    }
}
