/* Based on the ecs 100 template
 * Code for creating a table lamp
 * Name: Keira Malan    
 * Date: 20/5/21
 */


import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;


/** Create a table lamp w multiple functions
 */
public class Lamp{
    // Fields
    private boolean lightOn = true;
    
    // predefined positions
    
    // diameter of bulb
    private double BULBSIZE = 80;
    
    private double bulbX = 300;
    private double bulbY = 100;
    private final double STEMTOP = 300;
    private final double STEMWIDTH = BULBSIZE/4;
    private final double STEMHEIGHT = 80;
    
    
    // pre set color to black
    private Color bulbColor = Color.black;

    /**  Constructor */
    public Lamp(double x, double y){
        this.bulbX = x;
        this.bulbY = y;
    }
    
    // draw method
    public void draw() {
        double left = bulbX-BULBSIZE/2.0; // left of bulb
        double top = bulbY-BULBSIZE/2.0; // top of bulb
        
        // set stem color to dark gray
        UI.setColor(Color.darkGray);
        UI.setLineWidth(STEMWIDTH);
        
        // draw stem
        UI.drawLine(bulbX, bulbY, bulbX, bulbY+STEMHEIGHT);

        // set bulb color
        UI.setColor(bulbColor);
        
        // draw bulb
        UI.fillOval(left, top, BULBSIZE, BULBSIZE);
    }

    /** 
     * Reports whether the point (x,y) is on the bulb.
     * (x and y represent the position where the mouse was released):
     */
    public boolean onBulb(double x, double y){
        boolean onBulb = false;
        // an easy approximation is to pretend it is the enclosing rectangle.
        // It is nicer to do a little bit of geometry and get it right
        // check if mouse is on bulb
        if ((x >= bulbX) && (x <= bulbX+BULBSIZE) 
        && (y >= bulbY) && (y <= bulbY+BULBSIZE)) {
            onBulb = true;
        }
        return onBulb;
    }   
    
    /**
     * Reports whether the point (x,y) is on the stem.
     * (x and y represent the position where the mouse was released):
     */
    public boolean onStem(double x, double y){
        boolean onStem = false;
        // check if mouse is on stem
         if ((x >= bulbX) && (x <= bulbX+STEMWIDTH) 
        && (y >= STEMTOP-STEMHEIGHT) && (y <= STEMTOP)) {
            onStem = true;
        }
        return onStem;
    }   
    
    /**
     * Turns the light off.
     * Does not redraw
     */
    public void turnOff(){
        // set bulb color to black to turn it off
        Color bulbColor = Color.black;
        lightOn = false;
    }   

    /** changeColor method (no parameters):
     * Turns the light on (if it is off)
     * Changes its color to a random bright colour (if it is already on).
     * Does not redraw
     */
    public void changeColor(){
        // if light is off turn it on
        if (lightOn = false) {
            lightOn = true;
        }

        //choose random color for drawing
        Color bulbColor = Color.getHSBColor((float)(Math.random()), 1.0f, 1.0f);
    }   
}

