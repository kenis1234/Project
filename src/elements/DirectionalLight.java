package elements;

import java.awt.Color;
import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

public class DirectionalLight extends Light implements LightSource{
    private Vector direction;

    public DirectionalLight(Color color, Vector direction) {
        super(color);
        this.direction = direction;
    }

    public Vector getDirection() {
        return direction;
    }

    @Override
    public Color getIntensity(Point3D p) {
        return new Color(color.getRGB());
    }

    @Override
    public Vector getL(Point3D p) {
        return new Vector(direction);
    }

    @Override
    public Vector getD(Point3D p) {
        return null;
    }
}
