package CA1Sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {
    public static void main(String[] args) {
        int[] nums = {3, 32, 5, 354, 139, 2345, 113};

        System.out.println(findIterative(nums));

        System.out.println(findRecursive(nums));
    }


    private static boolean isOdd(int n) {

        return n % 3 == 0;
    }

    private static int[] findDividedIterative (int [] nums){

                int count = 0;
                for (int i = 0; i < nums.length; i++) {
                    if(isOdd(nums[i])){
                        count++;
                    }
                }
        int [] result = new int[count];
        int index = 0;
               for(int num : nums){
                   if(isOdd(num)){
                       result[index] = num;
                       index++;
                   }
               }
               return result;
    }

    private static int[] findDividedRecursive (int [] nums){
        return RecursiveProcess(nums,0, new int [0]);
    }

    private static int[] RecursiveProcess(int [] nums,int index,int [] realNums){
        if (index >= nums.length) {
            return realNums;
        }

        if (isOdd(nums[index])) {
            int [] newRealNums = Arrays.copyOf(realNums,realNums.length+1 );
            newRealNums[realNums.length] = nums[index];
            return RecursiveProcess(nums,index+1,newRealNums);

        }
        else {
            return RecursiveProcess(nums,index+1,realNums);
        }


    }


    private static List<Integer> findIterative(int [] nums){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (isOdd(nums[i])) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    private static List<Integer> findRecursive(int [] nums){
        List<Integer> result = new ArrayList<>();
        RecursiveProcess2(nums,0,result);
        return result;
    }
    private static void RecursiveProcess2(int [] nums,int index,List<Integer> result){
        if (index >= nums.length) {
            return;
        }
        if (isOdd(nums[index])) {
            result.add(nums[index]);
        }

         RecursiveProcess2(nums,index+1,result);

    }

}
