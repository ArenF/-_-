package api;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.function.Consumer;

public class AnimatedPage extends JPanel {

    HashMap<String, Unit> units = new HashMap<>();
    HashMap<String, Element> elements = new HashMap<>();

    public AnimatedPage(Element backgrounds) {
        elements.put("background", backgrounds);
    }

    public void setElement(String name, Element element) {
        elements.put(name, element);
    }

    public Element getElement(String name) {
        return elements.get(name);
    }

    public void addUnit(String name, Unit unit) {
        units.put(name, unit);
    }

    public Unit getUnit(String name) {
        return units.get(name);
    }

    public void removeUnit(String name) {
        units.remove(name);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        if (elements.isEmpty())
            return;
        if (units.isEmpty())
            return;
        for (Element elem : elements.values()) {
            elem.callback(g);
        }
        for (Unit unit : units.values()) {
            g.drawImage(unit.getIcon().getImage(), unit.getXToInt(), unit.getYToInt(), 50, 50, this);
        }
    }

}
