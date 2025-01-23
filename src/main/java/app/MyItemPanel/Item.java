package app.MyItemPanel;

import javax.swing.*;
import java.awt.*;

public class Item extends JPanel {
    private String name;
    private int count;
    private JLabel pole;

    public Item(String name, int count){
        this.name = name;
        this.count = count;
        pole = new JLabel();
        pole.setPreferredSize(new Dimension(200, 50));
        pole.setBackground(Color.red);
        pole.setText("ds");
        add(pole);
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public JLabel getPole() {
        return pole;
    }

    public void setPole(JLabel pole) {
        this.pole = pole;
    }
}

