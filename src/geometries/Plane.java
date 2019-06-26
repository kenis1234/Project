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
    }
    public Plane(Point3D point1, Point3D point2, Point3D point3)
    {
        point=point1;
        plumb=(point1.sub(point2)).crossProduct(point1.sub(point3));
    }


    /************** Getters/Setters *******/
    public Point3D getPoint() {
        return point;
    }

    public Vector getPlumb() {
        return plumb;
    }

    /************** Operations ***************/
    @Override
    public Vector getNormal(Point3D point) {
        return new Vector(plumb.normalize());
    }

    @Override
    public List<GeoPoint> findIntersections(Ray ray){
        List<GeoPoint> list=new ArrayList<GeoPoint>();
        Vector n=new Vector(plumb);
        Point3D q0=point;
        Vector v=new Vector(ray.getDirection());
        Point3D p0=new Point3D(ray.getHead());
        if(n.dotProduct(v)==0)
            return list;
        Vector l=p0.sub(q0);
        l.div(n.dotProduct(v));
        double t=(n.mult(-1)).dotProduct(l);
        Point3D p=p0.add(v.mult(t));
        list.add(new GeoPoint(this, p));
        return list;
    }
}
