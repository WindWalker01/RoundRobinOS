import RoundRobinFolder.Process;
import RoundRobinFolder.ProcessDetails;

import java.util.ArrayList;

public class Data {

    public int quantum = 0;
    public static ArrayList<Process> processes = new ArrayList<>();
    public static ArrayList<ProcessDetails> processDetails = new ArrayList<>();


    public void reset(){
        quantum = 0;
        processes.clear();
        processDetails.clear();
    }

}
