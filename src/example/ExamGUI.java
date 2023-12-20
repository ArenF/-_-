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
        Unit name = page.getUnit("name");

        name.addAction("right", main_page -> {
            name.setPoint(name.getX() + 10, name.getY());
        });
        name.addAction("left", main_page -> {
            name.setPoint(name.getX() - 10, name.getY());
        });
        name.addAction("lifesub", p -> {
            if (name instanceof Hero) {
                Hero hero = (Hero) name;
                System.out.println("체력이 감소합니다.");
                hero.setLife(hero.getLife() - 1);
                p.setElement("알림메시지", graphics -> {
                    graphics.setColor(Color.WHITE);
                    graphics.drawString("현재 체력 : " + hero.getLife(), 50, 50);
                });
            }
        });
        this.setContentPane(page);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    name.executeAction("right", page);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    name.executeAction("left", page);
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    name.executeAction("lifesub", page);
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
