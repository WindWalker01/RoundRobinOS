package RoundRobinFolder;

public class Process {

    public int id;
    public int arrivalTime;
    public int burstTime;
    public int remainingTime;
    public int finishTime;
    public int turnAroundTime;
    public  int waitingTime;

    public Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}