package geometries;

import primitives.Material;
import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

public abstract class Geometry implements Intersectable {
    public abstract Vector getNormal(Point3D point);

    public Color getEmission() {
        return emission;
    }

    public Material getMaterial() {
        return material;
    }

    public void setEmission(Color emission) {
        this.emission = emission;
    }

    Color emission;
    Material material;
}
