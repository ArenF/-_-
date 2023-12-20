package example;

import api.AnimatedPage;
import api.Unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ExamGUI extends JFrame {



    public ExamGUI() {
        this.setTitle("테스트 페이지");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        AnimatedPage page = new AnimatedPage(graphics -> {
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0, 0, getWidth(), getHeight());

            graphics.setColor(Color.red);
            graphics.drawString("테스트 메시지입니다.", getWidth() / 2, getHeight() / 2);
        });

        page.addUnit("name", new Hero(new ImageIcon("src/example/images/arch.jpg"), new Point(0, 0)));
        page.getUnit("name").addAction("right", main_page -> {
            Unit hero = main_page.getUnit("name");
            hero.setPoint(hero.getX() + 10, hero.getY());
        });
        page.getUnit("name").addAction("left", main_page -> {
            Unit hero = main_page.getUnit("name");
            hero.setPoint(hero.getX() - 10, hero.getY());
        });
        this.setContentPane(page);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    page.getUnit("name").executeAction("right", page);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    page.getUnit("name").executeAction("left", page);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        this.setFocusable(true);
        this.setSize(500, 400);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ExamGUI();
    }

}
