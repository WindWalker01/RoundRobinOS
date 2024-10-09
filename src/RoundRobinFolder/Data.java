package RoundRobinFolder;

import ganttchart.Bar;

import java.util.ArrayList;

public class Data {

    public static int quantum = 0;
    public static ArrayList<Process> processes = new ArrayList<>();
    public static ArrayList<ProcessDetails> processDetails = new ArrayList<>();
    public static String description = "";

    public static ArrayList<Bar> bars = new ArrayList<>();



    public void reset(){
        quantum = 0;
        processes.clear();
        processDetails.clear();
        description = "";
    }

}
