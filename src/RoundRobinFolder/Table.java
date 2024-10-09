package RoundRobinFolder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Table extends JPanel {

    public Table() {
        setLayout(new BorderLayout());  // Set layout for the table panel

//        String[][] data = new String[burst.length][3];
//        for (int i = 0; i < burst.length; i++) {
//            data[i][0] = "P" + (i + 1);
//            data[i][1] = burst[i];
//            data[i][2] = arrival[i];
//        }
//
//
//        String[] column = {"Process ID", "Burst Time", "Arrival Time"};
//        JTable jt = new JTable(data, column);
//        JScrollPane sp = new JScrollPane(jt);
//        add(sp, BorderLayout.CENTER);  // Add the scroll pane to the panel
    }

    public void setTableData(ArrayList<Process> processes) {
        removeAll();
        String[][] data = new String[processes.size()][3];
        for (int i = 0; i < processes.size(); i++) {
            data[i][0] = String.valueOf(processes.get(i).id);
            data[i][1] = String.valueOf(processes.get(i).burstTime);
            data[i][2] = String.valueOf(processes.get(i).arrivalTime);
        }

        String[] column = {"Process ID", "Burst Time", "Arrival Time"};
        JTable jt = new JTable(data, column);
        JScrollPane sp = new JScrollPane(jt);
        add(sp, BorderLayout.CENTER);
    }

}