package app.MyItemPanel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Inventory extends JPanel{
    HashMap<String, Item> itemHashMap = new HashMap<>();


    public Inventory() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.LIGHT_GRAY);
    }

    public void addItem(String name, int count) {
        if (itemHashMap.containsKey(name)) {
            Item item = itemHashMap.get(name);
            item.setCount(item.getCount() + count);
        } else {
            Item item = new Item(name, count);
            itemHashMap.put(item.getName(), item);
            add(item);
        }
        revalidate();
        repaint();
    }

    public HashMap<String, Item> getItemHashMap() {
        return itemHashMap;
    }

    public void setItemHashMap(HashMap<String, Item> itemHashMap) {
        this.itemHashMap = itemHashMap;
    }
}
