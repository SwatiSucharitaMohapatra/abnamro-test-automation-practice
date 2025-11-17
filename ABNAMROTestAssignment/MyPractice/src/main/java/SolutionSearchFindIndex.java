import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SolutionSearchFindIndex {
    // Main method to run and test the solution with an example input
    public static void main(String[] args) {
        // Create an instance of the Solution class
        SolutionSearchFindIndex solution = new SolutionSearchFindIndex();
//
//        // Example Test Case 1: T = [3, 1, 2]
        int[] numbers = {1, 4, 6, 7, 8, 20, 4, 8, 6, 8};
        int target = 20;
//        Map<Integer, Integer> result1 = solution.twoSum(numbers, target);
//        int[] result2 = solution.twoSumGetUniquePair(numbers, target);
//        System.out.println("Total wait time for T1: " + result2+"      "+ Arrays.toString(result2));  // Expected: 5

//
//        // Example Test Case 2: T = [1, 2, 3, 4]
        int[] numbers2 = {1, 3, 5, 6};
        int target2 = 8;
        //Map<Integer, Integer> result3 = solution.twoSum(numbers2, target2);
        int result4 = solution.searchInsert(numbers2, target2);
        System.out.println("Total wait time for T1: " + result4);  // Expected: 3.25

    }

//    public int searchInsert(int[] numbers, int target) {
//        //int initialValue = numbers[0];
//        int index;
//
//        for (index=0; index<numbers.length;index++) {
//            if (target==numbers[index]) {
//                return index;
//            }
//            if (numbers[index]>target) {
//                return index;
//            }
//        }
//
//        return index;
//
//    }

//    public int searchInsert(int[] numbers, int target) {
//        //int initialValue = numbers[0];
//        int leftIndex = 0;
//        int rightIndex = numbers.length-1;
//
//
//        while (leftIndex<=rightIndex) {
//            int minIndex = (leftIndex+rightIndex)/2;
//            if (numbers[minIndex] == target) {
//                return minIndex;
//            }
//            if (numbers[minIndex]>target) {
//                rightIndex = minIndex -1;
//            }
//            else leftIndex = minIndex+1;
//
//        }
//        return leftIndex;
//
//    }


    public int searchInsert(int[] numbers, int target) {
        //int initialValue = numbers[0];
        int leftIndex = 0;
        int rightIndex = numbers.length-1;


        while (leftIndex<=rightIndex) {
            int minIndex = (leftIndex+rightIndex)/2;
            if (numbers[minIndex] == target) {
                return minIndex;
            }
            if (numbers[minIndex]<target) {
                leftIndex = minIndex +1;
            }
            else rightIndex = minIndex-1;

        }
        return leftIndex;

    }
}


