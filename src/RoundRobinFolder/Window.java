package RoundRobinFolder;

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

    public static JTextField summaryDescription;
    public static JTextField quantumField;



    public Window(int width, int height) {
        setSize(width, height);
        setTitle("Round Robin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        JLabel quantumLabel = new JLabel("Enter Quantum");
        quantumField = new JTextField();

        summaryDescription = new JTextField("Lorem Ipsum\nlorem");
        summaryDescription.setEditable(false);
        summaryDescription.setBounds(50, 100, 500, 250);
        summaryDescription.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 0)));
        summaryDescription.setVisible(false);

        add(summaryDescription);


        quantumLabel.setBounds(10, 10, 100, 30);
        quantumField.setBounds(110, 10, 100, 30);

        add(quantumField);
        add(quantumLabel);


        setUp();

        setVisible(true);

    }


    public void setUp(){
        Table table = new Table();
        InputPanel inputPanel = new InputPanel(table);
        add(inputPanel);

        table.setBounds(700, 50, 500, 400);
        add(table);


//        processes.add(new Process(0, 3, "P1"));
//        processes.add(new Process(0, 10, "P2"));

//        add(new GanttChart());

    }
}
