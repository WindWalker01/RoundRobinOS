package RoundRobinFolder;

import ganttchart.Bar;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class RoundRobin {
    private static final int MAX_PROCESSES = 6;
    private int timeQuanta;
    static int numProcesses;
    public static ArrayList<Integer> startTime = new ArrayList<>();

    public static double averageTurnAroundTime;
    public static double averageWaitingTime;


    public RoundRobin(int timeQuanta) {
        this.timeQuanta = timeQuanta;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//
//        System.out.print("Enter number of processes (up to 6): ");
//        numProcesses = Math.min(scanner.nextInt(), MAX_PROCESSES);
//
//        Process[] processes = new Process[numProcesses];
//        ProcessDetails[] processDetailsArray = new ProcessDetails[numProcesses];
//
//        for (int i = 0; i < numProcesses; i++) {
//            System.out.println("Enter arrival time" + (i + 1) + ": ");
//            int arrivalTime = scanner.nextInt();
//            System.out.println("Enter burst time" + (i + 1) + ": ");
//            int burstTime = scanner.nextInt();
//            processes[i] = new Process(i + 1, arrivalTime, burstTime);
//        }
//
//
//        System.out.print("Enter time quanta: ");

//        timeQuanta = scanner.nextInt();
//
//
//        roundRobinScheduling(processes, numProcesses, processDetailsArray);
//
//
//        displayResults(processes);

    }

    public ArrayList<Process> roundRobinScheduling(Process[] processes, int numProcesses, ProcessDetails[] processDetailsArray) {
        int currentTime = 0;
        int completedProcesses = 0;

        // Sort processes by arrival time
        Arrays.sort(processes, Comparator.comparingInt(p -> p.arrivalTime));

        startTime.add(0);  // Initial start time at 0

        while (completedProcesses < numProcesses) {
            boolean idle = true;

            for (int i = 0; i < numProcesses; i++) {
                Process currentProcess = processes[i];

                // Check if process has arrived and has remaining time
                if (currentProcess.arrivalTime <= currentTime && currentProcess.remainingTime > 0) {
                    idle = false;

                    int executionStartTime = currentTime;
                    int execTime = Math.min(currentProcess.remainingTime, timeQuanta);  // Process executes for either time quanta or remaining time

                    currentProcess.remainingTime -= execTime;
                    currentTime += execTime;  // Increment current time by the time process executed
                    startTime.add(currentTime);

                    if (currentProcess.remainingTime == 0) {
                        currentProcess.finishTime = currentTime;
                        currentProcess.turnAroundTime = currentProcess.finishTime - currentProcess.arrivalTime;
                        currentProcess.waitingTime = currentProcess.turnAroundTime - currentProcess.burstTime;

                        processDetailsArray[i] = new ProcessDetails(
                                currentProcess.arrivalTime,
                                currentProcess.burstTime,
                                currentProcess.finishTime,
                                currentProcess.turnAroundTime,
                                currentProcess.waitingTime,
                                executionStartTime
                        );
                        completedProcesses++;
                    }

                    Data.bars.add(new Bar(currentTime, "P" + currentProcess.id));
                }
            }

            if (idle) {
                // No process ready to execute, increment time
                currentTime++;
            }
        }

        int index = 0;
        for (Bar bar : Data.bars) {
            bar.resizeBar(new Dimension((1080 / Data.bars.size()), 50));
            index++;
        }

        ArrayList<Process> result = new ArrayList<>();
        for (int i = 0; i < numProcesses; i++) {
            result.add(processes[i]);
        }

        return result;
    }

    public static String displayResults(Process[] processes) {
        int totalTurnaroundTime = 0, totalWaitingTime = 0;







        for (int i = 0; i < processes.length; i++) {
            Process process = processes[i];


            totalTurnaroundTime += process.turnAroundTime;
            totalWaitingTime += process.waitingTime;
        }

        System.out.println("\nGantt Chart");
        for (int i = 0; i < startTime.size(); i++) {
            System.out.print(startTime.get(i) + "\t");

        }

        double avgTurnaroundTime = (double) totalTurnaroundTime / processes.length;
        double avgWaitingTime = (double) totalWaitingTime / processes.length;


        return "Average Turn around time is " + avgTurnaroundTime + " and Average Waiting time is " + avgWaitingTime;
    }


}

