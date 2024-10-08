import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Window extends JFrame {
    int procval = 1;
    JLabel burst;
    JLabel arrivalLabel;
    JTextField tburst;
    JTextField tarrival;
    String[] burstTimes = new String[6];
    String[] arrivalTimes = new String[6];

    public Window(int width, int height) {
        setSize(width, height);
        setTitle("Round Robin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Set vertical layout
        panel.setBounds(50, 50, 500, 300);

        // Labels
        JLabel inp = new JLabel("Input: ");
        JLabel process = new JLabel("Enter processes: ");
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
        JButton b = new JButton("Submit");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numProcesses = 0;


                while (numProcesses < 1 || numProcesses > 6) {
                    String input = tprocess.getText();
                    if (!input.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number for processes.");
                        return;
                    }
                    numProcesses = Integer.parseInt(input);
                }


                if (procval <= numProcesses) {
                    burst.setText("Input P" + procval + " Burst Time: ");
                    arrivalLabel.setText("Input P" + procval + " Arrival Time: ");
                    burst.setVisible(true);
                    tburst.setVisible(true);
                    arrivalLabel.setVisible(true);
                    tarrival.setVisible(true);


                    burstTimes[procval - 1] = tburst.getText(); // Store burst time
                    arrivalTimes[procval - 1] = tarrival.getText(); // Store arrival time

                    // Increment procval for the next submission
                    procval++;
                }

                    // Optionally, print stored values for debugging
                    System.out.println("Burst Times: " + String.join(", ", burstTimes));
                    System.out.println("Arrival Times: " + String.join(", ", arrivalTimes));

            }
        });

        // Adding components to the panel
        panel.add(inp);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(process);
        panel.add(tprocess);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(burst);
        panel.add(tburst);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(arrivalLabel);
        panel.add(tarrival);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(b);

        // Set the visibility of burst fields to false initially
        burst.setVisible(false);
        tburst.setVisible(false);
        arrivalLabel.setVisible(false);
        tarrival.setVisible(false);

        add(panel);

        // Make frame visible
        setVisible(true);
    }
}
