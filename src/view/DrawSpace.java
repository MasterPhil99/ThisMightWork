package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

public class DrawSpace extends JPanel implements ActionListener, KeyListener {
    Timer timer = new Timer(5, this);

    double xPosition = 1;
    double yPosition = 1;
    double xVelocity = 0;
    double yVelocity = 0;
    double width = 10;
    double height = 10;
    int frameWidth;
    int frameHeight;

    public DrawSpace(int frameWidth, int frameHeight) {
        timer.start();
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D circle = new Rectangle2D.Double(xPosition, yPosition, width, height);
        g2.fill(circle);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (keepXInBounds()) {
            this.xPosition += xVelocity;
        }
        if (keepYInBounds()) {
            this.yPosition += yVelocity;
        }
        repaint();
    }

    private boolean keepYInBounds() {
        if (this.yPosition + this.yVelocity < 0 || this.yPosition + this.yVelocity > this.frameHeight - (this.height + 38)) return false;
        else return true;
    }

    private boolean keepXInBounds() {
        if (this.xPosition + this.xVelocity < 0 || this.xPosition + this.xVelocity > this.frameWidth - (this.width + 14)) return false;
        else return true;
    }

    public void upPressed() {
        this.yVelocity = -1.5;
    }

    public void downPressed() {
        this.yVelocity = 1.5;
    }

    public void leftPressed() {
        this.xVelocity = -1.5;
    }

    public void rightPressed() {
        this.xVelocity = 1.5;
    }

    public void upReleased() {
        if (this.yVelocity < 0) this.yVelocity = 0;
    }

    public void downReleased() {
        if (this.yVelocity > 0) this.yVelocity = 0;
    }

    public void leftReleased() {
        if (this.xVelocity < 0) this.xVelocity = 0;
    }

    public void rightReleased() {
        if (this.xVelocity > 0) this.xVelocity = 0;
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
