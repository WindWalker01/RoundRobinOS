package RoundRobin;

import ganttchart.GanttChart;
import ganttchart.Process;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;


public  class Window extends JFrame {

    public static ArrayList<Process> processes = new ArrayList<>();

    public static int quantum = 3;

    public Window(int width, int height) {

        setSize(1280, 720);
        setTitle("Round Robin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);

        processes.add(new Process(0, 3, "P1"));
        processes.add(new Process(0, 10, "P2"));

        add(new GanttChart());

    }

}
