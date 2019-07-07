//Bs"d
package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.*;

public class Plane extends Geometry implements FlatGeometry {
    private Point3D point;
    private Vector plumb;

    /********** Constructors ***********/

    /**
     * Constructor that gets a plumb vector and creates a plane
     * @param point
     * @param plumb
     */
    public Plane(Point3D point, Vector plumb) {
        this.point = point;
        this.plumb = plumb;
    }                      // Constructor that initializing the plane by point and the plumb vector

    /**
     * Constructor that initializes the plane by three points
     * @param point1 The point number 1
     * @param point2 The point number 2
     * @param point3 The point number 3
     */
    public Plane(Point3D point1, Point3D point2, Point3D point3)         // Constructor that initializes the plane by three points
    {
        point=point1;
        plumb=(point1.sub(point2)).crossProduct(point1.sub(point3)); // Produces the plumb vector by a cross product of two vectors created between the three points
    }


    /************** Getters/Setters *******/

    /**
     * Get the point on the plane
     * @return The point on the plane
     */
    public Point3D getPoint() {
        return point;
    }                          // Return the point of the Plane

    /**
     * Get the plumb vector
     * @return The plumb vector
     */
    public Vector getPlumb() {
        return plumb;
    }                           // Return the vector plumb of the Plane


    /************** Operations ***************/

    /**
     *  Return the normal of the Plane
     * @param point The point of the plane
     * @return The normal of the Plane
     */
    @Override
    public Vector getNormal(Point3D point) {
        return new Vector(plumb.normalize());
    }  // Return the normal of the Plane

    /**
     * Finds all the points of intersection of the given ray with the plane
     * @param ray The ray with which the cutting with the plane is calculated
     * @return All the points of intersection of the ray with the plane
     */
    @Override
    public List<GeoPoint> findIntersections(Ray ray){
        List<GeoPoint> list=new ArrayList<GeoPoint>();
        Vector n=new Vector(plumb);                           //the normal of te plane
        Point3D q0=point;
        Vector v=new Vector(ray.getDirection());                //direction of the ray
        Vector v1=new Vector(ray.getDirection());
        Point3D p0=new Point3D(ray.getHead());
        if(n.dotProduct(v)==0)                        //if ze anach lamishor
            return list;
        Vector l=p0.sub(q0);
        l.div(n.dotProduct(v));
        double t=(n.mult(-1)).dotProduct(l);               //it is the calculation from the lecture
        Point3D p=p0.add(v.mult(t));
        list.add(new GeoPoint(this, p));
        if((p.sub(ray.getHead()).dotProduct(v1))<0)
            return new ArrayList<GeoPoint>();
        return list;
    }                      //find intersection point of ray with the plane
}
