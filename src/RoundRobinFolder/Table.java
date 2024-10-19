package RoundRobinFolder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Table extends JPanel {

    public Table() {
        setLayout(new BorderLayout());
    }

    public void setTableData(ArrayList<Process> processes) {
        removeAll();

        // First table: Process ID, Arrival Time, Burst Time
        String[][] data1 = new String[processes.size()][3];
        for (int i = 0; i < processes.size(); i++) {
            data1[i][0] = String.valueOf(processes.get(i).id);
            data1[i][1] = String.valueOf(processes.get(i).arrivalTime);
            data1[i][2] = String.valueOf(processes.get(i).burstTime);
        }
        String[] column1 = {"Process ID", "Arrival Time", "Burst Time"};
        JTable jt1 = new JTable(data1, column1);
        JScrollPane sp1 = new JScrollPane(jt1);

        // Second table: End Time, Turn Around Time, Waiting Time
        String[][] data2 = new String[processes.size()][3];
        for (int i = 0; i < processes.size(); i++) {
            data2[i][0] = String.valueOf(processes.get(i).finishTime);
            data2[i][1] = String.valueOf(processes.get(i).turnAroundTime);
            data2[i][2] = String.valueOf(processes.get(i).waitingTime);
        }
        String[] column2 = {"End Time", "Turn Around Time", "Waiting Time"};
        JTable jt2 = new JTable(data2, column2);
        JScrollPane sp2 = new JScrollPane(jt2);

        // Stack the two tables vertically
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));

        tablePanel.add(sp1);
        tablePanel.add(sp2);

        add(tablePanel, BorderLayout.CENTER);
    }

}
