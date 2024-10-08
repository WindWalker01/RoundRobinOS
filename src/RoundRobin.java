import java.util.Scanner;

class Process {
    int id, arrivalTime, burstTime, remainingTime, finishTime, turnAroundTime, waitingTime;

    public Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

public class RoundRobin {
    private static final int MAX_PROCESSES = 6;
    private static int timeQuanta;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input process details
        System.out.print("Enter number of processes (up to 6): ");
        int numProcesses = Math.min(scanner.nextInt(), MAX_PROCESSES);

        Process[] processes = new Process[numProcesses];

        for (int i = 0; i < numProcesses; i++) {
            System.out.println("Enter arrival time and burst time for Process " + (i + 1) + ": ");
            int arrivalTime = scanner.nextInt();
            int burstTime = scanner.nextInt();
            processes[i] = new Process(i + 1, arrivalTime, burstTime);
        }

        // Input time quanta
        System.out.print("Enter time quanta: ");
        timeQuanta = scanner.nextInt();

        // Perform Round Robin Scheduling
        roundRobinScheduling(processes, numProcesses);

        // Display Results
        displayResults(processes);

        scanner.close();
    }

    private static void roundRobinScheduling(Process[] processes, int numProcesses) {
        int currentTime = 0;
        int completedProcesses = 0;

        // While not all processes are completed
        while (completedProcesses < numProcesses) {
            boolean idle = true;  // This will help check if any process was executed in this round

            for (int i = 0; i < numProcesses; i++) {
                Process currentProcess = processes[i];

                // Check if the process has arrived and has remaining time
                if (currentProcess.arrivalTime <= currentTime && currentProcess.remainingTime > 0) {
                    idle = false;  // A process was executed in this cycle

                    // Execute the process for a minimum of remaining time or time quanta
                    int execTime = Math.min(currentProcess.remainingTime, timeQuanta);
                    currentProcess.remainingTime -= execTime;
                    currentTime += execTime;  // Move the current time forward

                    // If the process is completed
                    if (currentProcess.remainingTime == 0) {
                        currentProcess.finishTime = currentTime;
                        currentProcess.turnAroundTime = currentProcess.finishTime - currentProcess.arrivalTime;  // TT = FT - AT
                        currentProcess.waitingTime = currentProcess.turnAroundTime - currentProcess.burstTime;  // WT = TT - BT
                        completedProcesses++;
                    }
                }
            }

            // If no process was executed in this cycle, increment the time (idle)
            if (idle) {
                currentTime++;
            }
        }
    }

    private static void displayResults(Process[] processes) {
        int totalTurnaroundTime = 0, totalWaitingTime = 0;

        System.out.println("\nProcess ID | Arrival Time | Burst Time | Finish Time | Turnaround Time | Waiting Time");
        for (Process process : processes) {
            System.out.printf("%9d | %12d | %10d | %11d | %15d | %12d\n",
                    process.id, process.arrivalTime, process.burstTime,
                    process.finishTime, process.turnAroundTime, process.waitingTime);

            totalTurnaroundTime += process.turnAroundTime;
            totalWaitingTime += process.waitingTime;
        }

        double avgTurnaroundTime = (double) totalTurnaroundTime / processes.length;
        double avgWaitingTime = (double) totalWaitingTime / processes.length;

        System.out.printf("\nAverage Turnaround Time: %.2f\n", avgTurnaroundTime);
        System.out.printf("Average Waiting Time: %.2f\n", avgWaitingTime);
    }
}