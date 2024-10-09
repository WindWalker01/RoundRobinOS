package ganttchart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GanttChart extends JPanel {

    public GanttChart() {
        setLayout(null);
        setSize(1080, 100);
        setBackground(Color.BLACK);
        setLocation(90, 520);

        setChart();
    }


    private Color[] colors = {
            new Color(22, 66, 60),
            new Color(137, 103, 179),
            new Color(238, 102, 166),
            new Color(201, 104, 104),
            new Color(183, 224, 255),
            new Color(255, 225, 255),
    };



    public void setChart(){
        int currentTime = 0;
        for (int i = 0; i < 6; i++) {
            Bar bar1 = new Bar(currentTime,"p1", new Dimension(3 * 60, 100));
            bar1.setBackground(colors[i]);

            bar1.setLocation(bar1.getWidth() * i, 0);
            add(bar1);
            currentTime += 3;
        }


    }
}