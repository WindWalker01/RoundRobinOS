import ganttchart.GanttChart;

import javax.swing.*;

public class Window extends JFrame {

    public Window(int width, int height) {
        setSize(width, height);
        setTitle("Round Robin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);


        InputPanel inputPanel = new InputPanel();
        add(inputPanel);

        // pang test lang sa code ni rasil
        //GanttChart ganttChart = new GanttChart();
        //add(ganttChart);

        // Make frame visible
        setVisible(true);
    }
}
