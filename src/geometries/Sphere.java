//bs"d
package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class Sphere extends RadialGeometry{
    private Point3D center;


    /********** Constructors ***********/
    public Sphere(double radius, Point3D point) {
        super(radius);
        this.center = point;
    }                                    //constructor that gets radius and the center


    /************** Getters/Setters *******/
    public Point3D getPoint() {
        return new Point3D( center);
    }                                                      //get the center point


    /*************** Admin *****************/
    @Override
    public boolean equals(Object sphere) {
        if(sphere==null)
            return false;
        if (!(sphere instanceof Sphere))                                   //if the point is a point
            return false;
        if (getRadius()==(((Sphere) sphere).getRadius()) && getPoint().equals( ((Sphere) sphere).getPoint()) )
            return true;
        return false;
    }                                   //checks if 2 spheres are equal

    @Override
    public String toString() {
        return "sphere: " +
                "radius = " + getRadius() +
                ",  " + getPoint() +
                '}';
    }                                              //print a sphere


    /************** Operations ***************/
    @Override
    public Vector getNormal(Point3D point) {
        return point.sub(center).normalize();
    }                                         //calculating the normal vector in some point

    @Override
    public List<GeoPoint> findIntersections(Ray ray)                                     //find intersections of ray with the sphere
    {
        List<GeoPoint> list=new ArrayList<GeoPoint>();
        Vector L = center.sub(ray.getHead());                                            //vector from the point to the center
        Vector V = new Vector(ray.getDirection());                                       //the direction of the ray
        double tm = L.dotProduct(V);
        double d = pow(L.dotProduct(L)-tm*tm,0.5);

        if(d > this.getRadius())                                                          //if there are not intersection points
            return list;
        double th= pow((getRadius()*getRadius()-d*d),0.5);
        double t1=tm-th;
        double t2=tm+th;
        Point3D p1= ray.getHead().add(ray.getDirection().mult(t1));                               //point that closer to us
        Point3D p2= ray.getHead().add(ray.getDirection().mult(t2));                                //second intersection point
        if(t1>0)
            list.add(new GeoPoint(this,p1));
        if(t2>0)
            list.add(new GeoPoint(this,p2));
        return list;
    }
}
