import java.util.LinkedList;
import java.util.Queue;

public class SolutionTotalWaitingTime {

    // Method to calculate the total waiting time
    public int solution(int[] T) {
        final int MOD = 1000000000;  // We need to return the result modulo 10^9
        Queue<Integer> queue = new LinkedList<>();

        for(Integer num : T){
            queue.add(num);
        }

        int waitTime = 0;
        int totalTime = 0;
        while(!queue.isEmpty()){
            totalTime += 1;

            int curr = queue.poll();
            curr -= 1;
            if(curr == 0){
                waitTime += totalTime;

            }else{
                queue.add(curr);
            }
        }
        waitTime %= MOD;
        return waitTime;
    }

    // Main method to run and test the solution with an example input
    public static void main(String[] args) {
        // Create an instance of the Solution class
        SolutionTotalWaitingTime solutionTotalWaitingTime = new SolutionTotalWaitingTime();

        // Example Test Case 1: T = [3, 1, 2]
        int[] T1 = {3, 1, 2};
        int result1 = solutionTotalWaitingTime.solution(T1);
        System.out.println("Total wait time for T1: " + result1);  // Expected: 13

        // Example Test Case 2: T = [1, 2, 3, 4]
        int[] T2 = {1, 2, 3, 4};
        int result2 = solutionTotalWaitingTime.solution(T2);
        System.out.println("Total wait time for T2: " + result2);  // Expected: 24

        // Example Test Case 3: T = [7, 7, 7]
        int[] T3 = {7, 7, 7};
        int result3 = solutionTotalWaitingTime.solution(T3);
        System.out.println("Total wait time for T3: " + result3);  // Expected: 63



        // Example Test Case 4: T = [10000]
        int[] T4 = {10000};
        int result4 = solutionTotalWaitingTime.solution(T4);
        System.out.println("Total wait time for T4: " + result4);  // Expected: 10000
    }
}