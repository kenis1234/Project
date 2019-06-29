package elements;


import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

import static java.lang.StrictMath.max;

public class SpotLight extends PointLight {
    public Vector direction;

    /********** Constructors ***********/
    public SpotLight(Color color, Point3D position, double kc, double kl, double kq, Vector direction) {
        super(color, position, kc, kl, kq);
        this.direction = direction;
    }  //our constructor


    /************** Getters/Setters *******/
    public Vector getDirection() {
        return direction;
    }       //gets the direction

    /************** Operations ***************/
    public Color getIntensity(Point3D tmp) {
        Vector v=new Vector(direction);
        Vector u=tmp.sub(getPosition());
        v.normalize();
        u.normalize();
        return mult(super.getIntensity(tmp),max(0,v.dotProduct(u)));
    }

    @Override
    public Vector getL(Point3D p) {
        return p.sub(position);
    } //returns the direction of the light???????

    @Override
    public Vector getD(Point3D p) {
        return null;
    }     //?????
}

