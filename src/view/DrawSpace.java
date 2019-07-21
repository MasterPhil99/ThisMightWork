package view;

import model.GameObject;
import model.Goal;
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
    Goal goal;
    GameObject obstacle;
    GameObject obstacle2;
    double frameWidth;
    double frameHeight;


    public DrawSpace(double frameWidth, double frameHeight) {
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        reset();
    }

    public void reset() {
        this.player = new Player(1,1,0, 0,10,10);
        this.goal = new Goal(this.frameWidth * 0.8, this.frameHeight * 0.8, 0, 0, 30, 30);
        this.obstacle = new GameObject(this.frameWidth * 0.5, 0, 0, 0, 5, this.frameHeight * 0.5);
        this.obstacle2 = new GameObject(this.frameWidth * 0.5, this.frameHeight * 0.6, 0, 0, 5, this.frameHeight);
        this.player.setColor(Color.BLACK);
        this.goal.setColor(Color.GREEN);
        this.timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D pl = new Rectangle2D.Double(player.getxPosition(), player.getyPosition(), player.getWidth(), player.getHeight());
        Rectangle2D go = new Rectangle2D.Double(goal.getxPosition(), goal.getyPosition(), goal.getWidth(), goal.getHeight());
        Rectangle2D obst = new Rectangle2D.Double(obstacle.getxPosition(), obstacle.getyPosition(), obstacle.getWidth(), obstacle.getHeight());
        Rectangle2D obst2 = new Rectangle2D.Double(obstacle2.getxPosition(), obstacle2.getyPosition(), obstacle2.getWidth(), obstacle2.getHeight());
        g2.setColor(player.getColor());
        g2.fill(pl);
        g2.setColor(goal.getColor());
        g2.fill(go);
        g2.setColor(Color.BLACK);
        g2.fill(obst);
        g2.setColor(Color.BLACK);
        g2.fill(obst2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (keepXInBounds()) {
            player.setxPosition(player.getxPosition() + player.getxVelocity());
        }
        if (keepYInBounds()) {
            player.setyPosition(player.getyPosition() + player.getyVelocity());
        }
        if (player.isCollision(goal)) {
            this.timer.stop();
            JOptionPane.showMessageDialog(this, "Congrats, you beat the level!");
            reset();
        }
        collisionDetection(obstacle);
        collisionDetection(obstacle2);

        repaint();
    }

    public void collisionDetection(GameObject obj){
        if (player.isCollision(obj)) {
            player.setxPosition(player.getxPosition() - player.getxVelocity());
            player.setyPosition(player.getyPosition() - player.getyVelocity());
        }
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
