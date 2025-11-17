class SolutionAvgTime {
    // Main method to run and test the solution with an example input
    public static void main(String[] args) {
        // Create an instance of the Solution class
        SolutionAvgTime solution = new SolutionAvgTime();

        // Example Test Case 1: T = [3, 1, 2]
        int[][] customers = {{1,2},{2,5},{4,3}};
        double result1 = solution.averageWaitingTime(customers);
        System.out.println("Total wait time for T1: " + result1);  // Expected: 5

        // Example Test Case 2: T = [1, 2, 3, 4]
        int[][] customers2 = {{5,2},{5,4},{10,3},{20,1}};
        double result2 = solution.averageWaitingTime(customers2);
        System.out.println("Total wait time for T1: " + result2);  // Expected: 3.25

    }

    public double averageWaitingTime(int[][] customers) {

        double total_waiting_time = 0;
        int current_time = 0;

        for (int[] customer : customers) {
            int arrival = customer[0];
            int service = customer[1];
            if (current_time < arrival) {
                current_time = arrival;
            }
            int waiting_time = current_time - arrival + service;
            total_waiting_time += waiting_time;
            current_time += service;
        }

        return total_waiting_time / customers.length;
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


    public static class  Example {

    }
    }





