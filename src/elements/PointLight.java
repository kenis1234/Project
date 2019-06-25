package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

public class PointLight extends Light implements LightSource{
    private Point3D position;
    private double kc, kl, kq;

    public PointLight(Color color, Point3D position, double kc, double kl, double kq) {
        super(color);
        this.position = position;
        this.kc = kc;
        this.kl = kl;
        this.kq = kq;
    }

    public Point3D getPosition() {
        return position;
    }

    public double getKc() {
        return kc;
    }

    public double getKl() {
        return kl;
    }

    public double getKq() {
        return kq;
    }

    @Override
    public Color getIntensity(Point3D tmp) {
        double d=tmp.distance(position);
        double temp=1/(getKc()+getKl()*d+getKq()*d*d);
        temp*=color.getRGB();
        return new Color((int)temp);
    }

    @Override
    public Vector getL(Point3D p) {
        return p.sub(position);
    }
    @Override
    public Vector getD(Point3D p) {
        return null;
    }
}
