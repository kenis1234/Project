package geometries;

import primitives.Material;
import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

public abstract class Geometry implements Intersectable {

    public abstract Vector getNormal(Point3D point);            //so all the geometries have to implement

    public Color getEmission() {
        return emission;
    }                   //get the emission

    public Material getMaterial() {
        return material;
    }                //get the material

    public void setMaterial(Material material) {
        this.material = new Material(material);
    }        //set the material

    public void setEmission(Color emission) {
        this.emission = new Color(emission.getRGB());
    }     //set the emission


    Color emission;        //the color of the geometry
    Material material;      //the properties of the material of the geometry
}
