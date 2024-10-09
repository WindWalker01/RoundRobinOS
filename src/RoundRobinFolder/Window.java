package RoundRobinFolder;

import ganttchart.GanttChart;
import ganttchart.Process;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window extends JFrame {


    public static ArrayList<Process> processes = new ArrayList<>();

    public static int quantum = 3;

    private String[] burst = {
            "20",
            "20",
            "20",
            "20",
            "20",
    };

    private String[] arrival = {
            "20",
            "1",
            "2",
            "30",
            "40",
            "10",

    };

    public Window(int width, int height) {
        setSize(width, height);
        setTitle("Round Robin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);


        processes.add(new Process(0, 3, "P1"));
        processes.add(new Process(0, 10, "P2"));

        add(new GanttChart());

        InputPanel inputPanel = new InputPanel();
        add(inputPanel);

        // Make frame visible
        setVisible(true);


        Table table = new Table(burst, arrival);
        table.setBounds(700, 50, 500, 500);

        add(table);
    }
}
