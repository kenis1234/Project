package elements;


import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.max;

public class SpotLight extends PointLight {
    public Vector direction;

    /********** Constructors ***********/
    public SpotLight(Color color, Point3D position, double kc, double kl, double kq, Vector direction) {
        super(color, position, kc, kl, kq);
        this.direction = new Vector(direction.normalize());
    }  //our constructor


    /************** Getters/Setters *******/
    public Vector getDirection() {
        return direction;
    }       //gets the direction

    /************** Operations ***************/
    /*public Color getIntensity(Point3D tmp) {
        Vector v=new Vector(direction);
        Vector u=tmp.sub(getPosition());
        v.normalize();
        u.normalize();
        return mult(super.getIntensity(tmp),max(0,v.dotProduct(u)));
    }*/

    public Color getIntensity(Point3D point) {
        double d=this.getPosition().distance(point);
        double t1= this.getKc()+this.getKl()*d+this.getKq()*d*d;
        double t2=direction.dotProduct(this.getL(point));
        double t3=abs(t1*t2);
        return mult(color,t3);
    }

    @Override
    public Vector getL(Point3D p) {
        return new Vector(direction);
    } //returns the direction of the light???????

    @Override
    public Vector getD(Point3D p) {
        return null;
    }     //?????
}

