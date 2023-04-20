package edu.guilford.RecursiveCircles.src.recursivecircles;

import javax.swing.JFrame;

/**
 *
 * @author rmw
 */
public class RecursiveCircles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Declare and instantiate a JFrame that is our window
        JFrame recursiveWindow = new JFrame("Circles!");
        recursiveWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Instantiate a RecursiveCirclePanel object and add it to the window
        RecursiveCirclePanel panel = new RecursiveCirclePanel(1200, 1000);
        recursiveWindow.add(panel);
        
        
        // Tell the window to arrange all the components it's going to display
        // and make it visible
        recursiveWindow.pack();
        recursiveWindow.setVisible(true);
        
        // Create a window for the control panel and populate it
        JFrame controls = new JFrame("Control Panel");
        controls.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Instantiate a ControlPanel object and add it to the window
        ControlPanel controlPanel = new ControlPanel();
        controls.add(controlPanel);
        
        // Arrange the components and make the window visible
        controls.pack();
        controls.setVisible(true);
        // move the window to a new location on the screen
        controls.setLocation(800, 50);
        
        // Now we can tell the control panel which RecursiveCirclePanel object
        // it's communicating with
        controlPanel.setCirclePanel(panel);
    }
    
}
