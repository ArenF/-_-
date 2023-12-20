package api;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.function.Consumer;

public abstract class Unit {

    ImageIcon icon;
    Point point;
    HashMap<String, Consumer<AnimatedPage>> actionMap = new HashMap<>();

    public Unit(ImageIcon icon, Point point) {
        this.icon = icon;
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public double getX() {
        return point.getX();
    }

    public int getXToInt() {
        return (int) point.getX();
    }

    public double getY() {
        return point.getY();
    }

    public int getYToInt() {
        return (int) point.getY();
    }

    public void setPoint(double x, double y) {
        point = new Point((int)x, (int)y);
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void addAction(String key, Consumer<AnimatedPage> action) {
        actionMap.put(key, action);
    }

    public void removeAction(String key) {
        actionMap.remove(key);
    }
    public void executeAction(String key, AnimatedPage animatedPage) {
        Consumer<AnimatedPage> action = actionMap.get(key);
        action.accept(animatedPage);
        animatedPage.repaint();
    }


}
