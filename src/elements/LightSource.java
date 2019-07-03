package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

public interface LightSource {
    public Color getIntensity(Point3D p);               //get the calculation of the color
    public Vector getL(Point3D p);                      //returns the direction of the light
}
