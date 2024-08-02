package Arrays;

public class AverageCustomerWaitingTime {
    public static double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double totalTime = 0;
        int currentTime = 0; // start time

        for (int i = 0; i < n; i++) {
            int arrivalTime = customers[i][0];
            int cookingTime = customers[i][1];

            // If the current customer arrives after the current time, we wait until they arrive
            if (currentTime < arrivalTime) {
                currentTime = arrivalTime;
            }

            // Calculate when the customer finishes
            int finishTime = currentTime + cookingTime;

            // Calculate waiting time and add it to total time
            totalTime += finishTime - arrivalTime;

            // current time is finishTime
            currentTime = finishTime;
        }

        return totalTime / n;
    }


    public static void main(String[] args) {
        int[][] arr={{1,2},{2,5},{4,3}};
        System.out.println(averageWaitingTime(arr));
    }
}
