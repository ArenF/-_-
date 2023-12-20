package api;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.function.Consumer;

public class AnimatedPage extends JPanel {

    HashMap<String, Unit> units = new HashMap<>();


    Consumer<Graphics> backgrounds;

    public AnimatedPage(Consumer<Graphics> backgrounds) {
        this.backgrounds = backgrounds;
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
        backgrounds.accept(g);
        if (units.isEmpty())
            return;
        for (Unit unit : units.values()) {
            g.drawImage(unit.getIcon().getImage(), unit.getXToInt(), unit.getYToInt(), 50, 50, this);
        }
    }

}
