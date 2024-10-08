package ganttchart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GanttChart extends JPanel {

    private JLabel startTimeLabel;
    private JLabel endTimeLabel;

    public GanttChart() {


        setLayout(null);
        setSize(1080, 100);
        setBackground(new Color(0, 0, 0, 0));
        setLocation(90, 520);

        startTimeLabel = new JLabel("0");
        startTimeLabel.setBounds(0, getHeight() - 65, 50, 50);
        startTimeLabel.setForeground(Color.BLACK);
        startTimeLabel.setFont(new Font("Serif", Font.PLAIN, 20));


        endTimeLabel = new JLabel();
        endTimeLabel.setBounds(getWidth() - 20, getHeight() - 65, 50, 50);
        endTimeLabel.setText(setChart() + "");
        endTimeLabel.setForeground(Color.BLACK);
        endTimeLabel.setFont(new Font("Serif", Font.PLAIN, 20));

        add(startTimeLabel);
        add(endTimeLabel);


    }


    private Color[] colors = {
            new Color(22, 66, 60),
      new Color(137, 103, 179),
};


    // Quantum


    public int setChart(){
        int currentTime = 0;
        int size = 6;
        for (int i = 0; i < size; i++) {
            Bar bar1 = new Bar(currentTime,"P" + (i + 1), new Dimension(getWidth() / size, 50));
            bar1.setBackground(colors[i % colors.length]);

            bar1.setLocation(bar1.getWidth() * i, 0);
            add(bar1);
            currentTime += 3;
        }


        return 28;
    }
}
