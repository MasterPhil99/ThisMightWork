package model;

import java.awt.*;

public class GameObject {
    private double xPosition;
    private double yPosition;
    private double xVelocity;
    private double yVelocity;
    private double width;
    private double height;
    private Color color;

    public GameObject(double xPosition, double yPosition, double xVelocity, double yVelocity, double width, double height) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.width = width;
        this.height = height;
    }

    public double getxPosition() {
        return xPosition;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public double getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Rectangle.Double getBounds() {
        return new Rectangle.Double(this.xPosition, this.yPosition, this.width, this.height);
    }

    public boolean isCollision(GameObject object) {
        if (this.getBounds().intersects(object.getBounds())) return true;
        else return false;
    }
}
