import api.AnimatedPage;
import api.Unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame {
    public Main() {
        this.setTitle("테스트");

        AnimatedPage page = new AnimatedPage(graphics -> {
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0, 0, getWidth(), getHeight());
            graphics.setColor(Color.RED);
            graphics.drawString("테스트 화면입니다.", 200, 300);
        });

        this.setContentPane(page);

        page.addUnit("hero", new Hero(new ImageIcon("src/images/arch.jpg"), new Point(0, 0)));
        Unit hero = page.getUnit("hero");
        hero.addAction("right", p -> {
            hero.setPoint(hero.getX() + 10, hero.getY());
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    hero.executeAction("right", page);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        this.setSize(500, 400);
        this.setFocusable(true);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Main();
    }
}