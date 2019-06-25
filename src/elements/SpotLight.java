package elements;


import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

import static java.lang.StrictMath.max;

public class SpotLight extends PointLight {
    public Vector direction;


    public SpotLight(Color color, Point3D position, double kc, double kl, double kq, Vector direction) {
        super(color, position, kc, kl, kq);
        this.direction = direction;
    }

    public Vector getDirection() {
        return direction;
    }


    public Color getIntensity(Point3D tmp) {
        Vector v=new Vector(direction);
        Vector u=tmp.sub(getPosition());
        v.normalize();
        u.normalize();
        return new Color((int)((super.getIntensity(tmp).getRGB())*(max(0,v.dotProduct(u)))));
    }
}

