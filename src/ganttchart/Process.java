package ganttchart;

public class Process {

    public String name;
    public int arrivalTime;
    public int burstTime;
    public boolean isDone = false;

    public Process(int arrive, int burst, String name) {
        this.arrivalTime = arrive;
        this.burstTime = burst;
        this.name = name;
    }
}
