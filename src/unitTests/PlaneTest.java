package unitTests;

import geometries.Intersectable;
import geometries.Plane;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class PlaneTest {
    Plane plane=new Plane(new Point3D(1,0,0),new Point3D(1,1,1),new Point3D(1,1,0));
    @Test
    void getNormal() {
        Vector vector = plane.getNormal(new Point3D(10, 0, 0));
        assertEquals("Vector{head=Point3D{x=-1.0, y=0.0, z=0.0}}", vector.toString());
    }

    @Test
    void func1() {
        Plane p=new Plane(new Point3D(100, 0,0),new Vector(-1,0,0));
        Vector v=new Vector(1,2,0);
        Point3D point3D=new Point3D(0,0,0);
        Point3D point=p.findIntersections(new Ray(v,point3D)).get(0).point;
        System.out.println(point);
        assertEquals(100, point.getCoordinate_x().get());
        assertEquals(200, point.getCoordinate_y().get());

    }

    @Test
    void func2() {
        Plane p=new Plane(new Point3D(30, 0,0),new Point3D(5,1,1),new Point3D(20,1,0));
        Vector v=new Vector(1,2,0);
        Point3D point3D=new Point3D(0,0,0);
        Point3D point=p.findIntersections(new Ray(v,point3D)).get(0).point;
        System.out.println(point);
        assertEquals(1.43, point.getCoordinate_x().get(), 0.01);
        assertEquals(2.86, point.getCoordinate_y().get(), 0.01);

    }

    @Test
    void func3() {
        Plane p=new Plane(new Point3D(30, 0,0),new Point3D(5,1,1),new Point3D(100,1,0));
        Vector v=new Vector(1,2,0);
        Point3D point3D=new Point3D(0,0,0);
        List<Intersectable.GeoPoint> g = p.findIntersections(new Ray(v,point3D));
        boolean flag = false;
        if(g.isEmpty())
            flag = true;

        assertEquals(flag,true);

    }
}
