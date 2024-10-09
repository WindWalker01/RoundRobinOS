package ganttchart;

import javax.swing.*;
import java.awt.*;

public class Bar extends JPanel {

    private JLabel processName;
    private JLabel endTime;

    public Bar(int endT, String name, Dimension size){
        setLayout(null);
        setSize(size);
        processName = new JLabel(name);

        processName.setBounds(size.width / 2, 0, size.width, size.height);
        processName.setForeground(Color.WHITE);
        processName.setFont(new Font("Serif", Font.PLAIN, 20));

        endTime = new JLabel("" + endT);

        endTime.setBounds(size.width - 20, size.height - 40, 50, 50);
        endTime.setForeground(Color.WHITE);
        endTime.setFont(new Font("Serif", Font.PLAIN, 20));

        add(processName);
        add(endTime);
    }

}
