//Bs"d

package elements;

import primitives.Point3D;
import primitives.Vector;
import renderer.Render;

import java.awt.*;

public class PointLight extends Light implements LightSource{
    protected Point3D position;
    protected double kc, kl, kq;


    /********** Constructors ***********/
    /**
     * constructor point light
     * @param color color
     * @param position - location
     * @param kc factor kc
     * @param kl factor kl
     * @param kq factor kq
     */
    public PointLight(Color color, Point3D position, double kc, double kl, double kq){
        super(color);
        this.position = position;
        this.kc = kc;
        this.kl = kl;
        this.kq = kq;
    } //constructor that gets color, location and 3 mekadmim


    /************** Getters/Setters *******/

    /**
     * Get the point position
     * @return The point position
     */
    public Point3D getPosition() {
        return position;
    }   //get the location

    /**
     * Get the factor kc
     * @return The factor kc
     */
    public double getKc() {
        return kc;
    }                //get kc

    /**
     * Get the pactor kl
     * @return The factor kl
     */
    public double getKl() {
        return kl;
    }                //get kl

    /**
     * Get the factor kq
     * @return The factor kq
     */
    public double getKq() {
        return kq;
    }                //get kq


    /************** Operations ***************/
    @Override
    /**
     * get intensity of the light in some point
     * @param point - the point we check the light in
     * @return - the calculated color
     */
    public Color getIntensity(Point3D tmp) {
        double d=tmp.distance(position);
        double temp=1/(getKc()+getKl()*d+getKq()*d*d);
        return mult(color,temp);
    }        //get the calculation of the color

    /**
     * Get the direction of the ligh
     * @param p
     * @return The direction of the ligh
     */
    @Override
    public Vector getL(Point3D p) {
        return p.sub(position).normalize();
    } //returns the direction of the light

}
