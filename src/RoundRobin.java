import java.util.ArrayList;
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


class ProcessDetails {
    int arrivalTime;
    int burstTime;
    int finishTime;
    int turnAroundTime;
    int waitingTime;
    int executionStartTime;

    public ProcessDetails(int arrivalTime, int burstTime, int finishTime, int turnAroundTime, int waitingTime, int executionStartTime) {
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.finishTime = finishTime;
        this.turnAroundTime = turnAroundTime;
        this.waitingTime = waitingTime;
        this.executionStartTime = executionStartTime;
    }
}


public class RoundRobin {
    private static final int MAX_PROCESSES = 6;
    private static int timeQuanta;
    static int numProcesses;
    public static ArrayList<Integer> startTime = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter number of processes (up to 6): ");
        numProcesses = Math.min(scanner.nextInt(), MAX_PROCESSES);

        Process[] processes = new Process[numProcesses];
        ProcessDetails[] processDetailsArray = new ProcessDetails[numProcesses];

        for (int i = 0; i < numProcesses; i++) {
            System.out.println("Enter arrival time" + (i + 1) + ": ");
            int arrivalTime = scanner.nextInt();
            System.out.println("Enter burst time" + (i + 1) + ": ");
            int burstTime = scanner.nextInt();
            processes[i] = new Process(i + 1, arrivalTime, burstTime);
        }


        System.out.print("Enter time quanta: ");
        timeQuanta = scanner.nextInt();


        roundRobinScheduling(processes, numProcesses, processDetailsArray);


        displayResults(processes);

    }

    private static void roundRobinScheduling(Process[] processes, int numProcesses, ProcessDetails[] processDetailsArray) {
        int currentTime = 0;
        int completedProcesses = 0;

        //diko malagay na zero yung una kaya mano mano na :>
        startTime.add(0);

        while (completedProcesses < numProcesses) {

            boolean idle = true;

            for (int i = 0; i < numProcesses; i++) {

                Process currentProcess = processes[i];





                if (currentProcess.arrivalTime <= currentTime && currentProcess.remainingTime > 0) {
                    idle = false;



                    int executionStartTime = currentTime;


                    int execTime = Math.min(currentProcess.remainingTime, timeQuanta);
                    currentProcess.remainingTime -= execTime;
                    currentTime += execTime;
                    startTime.add(currentTime);





                    if (currentProcess.remainingTime == 0) {
                        currentProcess.finishTime = currentTime;
                        currentProcess.turnAroundTime = currentProcess.finishTime - currentProcess.arrivalTime;
                        currentProcess.waitingTime = currentProcess.turnAroundTime - currentProcess.burstTime;
                        processDetailsArray[i] = new ProcessDetails(currentProcess.arrivalTime, currentProcess.burstTime,
                                currentProcess.finishTime, currentProcess.turnAroundTime, currentProcess.waitingTime, executionStartTime);
                        completedProcesses++;
                    }
                }
            }


            if (idle) {
                currentTime++;


            }
        }
    }

    private static void displayResults(Process[] processes) {
        int totalTurnaroundTime = 0, totalWaitingTime = 0;



        System.out.println("Time line: ");
        System.out.println(startTime);




        System.out.println("\nProcess ID | Arrival Time | Burst Time | Finish Time | Turnaround Time | Waiting Time");
        for (int i = 0; i < processes.length; i++) {
            Process process = processes[i];
            System.out.printf("%9d | %12d | %10d | %11d | %15d | %12d\n",
                    process.id, process.arrivalTime, process.burstTime,
                    process.finishTime, process.turnAroundTime, process.waitingTime);

            totalTurnaroundTime += process.turnAroundTime;
            totalWaitingTime += process.waitingTime;
        }

        System.out.println("\nGantt Chart");
        for (int i = 0; i < startTime.size(); i++) {
            System.out.print(startTime.get(i) + "\t");

        }

        double avgTurnaroundTime = (double) totalTurnaroundTime / processes.length;
        double avgWaitingTime = (double) totalWaitingTime / processes.length;

        System.out.printf("\nAverage Turnaround Time: %.2f\n", avgTurnaroundTime);
        System.out.printf("Average Waiting Time: %.2f\n", avgWaitingTime);
    }


}

