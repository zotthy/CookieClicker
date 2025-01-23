package app.MyItemPanel;

import javax.swing.*;

public class Inventory extends JPanel{



    public Inventory() {
        String categories[] = { "Household", "Office", "Extended Family",
                "Company (US)", "Company (World)", "Team", "Will",
                "Birthday Card List", "High School", "Country", "Continent",
                "Planet" };

        JList list = new JList(categories);
        JScrollPane scrollableList = new JScrollPane(list);
        add(scrollableList);
    }
}
