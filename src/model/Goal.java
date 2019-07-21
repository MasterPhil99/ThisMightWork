package model;

import java.awt.*;

public class Goal extends GameObject {
    public Goal(double xPosition, double yPosition, double xVelocity, double yVelocity, double width, double height) {
        super(xPosition, yPosition, xVelocity, yVelocity, width, height);
        super.setColor(Color.GREEN);
    }

}
