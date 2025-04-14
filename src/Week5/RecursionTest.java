package Week5;

public class RecursionTest {
    public static void main(String[] args) {
        String input = "hilittlebhhioyhhihii";
        System.out.println(compute2(input));

/*        System.out.println(removeX("xxxaxxxbxxxc"));

        int [] nums = {1,2,3,4,5,50,6,7,8,9};
        System.out.println(compute(nums, 6));


        System.out.println(digitSum(126));

        System.out.printl  n(changeToY("xxxaxxxbxxxc"));

        System.out.println(clean("xxxaxxxbxxxc"));*/
        System.out.println("MoveX " + moveX("xxxaxxxbxxxc"));

        System.out.println(isPalindrome("aabbbbaa"));

    }



    private static int compute(String input) {
        //Given a string, compute recursively (no loops) the number of times lowercase “hi”
        //appears in the string
        int count = 0;
        for (int i = 0; i < input.length()-1; i++) {
            if(input.charAt(i) == 'h' && input.charAt(i+1) == 'i') {
                count++;
            }
        }

        return count;
    }

    private static int compute2(String input) {
        if (input.length() < 2){
            return 0;
        }

        if(input.startsWith("hi")){
            return (1 + compute2(input.substring(2)));
        }
        else {
            return (compute2(input.substring(1)));
        }
    }

    private static String removeX(String input) {
        if (input.isEmpty()){
            return "";
        }

            else if (input.charAt(0) == 'x'){
            return removeX(input.substring(1));
        }
        else {
            return input.charAt(0) + removeX(input.substring(1));

        }
    }

    private static String moveX(String input) {
        if (input.isEmpty()){
            return "";
        }

        if (input.charAt(0) == 'x'){
            return 'x'+ moveX(input.substring(1)) ;
        }
        else {
            return moveX(input.substring(1)) + input.charAt(0);
        }
    }


    private static boolean compute(int [] nums, int index){
        if (index < 0 || index >= nums.length - 1){
            return false;
        }

        if (nums[index+1]/nums[index]== 10){
            return true;
        }

        return compute(nums, index+1);
    }



    private static int digitSum(int n){
     if (n == 0){
         return 0;
     }
     return n % 10 + digitSum(n / 10);

    }

    private static String changeToY(String input) {
        if (input.isEmpty()){
            return "";
        }
        if (input.charAt(0) == 'x'){

            return 'y' + changeToY(input.substring(1));
        }
        else {
            return input.charAt(0) + changeToY(input.substring(1));
        }
    }

    private static String clean(String input){
        if (input.length() == 1){
            return "";
        }

        if (input.charAt(0) == input.charAt(1) ){
            return clean(input.substring(1));
        }
        else {
            return input.charAt(0) + clean(input.substring(1));
        }

    }

    private static  int factorial(int n){
        if (n == 0){
            return 1;
        }

        return n * factorial(n-1);
    }


    private static  int factorial2(int n){
       int result = 1;

        for (int i = 1; i <= n; i++){
           result= result * i;
        }


        return result;
    }

    private static boolean isPalindrome(String input){

        if (input.length() <= 1){
            return true;
        }

        if (input.charAt(0) != input.charAt(input.length()-1)){
            return false;
        }

        // the substring(beginIndex, endIndex) method is exclusive of the endIndex

        return isPalindrome(input.substring(1,input.length()-1));
    }






}
