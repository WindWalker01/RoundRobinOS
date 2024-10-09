package ganttchart;

import javax.swing.*;
import java.awt.*;

public class Bar extends JPanel {

    private JLabel processName;
    private JLabel timeStarted;

    public Bar(int startTime, String name, Dimension size){
        setLayout(null);
        setSize(size);
        processName = new JLabel(name);

        processName.setBounds(size.width / 2, 0, size.width, size.height);
        processName.setForeground(Color.WHITE);
        processName.setFont(new Font("Serif", Font.PLAIN, 20));

        timeStarted = new JLabel("" + startTime);

        timeStarted.setBounds(10, size.height - 40, 50, 50);
        timeStarted.setForeground(Color.WHITE);
        timeStarted.setFont(new Font("Serif", Font.PLAIN, 20));

        add(processName);
        add(timeStarted);
    }

}