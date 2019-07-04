//Bs"d
package elements;

import java.awt.Color;
import primitives.Point3D;

public class AmbientLight extends Light{
    private double ka;

    /********** Constructors ***********/
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
