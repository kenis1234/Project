package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

public interface LightSource {
    public Color getIntensity(Point3D p);
    public Vector getL(Point3D p);
    public Vector getD(Point3D p);
}
