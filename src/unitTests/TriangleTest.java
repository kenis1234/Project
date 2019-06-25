package unitTests;

import geometries.Intersectable;
import geometries.Triangle;
import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    Triangle triangle = new Triangle(
            new Point3D(0.0,1.0,0.0),
            new Point3D(1.0,0.0,0.0),
            new Point3D(0.0,0.0,1.0));
    @Test
    void getNormal() {
        Vector v1=triangle.getNormal(null);
        assertEquals("Vector{head=Point3D{x=-0.5773502691896257, y=-0.5773502691896257, z=-0.5773502691896257}}",v1.toString());
    }
    @Test
    void getLengthNormal()
    {
        Vector v2 = triangle.getNormal(null);
        double  l = v2.size();
        assertEquals(1.0,l);
    }


    @Test
    void func1() {
        Point3D x=new Point3D(-100,-100,-200);
        Point3D y=new Point3D(100,-100,-200);
        Point3D z=new Point3D(0,100,-200);
        Triangle t=new Triangle(x,y,z);
        Vector v=new Vector(0,-1,-3);
        Point3D point3D=new Point3D(0,0,0);
        Point3D point=t.findIntersections(new Ray(v,point3D)).get(0).point;
        assertEquals(-66.6666, point.getCoordinate_y().get(),0.01);
    }

    @Test
    void func2() {
        Point3D x=new Point3D(10,10,50);
        Point3D y=new Point3D(20,50,-20);
        Point3D z=new Point3D(30,40,-10);
        Triangle t=new Triangle(x,y,z);
        Vector v=new Vector(1,5,0);
        Point3D point3D=new Point3D(0,0,0);
        List<Intersectable.GeoPoint> g = t.findIntersections(new Ray(v,point3D));

        boolean flag = false;
        if(g.isEmpty())
            flag = true;

        assertEquals(flag, true);
    }

}
