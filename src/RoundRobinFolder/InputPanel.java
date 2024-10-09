package RoundRobinFolder;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InputPanel extends JPanel {
    int procval = 1;  // Starts at 1 for user display purposes
    JLabel burst;
    JLabel arrivalLabel;
    JTextField tburst;
    JTextField tarrival;
    String[] burstTimes;
    String[] arrivalTimes;

    public InputPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Set vertical layout
        setBounds(50, 50, 500, 300);

        // Labels
        JLabel inp = new JLabel("Input: ");
        JLabel process = new JLabel("Enter number of processes: ");
        burst = new JLabel();
        arrivalLabel = new JLabel();

        // TextField
        JTextField tprocess = new JTextField("", 10);
        tburst = new JTextField("", 20);
        tarrival = new JTextField("", 20);

        // Set preferred size for JTextFields
        Dimension textFieldSize = new Dimension(200, 20);
        tprocess.setPreferredSize(textFieldSize);
        tburst.setPreferredSize(textFieldSize);
        tarrival.setPreferredSize(textFieldSize);

        // JButton
        JButton b = new JButton("Submit Number of Processes");
        JButton bcompute = new JButton("Submit Burst and Arrival Time");

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Initialize number of processes only on the first submission
                if (procval == 1) { // Only initialize once
                    int numProcesses = Integer.parseInt(tprocess.getText());
                    burstTimes = new String[numProcesses];
                    arrivalTimes = new String[numProcesses];

                    // Hide process input components and show burst/arrival components
                    b.setVisible(false);
                    process.setVisible(false);
                    tprocess.setVisible(false);
                    burst.setVisible(true);
                    tburst.setVisible(true);
                    arrivalLabel.setVisible(true);
                    tarrival.setVisible(true);
                    bcompute.setVisible(true);

                    // Set up initial process label
                    burst.setText("Input P" + procval + " Burst Time: ");
                    arrivalLabel.setText("Input P" + procval + " Arrival Time: ");
                }
            }
        });

        bcompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ensure that user input is stored in the appropriate index of the array
                if (procval <= Integer.parseInt(tprocess.getText())) {
                    // Store burst and arrival times only after user input
                    burstTimes[procval - 1] = tburst.getText();  // Store burst time
                    arrivalTimes[procval - 1] = tarrival.getText(); // Store arrival time

                    System.out.println("Burst Times: " + String.join(", ", burstTimes));
                    System.out.println("Arrival Times: " + String.join(", ", arrivalTimes));

                    // Increment procval after storing times
                    procval++;

                    // If procval is still within the range, set up the input for the next process
                    if (procval <= Integer.parseInt(tprocess.getText())) {
                        burst.setText("Input P" + procval + " Burst Time: ");
                        arrivalLabel.setText("Input P" + procval + " Arrival Time: ");
                    } else {
                        // If all processes are entered, hide the fields
                        burst.setVisible(false);
                        tburst.setVisible(false);
                        arrivalLabel.setVisible(false);
                        tarrival.setVisible(false);
                        bcompute.setVisible(false); // Hide submit button after final input
                    }

                    // Clear the text fields for the next input
                    tburst.setText("");
                    tarrival.setText("");
                }
            }
        });

        // Adding components to the panel
        add(inp);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(process);
        add(tprocess);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(burst);
        add(tburst);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(arrivalLabel);
        add(tarrival);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(b);
        add(bcompute);

        // Set the visibility of burst fields to false initially
        burst.setVisible(false);
        tburst.setVisible(false);
        burst.setText("Input P" + procval + " Burst Time: ");
        arrivalLabel.setText("Input P" + procval + " Arrival Time: ");
        arrivalLabel.setVisible(false);
        tarrival.setVisible(false);
        bcompute.setVisible(false);
    }
}