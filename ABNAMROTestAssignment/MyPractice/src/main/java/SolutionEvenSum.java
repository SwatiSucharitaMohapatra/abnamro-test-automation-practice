import java.util.*;

class SolutionEvenSum {
    // Main method to run and test the solution with an example input
    public static void main(String[] args) {
        // Create an instance of the Solution class
        SolutionEvenSum solution = new SolutionEvenSum();
//
//        //Example Test Case 1: T = [3, 1, 2]
        //int[] numbers = {1,4,6,7,8,20,4,8,6,8};
        int[] numbers = {1,2,3,4,5,3};
        int result1 = solution.evenSumCounter(numbers);
        System.out.println("Total wait time for T1: " + result1);  // Expected: 5
        System.out.println("Total wait time for T1: " + solution.evenSumIndex(numbers));  // Expected: 5
//
//        // Example Test Case 2: T = [1, 2, 3, 4]
        int[] numbers2 = {1,2,2,4,10,30,3};
//       double result2 = solution.evenSumCounter(numbers2);
//       System.out.println("Total wait time for T1: " + result2);  // Expected: 3.25

    }

    public int evenSumCounter(int[] numbers) {
        int sum;
        int evenSumCounter = 0;

        for(int i =0; i< numbers.length-1 ; i++) { // Add this to note
            if (isEven(numbers[i]+numbers[i+1])) {
                    evenSumCounter++ ; // Add this to note
                }
                ++i; // Add this to note
        }
        return evenSumCounter;
    }

    public boolean isEven(int sum) {
        return sum % 2 == 0; // Add this to note
    }

    public Map<Integer, Integer> evenSumIndex(int[] numbers) {
      int i = 0;
      int len = numbers.length;
        Map<Integer,Integer> map = new HashMap<>();

        while(i < len-1) { // Add this to note
            if (isEven(numbers[i]+numbers[i+1])) {
               map.put(i,i+1);
               // return new int[] {i, i+1};
            }
            i +=2; // Add this to note
        }

        return map;
    }


    }


