package RoundRobinFolder;

import ganttchart.GanttChart;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class Window extends JFrame {
    public static JTextField summaryDescription;
    public static JTextField quantumField;
    public static JLabel quantumLabel;
    public static GanttChart chart = new GanttChart();
    private static JLabel titleLabel;
    public static JLabel mTitle;
    public static JLabel mGroup;
    ImageIcon logo = new ImageIcon("RR.png");   // added logo


    public Window(int width, int height) {
        setIconImage(logo.getImage());
        setSize(width, height);
        setTitle("Round Robin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
      //  getContentPane().setBackground(new Color(0,0,0,0)); pang iba lang ng bg if gusto naten

        titleLabel = new JLabel("Round Robin - Gantt Chart");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        titleLabel.setBounds(550, 475, getWidth() / 2, 50);
        add(titleLabel);

        titleLabel.setVisible(false);

        mTitle = new JLabel("Round Robin");
        mTitle.setForeground(Color.BLACK);
        mTitle.setFont(new Font("Serif", Font.PLAIN, 100));
        mTitle.setBounds(390, 180, getWidth() / 2, 100);
        add(mTitle);

        mGroup = new JLabel("by Group 1");
        mGroup.setForeground(Color.BLACK);
        mGroup.setFont(new Font("Serif", Font.PLAIN, 17));
        mGroup.setBounds(800, 270, getWidth() / 2, 25);
        add(mGroup);



        quantumLabel = new JLabel("Enter Quantum: ");
        quantumField = new JTextField("1");

        summaryDescription = new JTextField("Lorem Ipsum\nlorem");
        summaryDescription.setEditable(false);
        summaryDescription.setBounds(180, 100, 500, 250);
        summaryDescription.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 0)));
        summaryDescription.setFont(new Font("Serif", Font.BOLD, 16));
        summaryDescription.setVisible(false);

       add(summaryDescription);


        quantumLabel.setBounds(560, 320, 100, 30);
        quantumField.setBounds(660, 320, 100, 30);

        add(quantumField);
        add(quantumLabel);
        
        setUp();
        add(chart);


        setVisible(true);

    }
    // para lumipat sa top right yung quantum at maghide sa iba
    public Window(){
        quantumLabel.setBounds(850, 10, 100, 30);
        quantumField.setBounds(930, 10, 100, 30);
        quantumLabel.setText("Quantum: ");
        mTitle.setVisible(false);
        titleLabel.setVisible(true);
        mGroup.setVisible(false);
    }

    public void setUp(){
        Table table = new Table();
        InputPanel inputPanel = new InputPanel(table);
        add(inputPanel);

        table.setBounds(700, 50, 500, 400);
        add(table);

    }
}
