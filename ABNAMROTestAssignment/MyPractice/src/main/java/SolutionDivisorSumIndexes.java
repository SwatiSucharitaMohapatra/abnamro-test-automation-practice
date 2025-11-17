import java.util.Arrays;
import java.util.LinkedList;

class SolutionDivisorSumIndexes {
    // Main method to run and test the solution with an example input
    public static void main(String[] args) {
        // Create an instance of the Solution class
        SolutionDivisorSumIndexes solution = new SolutionDivisorSumIndexes();
//
//        // Example Test Case 1: T = [3, 1, 2]
        int[] numbers = {1,2,3,4};
        int k = 3;
       int result1 = solution.evenSumIndex(numbers,k);
       // long result1 = solution.sumCounter(numbers,k);
        System.out.println("Total wait time for T1: " + result1);  // Expected: 5


    }

//    public long sumCounter(int[] numbers, int k) {
//        int sumCounter = 0;
//
////       for(int i =0; i< numbers.length-1 ; i++) { // Add this to note
////           if (isDivisible(numbers[i]+numbers[i+1], k)) {
////               sumCounter++ ; // Add this to note
////                }
////                ++i; // Add this to note
////        }
////        return sumCounter;
////        }

    public boolean isDivisible(int sum, int k) {
        return sum % k == 0; // Add this to note
    }

    public int evenSumIndex(int[] numbers, int k) {
      int len = numbers.length;
        int i;
        int j;

      LinkedList<int[]> list = new LinkedList<>(); /// Add in Note

        for(i=0; i<len-1; i++) { // Add this to note
            for (j = i+1; j<len; j++) {
                if (isDivisible(numbers[i] + numbers[j], k)) {
                    list.add(new int[]{i, j}); /// Add in note
                }
            }
        }
        return list.size();
    }



    }


