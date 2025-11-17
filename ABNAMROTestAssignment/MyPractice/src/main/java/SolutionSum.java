import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

class SolutionSum {
    // Main method to run and test the solution with an example input
    public static void main(String[] args) {
        // Create an instance of the Solution class
        SolutionSum solution = new SolutionSum();
//
//        // Example Test Case 1: T = [3, 1, 2]
        int[] numbers = {1, 4, 6, 7, 8, 20, 4, 8, 6, 8};
        int target = 20;
//        Map<Integer, Integer> result1 = solution.twoSum(numbers, target);
//        int[] result2 = solution.twoSumGetUniquePair(numbers, target);
//        System.out.println("Total wait time for T1: " + result2+"      "+ Arrays.toString(result2));  // Expected: 5

//
//        // Example Test Case 2: T = [1, 2, 3, 4]
        int[] numbers2 = {1, 2, 5, 4, 10, 30, 3};
        int target2 = 6;
        Map<Integer, Integer> result3 = solution.twoSumPairs(numbers2, target2);
       // int[] result4 = solution.twoSumGetUniquePair(numbers2, target2);
        //System.out.println("Total wait time for T1: " + result4);  // Expected: 3.25
        System.out.println("Total wait time for T1: " + result3);  // Expected: 3.25

    }

    public Map<Integer, Integer> twoSumPairs(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // Write in the note
        Map<Integer, Integer> resultmap = new HashMap<>();
        int restNumber = 0;

        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) { // Add this to note
            restNumber = target - numbers[i];

            if (map.containsKey(restNumber)) { //
                resultmap.put(i, map.get(restNumber));
            }

        }
        return resultmap;


    }


//    public int[] twoSumGetUniquePair(int[] numbers, int target) {
//        int n=numbers.length;
//        Map<Integer,Integer> map=new HashMap<>();
//        int[] result=new int[numbers.length];
//        for(int i=0;i<n;i++){
//            if(map.containsKey(target-numbers[i])){
//                result[1]=i;
//                result[0]=map.get(target-numbers[i]);
//                return result;
//            }
//            map.put(numbers[i],i);
//        }
//        return result;
//    }

//    public int[] twoSumGetUniquePair(int[] nums, int target) {
//        Map<Integer,Integer> map = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            int restNum = target - nums[i];
//            if (map.containsKey(restNum)) {
//                return new int[] {map.get(restNum), i};
//            }
//            map.put(nums[i], i);
//        }
//        return new int[] {};
//    }
}


