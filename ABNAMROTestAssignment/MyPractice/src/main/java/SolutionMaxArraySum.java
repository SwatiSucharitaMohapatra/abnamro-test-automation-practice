import java.util.LinkedList;
import java.util.Queue;

class SolutionMaxArraySum {
    // Main method to run and test the solution with an example input
    public static void main(String[] args) {
        // Create an instance of the Solution class
        SolutionMaxArraySum solution = new SolutionMaxArraySum();
//
//        // Example Test Case 1: T = [3, 1, 2]
        int[] numbers = {-1,2,2};
        int result1 = solution.maxSumOfSubArray(numbers);
        System.out.println("Total wait time for T1: " + result1);  // Expected: 5
//
//        // Example Test Case 2: T = [1, 2, 3, 4]
        int[] numbers2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        //double result2 = solution.mincostTickets(numbers2);
        // System.out.println("Total wait time for T1: " + result2);  // Expected: 3.25

    }

    public int maxSumOfSubArray(int[] numbers) {
        int maxSum = numbers[0];
            if (checkIfArrayHasAllNegativeValue(numbers)) {
                for (int i = 0; i < numbers.length - 1; i++) {
                        maxSum = Math.max(maxSum, numbers[i + 1]);
                }
            }
            else {
                int currentSum = numbers[0];
                for (int i =1; i< numbers.length; i++) {
                    currentSum = Math.max(numbers[i], currentSum + numbers[i]); /// Dynamic Programming
                    maxSum = Math.max(maxSum,currentSum);
                }
            }
        return maxSum;
//        int currentSubarray = numbers[0];
//        int maxSubarray = numbers[0];
//
//        // Start with the 2nd element since we already used the first one.
//        for (int i = 1; i < numbers.length; i++) {
//            int num = numbers[i];
//            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
//            currentSubarray = Math.max(num, currentSubarray + num);
//            maxSubarray = Math.max(maxSubarray, currentSubarray);
//        }
//
//        return maxSubarray;
    }


    public boolean checkIfArrayHasAllNegativeValue(int[] numbers) {
        boolean isNegative = true;
        for (int num : numbers) {
            if (num >= 0) {  // If any number is 0 or positive
                return false;  // Return false immediately
            }
        }
        return isNegative;  // All numbers are negative
    }
}


