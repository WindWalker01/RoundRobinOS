package ganttchart;

import RoundRobinFolder.Data;
import RoundRobinFolder.Process;
import RoundRobinFolder.Window;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GanttChart extends JPanel {

    private JLabel startTimeLabel;
    private JLabel endTimeLabel;


    private Color[] colors = {
            new Color(22, 66, 60),
            new Color(137, 103, 179),
            new Color(37, 113, 128),
            new Color(242, 229, 191),
            new Color(253, 139, 81),
            new Color(203, 96, 64),
    };

    public GanttChart() {
        setLayout(null);
        setSize(1080, 100);
        setBackground(new Color(0, 0, 0, 0));
        setLocation(90, 520);

    }


    public void createGanttChart() {
        startTimeLabel = new JLabel("0");
        startTimeLabel.setBounds(0, getHeight() - 65, 50, 50);
        startTimeLabel.setForeground(Color.BLACK);
        startTimeLabel.setFont(new Font("Serif", Font.PLAIN, 20));


        endTimeLabel = new JLabel();
        endTimeLabel.setBounds(getWidth() - 20, getHeight() - 70, 50, 50);
        endTimeLabel.setText(28 + "");
        endTimeLabel.setForeground(Color.BLACK);
        endTimeLabel.setFont(new Font("Serif", Font.PLAIN, 20));

        add(startTimeLabel);
        add(endTimeLabel);

        updateGanttChart();
    }


    // Quantum

    public void updateGanttChart(){
        int currentTime = 0;

        for(int i = 0; i < Data.bars.size(); i++){



            switch (Data.bars.get(i).processId.toUpperCase()){
                case "P1"-> Data.bars.get(i).setBackground(colors[0]);
                case "P2"-> Data.bars.get(i).setBackground(colors[1]);
                case "P3"-> Data.bars.get(i).setBackground(colors[2]);
                case "P4"-> Data.bars.get(i).setBackground(colors[3]);
                case "P5"-> Data.bars.get(i).setBackground(colors[4]);
                case "P6"-> Data.bars.get(i).setBackground(colors[5]);
                default -> Data.bars.get(i).setBackground(colors[i % colors.length]);
            }

            Data.bars.get(i).setLocation(Data.bars.get(i).getWidth() * i, 0);
            add(Data.bars.get(i));
            endTimeLabel.setText(String.valueOf(Data.bars.get(i).endT));
        }
    }
}

