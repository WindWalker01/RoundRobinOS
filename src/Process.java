import java.util.ArrayList;

public class Process {
    static void findWaitingTime(int processes[], int n,
                                int burstTime[], int waitingTime[],
                                int quantum)
    {
        // Make a copy of burst times bt[] to store
        // remaining burst times.
        int[] remainingBurstTime = new int[n];
        for (int i = 0; i < n; i++)
            remainingBurstTime[i] = burstTime[i];

        int t = 0; // Current time


        while (true) {
            boolean done = true;

            // Traverse all processes one by one repeatedly
            for (int i = 0; i < n; i++) {
                // If burst time of a process is greater
                // than 0 then only need to process further
                if (remainingBurstTime[i] > 0) {
                    done = false; // There is a pending
                    // process

                    if (remainingBurstTime[i] > quantum) {
                        // Increase the value of t i.e.
                        // shows how much time a process has
                        // been processed
                        t += quantum;

                        // Decrease the burst_time of
                        // current process by quantum
                        remainingBurstTime[i] -= quantum;
                    }

                    // If burst time is smaller than or
                    // equal to quantum. Last cycle for this
                    // process
                    else {
                        // Increase the value of t i.e.
                        // shows how much time a process has
                        // been processed
                        t = t + remainingBurstTime[i];

                        // Waiting time is current time
                        // minus time used by this process
                        waitingTime[i] = t - burstTime[i];

                        // As the process gets fully
                        // executed make its remaining burst
                        // time = 0
                        remainingBurstTime[i] = 0;
                    }
                }
            }

            // If all processes are done
            if (done == true)
                break;
        }
    }

    // Method to calculate turn around time
    static void findTurnAroundTime(int processes[], int n,
                                   int bt[], int wt[],
                                   int tat[])
    {
        // calculating turnaround time by adding
        // bt[i] + wt[i]
        for (int i = 0; i < n; i++)
            tat[i] = bt[i] + wt[i];
    }

    // Method to calculate average time
    static void findavgTime(int processes[], int n,
                            int bt[], int quantum)
    {
        int waitingTime[] = new int[n], turnaroundTime[] = new int[n];
        int total_waitinTime = 0, total_tat = 0;

        // Function to find waiting time of all processes
        findWaitingTime(processes, n, bt, waitingTime, quantum);

        // Function to find turn around time for all
        // processes
        findTurnAroundTime(processes, n, bt, waitingTime, turnaroundTime);

        // Display processes along with all details
        System.out.println("PN "
                + " BT "
                + " WT "
                + " TAT");

        // Calculate total waiting time and total turn
        // around time
        for (int i = 0; i < n; i++) {
            total_waitinTime = total_waitinTime + waitingTime[i];
            total_tat = total_tat + turnaroundTime[i];
            System.out.println(" " + (i + 1) + "\t\t"
                    + bt[i] + "\t " + waitingTime[i]
                    + "\t\t " + turnaroundTime[i]);
        }

        System.out.println("Average waiting time = "
                + (float)total_waitinTime / (float)n);
        System.out.println("Average turn around time = "
                + (float)total_tat / (float)n);
    }


    // Driver Method
    public static void processScheduling(List list) {
        Node current = List.firstNode;
        int[] burst_time = new int[Storage.processNum];
        int index = 0;

        while (current != null) {
            User user = current.data;
            burst_time[index] = user.burstTime;
            current = current.next;
            index++;
        }

        int n = burst_time.length;
        int quantum = Storage.quantumTime;
        int[] processes = new int[n];  // Array to store process IDs (could just be 1, 2, 3,...)
        for (int i = 0; i < n; i++) {
            processes[i] = i + 1;
        }

        // Call the method to calculate average time using round-robin scheduling
        findavgTime(processes, n, burst_time, quantum);
    }
}
