package javaraytracer;

/*
 * RGBColour.java
 *
 * Created on 24 September 2006, 12:49
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author Daniel Cabral
 */
public class RGBColour {
    
    private double red;
    private double green;
    private double blue;
    
    /** Creates a new instance of RGBColour */
    public RGBColour(double red, double green, double blue) {
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
    }
    
    public double getRed() {
        return red;
    }
    
    public void setRed(double red) {
        this.red = red;
    }
    
    public double getGreen() {
        return green;
    }
    
    public void setGreen(double green) {
        this.green = green;
    }
    
    public double getBlue() {
        return blue;
    }
    
    public void setBlue(double blue) {
        this.blue = blue;
    }
    
    public int getPixel(){
        return (int)red << 16 | (int)green << 8 | (int)blue;
    }
    
    public void convert(){
        red = red * 255;
        green = green * 255;
        blue = blue * 255;
    }
    
    public void clamp(){
        // Clamp to keep color values between 0 and 255.
        if(red > 255.0d){
            red = 255.0d;
        }
        if(green > 255.0d){
            green = 255.0d;
        }
        if(blue > 255.0d){
            blue = 255.0d;
        }
    }
    
    public String toString(){
        return "Red:" + red + " Green:" + green + " Blue:" + blue;
    }
}
