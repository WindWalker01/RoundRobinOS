import ganttchart.GanttChart;

import javax.swing.*;

public  class Window extends JFrame {

    public Window(int width, int height) {


        setSize(width, height);
        setTitle("Round Robin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);


        add(new GanttChart());
    }


}
