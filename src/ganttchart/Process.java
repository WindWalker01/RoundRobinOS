package ganttchart;

public class Process {
    public int arrivalTime;
    public int burstTime;

    public Process(int arrive, int burst){
        this.arrivalTime = arrive;
        this.burstTime = burst;
    }
}
