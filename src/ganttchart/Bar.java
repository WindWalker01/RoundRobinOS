package ganttchart;

import javax.swing.*;
import java.awt.*;

public class Bar extends JPanel {

    private JLabel processName;
    private JLabel endTime;

    public int endT;

    public Bar(int endT, String name){
        this.endT = endT;

        setLayout(null);
        processName = new JLabel(name);

        processName.setForeground(Color.WHITE);
        processName.setFont(new Font("Serif", Font.PLAIN, 10));

        endTime = new JLabel("" + endT);

        endTime.setForeground(Color.WHITE);
        endTime.setFont(new Font("Serif", Font.PLAIN, 10));

        add(processName);
        add(endTime);
    }


    public void resizeBar(Dimension d){
        setSize(d);
        processName.setBounds(d.width / 2, 0, d.width, d.height);
        endTime.setBounds(d.width - 20, d.height - 40, 50, 50);

    }

}
