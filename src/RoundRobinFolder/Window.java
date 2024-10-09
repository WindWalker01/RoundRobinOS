package RoundRobinFolder;

import ganttchart.GanttChart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window extends JFrame {
    public static JTextField summaryDescription;
    public static JTextField quantumField;

    public static GanttChart chart = new GanttChart();

    private JLabel titleLabel;



    public Window(int width, int height) {
        setSize(width, height);
        setTitle("Round Robin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);


        titleLabel = new JLabel("Round Robin - Gantt Chart");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        titleLabel.setBounds(550, 475, getWidth() / 2, 50);
        add(titleLabel);



        JLabel quantumLabel = new JLabel("Enter Quantum");
        quantumField = new JTextField("1");

        summaryDescription = new JTextField("Lorem Ipsum\nlorem");
        summaryDescription.setEditable(false);
        summaryDescription.setBounds(50, 100, 500, 250);
        summaryDescription.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 0)));
        summaryDescription.setVisible(false);
        summaryDescription.setFont(new Font("Serif", Font.BOLD, 14));

        add(summaryDescription);


        quantumLabel.setBounds(10, 10, 100, 30);
        quantumField.setBounds(110, 10, 100, 30);

        add(quantumField);
        add(quantumLabel);
        add(chart);


        setUp();

        setVisible(true);

    }


    public void setUp(){
        Table table = new Table();
        InputPanel inputPanel = new InputPanel(table);
        add(inputPanel);

        table.setBounds(700, 50, 500, 400);
        add(table);

    }
}
