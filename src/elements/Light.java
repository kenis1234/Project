package elements;
import primitives.Point3D;
import java.awt.Color;

import static java.lang.Math.min;

public abstract class Light {
    Color color;

    /********** Constructors ***********/

    /**
     * Constructor that receives color and creates the  Light
     * @param color The color of the Light
     */
    public Light(Color color) {
        this.color = new Color(color.getRGB());
    }  //copy constructor


    /************** Getters/Setters *******/

    /**
     * Get the color of the Light
     * @return
     */
    public Color getColor() {
        return color;
    }             //get the color


    /************** Operations ***************/
    public abstract Color getIntensity(Point3D tmp);      //abstract function that all lights have to implement
    /**
     * The function multiplies color with an attenuation coefficient
     * @param color The color
     * @param ka The reduction factor KA
     * @return The result of the multiplies between the color with the reduction factor KA
     */
    public Color mult(Color color, double ka){
        int r=min((int)(color.getRed()*ka),255);
        int g=min((int)(color.getGreen()*ka),255);
        int b=min((int)(color.getBlue()*ka),255);
        return new Color(r,g,b);
    }        //mult a color with a skalar
}
