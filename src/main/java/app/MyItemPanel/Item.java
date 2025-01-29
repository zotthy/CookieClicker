package app.MyItemPanel;

import javax.swing.*;
import java.awt.*;

public class Item extends JPanel {
    private String name;
    private int count;
    private JLabel label;

    public Item(String name, int count) {
        this.name = name;
        this.count = count;
        this.label = new JLabel(name + ": " + count);
        add(label);
    }

    public void setCount(int count) {
        this.count = count;
        label.setText(name + ": " + count);
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }
}