package model;

import java.awt.*;

public class Player extends GameObject {
    public Player(double xPosition, double yPosition, double xVelocity, double yVelocity, double width, double height) {
        super(xPosition, yPosition, xVelocity, yVelocity, width, height);
        super.setColor(Color.DARK_GRAY);
    }

}
