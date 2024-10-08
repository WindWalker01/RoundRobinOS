import ganttchart.GanttChart;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;

public  class Window extends JFrame {

    JLabel label;
    public Window(int width, int height) {

        setSize(1280, 720);
        setTitle("Round Robin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);


        add(new GanttChart());
    }


}
