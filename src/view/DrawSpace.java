package view;

import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

public class DrawSpace extends JPanel implements ActionListener, KeyListener {
    Timer timer = new Timer(5, this);
    Player player;
    double xPosition = 1;
    double yPosition = 1;
    double xVelocity = 0;
    double yVelocity = 0;
    double width = 10;
    double height = 10;
    int frameWidth;
    int frameHeight;

    public DrawSpace(int frameWidth, int frameHeight) {
        this.player = new Player(this.xPosition, this.yPosition, this.xVelocity, this.yVelocity, this.width, this.height);
        this.timer.start();
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public DrawSpace(int frameWidth, int frameHeight, Player player) {
        this.player = player;
        this.timer.start();
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D pl = new Rectangle2D.Double(player.getxPosition(), player.getyPosition(), player.getWidth(), player.getHeight());
        g2.fill(pl);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (keepXInBounds()) {
            player.setxPosition(player.getxPosition() + player.getxVelocity());
        }
        if (keepYInBounds()) {
            player.setyPosition(player.getyPosition() + player.getyVelocity());
        }
        repaint();
    }

    private boolean keepYInBounds() {
        if (player.getyPosition() + player.getyVelocity() < 0 || player.getyPosition() + player.getyVelocity() > this.frameHeight - (player.getHeight() + 38)) return false;
        else return true;
    }

    private boolean keepXInBounds() {
        if (player.getxPosition() + player.getxVelocity() < 0 || player.getxPosition() + player.getxVelocity() > this.frameWidth - (player.getWidth() + 14)) return false;
        else return true;
    }

    public void upPressed() {
        player.setyVelocity(-1.5);
    }

    public void downPressed() {
        player.setyVelocity(1.5);
    }

    public void leftPressed() {
        player.setxVelocity(-1.5);
    }

    public void rightPressed() {
        player.setxVelocity(1.5);
    }

    public void upReleased() {
        if (player.getyVelocity() < 0) player.setyVelocity(0);
    }

    public void downReleased() {
        if (player.getyVelocity() > 0) player.setyVelocity(0);
    }

    public void leftReleased() {
        if (player.getxVelocity() < 0) player.setxVelocity(0);
    }

    public void rightReleased() {
        if (player.getxVelocity() > 0) player.setxVelocity(0);
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code){
            case KeyEvent.VK_UP:
                upPressed();
                break;
            case KeyEvent.VK_DOWN:
                downPressed();
                break;
            case KeyEvent.VK_LEFT:
                leftPressed();
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code){
            case KeyEvent.VK_UP:
                upReleased();
                break;
            case KeyEvent.VK_DOWN:
                downReleased();
                break;
            case KeyEvent.VK_LEFT:
                leftReleased();
                break;
            case KeyEvent.VK_RIGHT:
                rightReleased();
                break;
        }
    }
}
