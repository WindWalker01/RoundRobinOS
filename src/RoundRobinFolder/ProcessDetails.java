package RoundRobinFolder;

public class ProcessDetails {
    public int arrivalTime;
    public int burstTime;
    public int finishTime;
    public int turnAroundTime;
    public int waitingTime;
    public int executionStartTime;

    public ProcessDetails(int arrivalTime, int burstTime, int finishTime, int turnAroundTime, int waitingTime, int executionStartTime) {
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.finishTime = finishTime;
        this.turnAroundTime = turnAroundTime;
        this.waitingTime = waitingTime;
        this.executionStartTime = executionStartTime;
    }
}