package example;

import api.Unit;

import javax.swing.*;
import java.awt.*;

public class Hero extends Unit {

    int life = 3;

    public Hero(ImageIcon icon, Point point) {
        super(icon, point);
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
