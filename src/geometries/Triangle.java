package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Plane {

    private Point3D point1;
    private Point3D point2;
    private Point3D point3;


    /********** Constructors ***********/
    public Triangle(Point3D point1, Point3D point2, Point3D point3) {
        super(point1, point2, point3);
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }


    /************** Getters/Setters *******/
    public Point3D getPoint1() {
        return point1;
    }

    public Point3D getPoint2() {
        return point2;
    }

    public Point3D getPoint3() {
        return point3;
    }

    /************** Operations ***************/

    private boolean sign(double i){
        if (i>0)
            return true;
        return false;
    }

    @Override
    public Vector getNormal(Point3D point) {
        return super.getNormal(point);
    }
    @Override
    public List<GeoPoint> findIntersections(Ray ray){
        Point3D t1=point1;
        Point3D t2=point2;
        Point3D t3=point3;
        Point3D p0=ray.getHead();
        Vector v11=t1.sub(p0);
        Vector v12=t2.sub(p0);
        Vector v21=t2.sub(p0);
        Vector v22=t3.sub(p0);
        Vector v31=t3.sub(p0);
        Vector v32=t1.sub(p0);
        Vector n1=v12.crossProduct(v11);
        n1.div(n1.size());
        Vector n2=v22.crossProduct(v21);
        n2.div(n2.size());
        Vector n3=v32.crossProduct(v31);
        n3.div(n3.size());
        List<GeoPoint> list=new ArrayList<GeoPoint>();
        list=super.findIntersections(ray);
        Point3D p=list.get(0).point;
        double i1=(p.sub(p0)).dotProduct(n1);
        double i2=(p.sub(p0)).dotProduct(n2);
        double i3=(p.sub(p0)).dotProduct(n3);
        boolean f1=sign(i1);
        boolean f2=sign(i2);
        boolean f3=sign(i3);
        if((f1&&f2&&f3)||!(f1||f2|f3))
            return list;
        return new ArrayList<GeoPoint>();
    }
}
