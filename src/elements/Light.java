package elements;
import primitives.Point3D;
import java.awt.Color;

import static java.lang.Math.min;

public abstract class Light {
    Color color;

    /********** Constructors ***********/
    public Light(Color color) {
        this.color = new Color(color.getRGB());
    }  //copy constructor


    /************** Getters/Setters *******/
    public Color getColor() {
        return color;
    }             //get the color


    /************** Operations ***************/
    public abstract Color getIntensity(Point3D tmp);      //abstract function that all lights have to implement

    public Color mult(Color color, double ka){
        int r=min((int)(color.getRed()*ka),255);
        int g=min((int)(color.getGreen()*ka),255);
        int b=min((int)(color.getBlue()*ka),255);
        return new Color(r,g,b);
    }        //mult a color with a skalar
}
