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
    }


    /************** Getters/Setters *******/
    public Point3D getPoint() {
        return center;
    }

    /************** Operations ***************/
    @Override
    public Vector getNormal(Point3D point) {
        return point.sub(center).normalize();
    }

    @Override
    public List<GeoPoint> findIntersections(Ray ray)
    {
        List<GeoPoint> list=new ArrayList<GeoPoint>();
        Vector L = center.sub(ray.getHead());
        Vector V = new Vector(ray.getDirection());
        double tm = L.dotProduct(V);
        double d = pow(L.dotProduct(L)-tm*tm,0.5);

        if(d > this.getRadius())
            return list;
        double th= pow((getRadius()*getRadius()-d*d),0.5);
        double t1=tm-th;
        double t2=tm+th;
        Point3D p1= ray.getHead().add(ray.getDirection().mult(t1));
        Point3D p2= ray.getHead().add(ray.getDirection().mult(t2));
        if(t1>0)
            list.add(new GeoPoint(this,p1));
        if(t2>0)
            list.add(new GeoPoint(this,p2));

        return list;
    }
}
