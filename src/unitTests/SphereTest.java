package unitTests;

import geometries.Intersectable;
import geometries.Sphere;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SphereTest {
    Sphere sphere=new Sphere(10,new Point3D(0,0,0));
    @org.junit.Test
    public void getNormal() {
        Vector vector=sphere.getNormal(new Point3D(10,0,0));
        //assertEquals("Vector{head=Point3D{x=1.0, y=0.0, z=0.0}}",vector.toString());
    }

    @org.junit.Test
    public void inter1() {
        Sphere s=new Sphere(10,new Point3D(20,20,0));
        Ray ray=new Ray(new Vector(1,1,0),new Point3D(0,0,0));
        List<Intersectable.GeoPoint> g=s.findIntersections(ray);
        if(g.isEmpty())
            System.out.println("is empty!");

        System.out.println(g.get(0).point);
        System.out.println(g.get(1).point);

        assertEquals(12.93,g.get(0).point.getCoordinate_x().get(),0.01);
        assertEquals(27.07,g.get(1).point.getCoordinate_x().get(),0.01);
        //assertEquals("Vector{head=Point3D{x=1.0, y=0.0, z=0.0}}",vector.toString());
    }

    @org.junit.Test
    public void inter2() {
        Sphere s=new Sphere(10,new Point3D(0,0,0));
        Ray ray=new Ray(new Vector(1,1,0),new Point3D(0,0,0));
        List<Intersectable.GeoPoint> g=s.findIntersections(ray);
        if(g.isEmpty())
            System.out.println("is empty!");

        System.out.println(g.get(0).point);

        assertEquals(7.07,g.get(0).point.getCoordinate_x().get(),0.01);
        //assertEquals("Vector{head=Point3D{x=1.0, y=0.0, z=0.0}}",vector.toString());
    }

    @org.junit.Test
    public void inter3() {
        Sphere s=new Sphere(10,new Point3D(20,20,0));
        Ray ray=new Ray(new Vector(10,1,0),new Point3D(0,0,0));
        List<Intersectable.GeoPoint> g=s.findIntersections(ray);
        String a = new String();

        if(g.isEmpty()) {
            a = new String("is empty!");
        }

        assertEquals(a,"is empty!");
        //assertEquals("Vector{head=Point3D{x=1.0, y=0.0, z=0.0}}",vector.toString());
    }
}
