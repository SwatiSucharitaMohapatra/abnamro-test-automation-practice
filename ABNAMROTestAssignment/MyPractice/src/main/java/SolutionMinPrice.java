import  java.util.*;

class SolutionMinPrice {
    // Main method to run and test the solution with an example input
    public static void main(String[] args) {
        // Create an instance of the Solution class
        SolutionMinPrice solution = new SolutionMinPrice();
//
//        // Example Test Case 1: T = [3, 1, 2]
        int[] days = {1,4,6,7,8,20};
        int[] cost = {2,7,15};
        double result1 = solution.mincostTickets(days, cost);
        System.out.println("Total wait time for T1: " + result1);  // Expected: 5
//
//        // Example Test Case 2: T = [1, 2, 3, 4]
        int[] days2 = {1,2,3,4,5,6,7,8,9,10,30,31};
       double result2 = solution.mincostTickets(days2, cost);
       System.out.println("Total wait time for T1: " + result2);  // Expected: 3.25

    }

    public double mincostTickets(int[] days, int[] costs) {
//        // length up to the last travel + 1 day is good enough (no need for 365)
//        int lastDay = days[days.length - 1];
//        // dp[i] means up to i-th day the minimum cost of the tickets
//        int[] dp = new int[lastDay + 1];
//        boolean[] isTravelDays = new boolean[lastDay + 1];
//        // mark the travel days
//        for(int day : days) isTravelDays[day] = true;
//
//        for(int i = 1; i <= lastDay; i++) {
//            if(!isTravelDays[i]) { // no need to buy ticket if it is not a travel day
//                dp[i] = dp[i - 1];
//                continue;
//            }
//            // select which type of ticket to buy
//            dp[i] = costs[0] + dp[i - 1]; // 1-day
//            dp[i] = Math.min(costs[1] + dp[Math.max(i - 7, 0)], dp[i]); // 7-day
//            dp[i] = Math.min(costs[2] + dp[Math.max(i - 30, 0)], dp[i]); // 30-day
//        }
//        return dp[lastDay];

        // using queue so that the oldest ticket is at the top.
        Queue<int[]> last7days = new LinkedList<>(), last30days = new LinkedList<>();

        int totalCost = 0;
        for (int day : days) {
            // discarding expired 7days pass

            while (!last7days.isEmpty() && last7days.peek()[0] + 7 <= day) {
                last7days.poll();
            }

            last7days.offer(new int[]{day, totalCost + costs[1]});

            // discarding expired 30 days pass.
            while (!last30days.isEmpty() && last30days.peek()[0] + 30 <= day) {
                last30days.poll();
            }

            last30days.offer(new int[]{day, totalCost + costs[2]});

            // taking the min of daily pass and current valid 7 days or 30 days pass.
            assert last30days.peek() != null;
            assert last7days.peek() != null;
            totalCost = Math.min(totalCost + costs[0], Math.min(last30days.peek()[1], last7days.peek()[1]));
        }

        return totalCost;
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


