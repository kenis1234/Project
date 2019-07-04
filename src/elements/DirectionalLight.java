//Bs"d
package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

public class DirectionalLight extends Light implements LightSource{
    private Vector direction;

    /********** Constructors ***********/
    public DirectionalLight(Color color, Vector direction) {
        super(color);
        this.direction = direction;
    }        //construct of directional light - gets color and direction


    /************** Getters/Setters *******/
    public Vector getDirection() {
        return new Vector(direction);
    }    //get the direction of the light


    /************** Operations ***************/
    @Override
    /**
     * get intensity of the light in some point
     * @param point - the point we check the light in
     * @return - the calculated color
     */
    public Color getIntensity(Point3D p) {
        return new Color(color.getRGB());
    }  //get the calculation of the color

    @Override
    public Vector getL(Point3D p) {
        return new Vector(direction);
    }              //returns the direction of the light
}
