package edu.guilford.RecursiveCircles.src.recursivecircles;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author rmw
 */
public class RecursiveCirclePanel extends JPanel {

    // attributes
    private int panelHeight;
    private int panelWidth;
    private static double MIN_RADIUS = 1;
    // by how much do we reduce the radius on each recursive call
    private double reduceFactor = 0.5;
    // what does our first circle look like?
    private double initialX;
    private double initialY;
    private double radius;
    // and let's keep a list of circles
    private ArrayList<CircleColor> circles = new ArrayList<CircleColor>();
    private Random rand = new Random();

    // constructor to place an initial circle and send the message to
    // start drawing all the circles
    public RecursiveCirclePanel(int panelHeight, int panelWidth) {
        this.panelHeight = panelHeight;
        this.panelWidth = panelWidth;
        // set the size of the panel using our parameters
        setPreferredSize(new Dimension(panelWidth, panelHeight));
        initialX = 400;
        initialY = 500;
        
        // Step 5: Connect the listener object to the panel
        // Instantiate a mouse listener object
        mListener mouseListener = new mListener();
        // Connect it to the panel
        addMouseListener(mouseListener);
        radius = rand.nextDouble() * 150 + 30;  
        drawAllCircles();
        repaint();
    }
    
    // method to start the circle drawing process
    public void drawAllCircles() {
        // clear any existing circles before drawing a new batch
        System.out.println("Number of circles before clear: " + circles.size());
        circles.clear();
        System.out.println("Number of circles after clear: " + circles.size());
       // radius = rand.nextDouble() * 150 + 30;
        addCircle(initialX, initialY, radius);
        repaint();
    }

    // recursive method for adding circles to the list of circles to be drawn
    // each circle has a center and a radius
    public void addCircle(double cx, double cy, double radius) {
        // instantiate a new circle
        CircleColor theCircle = new CircleColor(cx, cy, radius);
        // add it to the list
        circles.add(theCircle);
        // if we're not at the base case, keep on adding circles
        if (radius > MIN_RADIUS) {
            // calculate values for the shifted smaller circle
            // generate a reduction factor from reduceFactor to 0.9
            double factor = rand.nextDouble() * reduceFactor + (0.9 - reduceFactor);
            double newRadius = radius * factor;
            double angle = rand.nextDouble() * Math.PI;
            double newX = cx + (radius + newRadius) * Math.cos(angle);
            double newY = cy + (radius + newRadius) * Math.sin(angle);
            addCircle(newX, newY, newRadius);
            double newX2 = cx - (radius + newRadius) * Math.cos(angle);
            double newY2 = cy - (radius + newRadius) * Math.sin(angle);
            addCircle(newX2, newY2, newRadius);

        }
    }
    // MouseAdapter has empty listeners defined for all mouse events
    // We can then override whichever event listener we want to use
    public class mListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            // Print out the event
            System.out.println("We clicked the mouse: " + e);
            // get initial values for the circle drawing from the event    
            initialX = e.getX();
            initialY = e.getY();
            // draw a new set of circles
            drawAllCircles();
            // anytime we want to regenerate the drawing, we need a repaint call
            repaint(); // calls paintComponent
        }
    }
    
    
    // if we're going to draw in a JPanel object (like drawing circles, not
    // adding buttons or other components), we use the paintComponent method
    @Override
    public void paintComponent(Graphics g) {
        // magic code for better 2D graphics
        // Tell the original JPanel to run its paintComponent method that draws nogthing
        // That should clear the window and make it available for drawing
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // draw some circles
        // instantiate a CircleColor object
        // CircleColor circle = new CircleColor(100, 100, 50);
        for (CircleColor circle : circles) {
            // use g2.setColor to set the drawing color with the value from the object
            g2.setColor(circle.getColor());
            // draw the filled circle
            g2.fill(circle);
        }

        
        
    }

    public double getReduceFactor() {
        return reduceFactor;
    }

    public void setReduceFactor(double reduceFactor) {
        this.reduceFactor = reduceFactor;
    }

    public double getInitialX() {
        return initialX;
    }

    public void setInitialX(double initialX) {
        this.initialX = initialX;
    }

    public double getInitialY() {
        return initialY;
    }

    public void setInitialY(double initialY) {
        this.initialY = initialY;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public ArrayList<CircleColor> getCircles() {
        return circles;
    }

    public void setCircles(ArrayList<CircleColor> circles) {
        this.circles = circles;
    }

}
