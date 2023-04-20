package edu.guilford.RecursiveCircles.src.recursivecircles;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 *
 * @author rmw
 * 
 * CircleColor extends Ellipse2D.Double to define only circles
 * and give them a random color
 */
public class CircleColor extends Ellipse2D.Double {
    // add some attributes
    private double centerX;
    private double centerY;
    private double radius;
    private Color color;
    private Random rand = new Random();
    
    // constructor takes the x, y, and radius of a circle, constructs 
    // the corresponding ellipse, and adds a Color attribute
    public CircleColor(double centerX, double centerY, double radius) {
        // We first need to build an Ellipse2D object with the correct 
        // information--we use the super() method to do that because
        // Ellipse2D is a superclass for CircleColor. The super() method uses
        // the constructor for the Ellipse2D class
        super(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        // now set the attributes to the values from the parameters
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        // instantiate a random color
        int red = rand.nextInt(255);
        int green = rand.nextInt(255);
        int blue = rand.nextInt(255);
        int opacity = rand.nextInt(150) + 100;
        color = new Color(red, green, blue, opacity);
        
    }
    
    // add getters and setters

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
}
