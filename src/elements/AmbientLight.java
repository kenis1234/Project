//Bs"d
package elements;

import java.awt.Color;
import primitives.Point3D;

public class AmbientLight extends Light{
    private double ka;

    /********** Constructors ***********/

    /**
     *A constructor that receives color and an attenuation coefficient k and from which creates the AmbientLight
     * @param c The color of the AmbientLight
     * @param k The attenuation coefficient k
     */
    public AmbientLight(Color c, double k){
        super(c);
        ka=k;
    }    //constructor with color and kvua anhata


    /************** Operations ***************/
    /**
     * get intensity of the light in some point
     * @param t - the point we check the light in
     * @return - the calculated color
     */
    public Color getIntensity(Point3D t){
        return mult(color,ka);
    }    //calculating the color
}
