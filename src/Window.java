import ganttchart.GanttChart;

import javax.swing.*;

public  class Window extends JFrame {
        JFrame frame;
        JLabel label;

    public Window(int width, int height) {


        frame.setSize(500, 800);
        setTitle("Round Robin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);


        add(new GanttChart());
    }


}
