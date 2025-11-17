import java.util.*;

class SolutionRomanNumber {
    // Main method to run and test the solution with an example input
    public static void main(String[] args) {
        // Create an instance of the Solution class
        SolutionRomanNumber solution = new SolutionRomanNumber();

//        // Example Test Case 1: T = [3, 1, 2]
//        String customers = "III";
//        double result1 = solution.romanToInt(customers);
//        System.out.println("Total wait time for T1: " + result1);  // Expected: 5

        // Example Test Case 2: T = [1, 2, 3, 4]
        String customers2 = "MCMXCIV";
        double result2 = solution.romanToInt(customers2);
        System.out.println("Total wait time for T1: " + result2);  // Expected: 3.25

        // Example Test Case 2: T = [1, 2, 3, 4]
        String customers3 = "LVIII";
        double result3 = solution.romanToInt(customers3);
        System.out.println("Total wait time for T1: " + result3);  // Expected: 3.25

    }
    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }
    public int romanToInt(String s) {
        int sum = 0;
        int i = 0;

        while (i < s.length()) {
            String symbol1 = String.valueOf(s.charAt(i));
            int nextValue = 0;
            int current;
            if (i+1 < s.length()) {
                String symbol2 = String.valueOf(s.charAt(i+1));
                nextValue = values.get(symbol2);
            }
                current = values.get(symbol1);
                 if (nextValue > current) {
                     sum += (nextValue-current);
                     i+=2;
                 } else {
                     sum += current;
                     i +=1 ;
                 }
            }
        return sum;
    }


//        int waitTime = 0;
//        int finishTime = 0;
//        int numOfCustomers = customers.length;
//
//        for (int[] customer : customers) {
//            finishTime = Math.max(customer[0], finishTime) + customer[1];
//            waitTime += finishTime - customer[0];
//        }
//
//        return (double) waitTime / numOfCustomers;

    }


