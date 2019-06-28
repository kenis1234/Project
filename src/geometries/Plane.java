//Bs"d
package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.*;

public class Plane extends Geometry {
    private Point3D point;
    private Vector plumb;

    /********** Constructors ***********/
    public Plane(Point3D point, Vector plumb) {
        this.point = point;
        this.plumb = plumb;
    }                      // Constructor that initializing the plane by point and the plumb vector
    public Plane(Point3D point1, Point3D point2, Point3D point3)         // Constructor that initializes the plane by three points
    {
        point=point1;
        plumb=(point1.sub(point2)).crossProduct(point1.sub(point3)); // Produces the plumb vector by a cross product of two vectors created between the three points
    }


    /************** Getters/Setters *******/
    public Point3D getPoint() {
        return point;
    }                          // Return the point of the Plane

    public Vector getPlumb() {
        return plumb;
    }                           // Return the vector plumb of the Plane


    /************** Operations ***************/
    @Override
    public Vector getNormal(Point3D point) {
        return new Vector(plumb.normalize());
    }  // Return the normal of the Plane

    @Override
    public List<GeoPoint> findIntersections(Ray ray){
        List<GeoPoint> list=new ArrayList<GeoPoint>();
        Vector n=new Vector(plumb);                           //the normal of te plane
        Point3D q0=point;
        Vector v=new Vector(ray.getDirection());                //direction of the ray
        Point3D p0=new Point3D(ray.getHead());
        if(n.dotProduct(v)==0)                        //if ze anach lamishor
            return list;
        Vector l=p0.sub(q0);
        l.div(n.dotProduct(v));
        double t=(n.mult(-1)).dotProduct(l);               //it is the calculation from the lecture
        Point3D p=p0.add(v.mult(t));
        list.add(new GeoPoint(this, p));
        return list;
    }                      //find intersection point of ray with the plane
}
