package unitTests;

import elements.AmbientLight;
import elements.Camera;
import elements.PointLight;
import elements.SpotLight;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.Test;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

import java.awt.*;

public class OurTest {

    @Test
    public void ourtest(){
        Scene scene = new Scene();
        scene.setBackground(new Color(57, 0, 0));
        scene.setAmbient(new AmbientLight(new Color(255,255,255),0.05));
        scene.setCameraAndDistance(new Camera(),200);
        Sphere sphere1=new Sphere(200, new Point3D(-200,0,-1000));
        Sphere sphere2=new Sphere(100, new Point3D(100,0,-1000));
        Sphere sphere3=new Sphere(50, new Point3D(250,0,-1000));
        Sphere sphere4=new Sphere(20, new Point3D(260,20,-1000));
        Sphere sphere6=new Sphere(100, new Point3D(-300,0,-1000));

        sphere1.setMaterial(new Material(1,1,0,1,20));
        sphere2.setMaterial(new Material(1,1,0,0,20));
        sphere3.setMaterial(new Material(1,1,0,0.5,20));
        sphere4.setMaterial(new Material(1,1,0,0,20));
        sphere6.setMaterial(new Material(1,1,0,0,20));

        sphere1.setEmission(new Color(48, 48, 48));
        sphere2.setEmission(new Color(152, 152, 152));
        sphere3.setEmission(new Color(43, 43, 43));
        sphere4.setEmission(new Color(4, 0, 255));
        sphere6.setEmission(new Color(255, 10, 0));

        scene.addGeometry(sphere1);
        scene.addGeometry(sphere2);
        scene.addGeometry(sphere3);
        scene.addGeometry(sphere4);
        scene.addGeometry(sphere6);

        Plane plane=new Plane(new Point3D(-400,0,0),new Vector(1,0,0));
        plane.setMaterial(new Material(1,1,0.5,0,20));
        plane.setEmission(new Color(0, 107, 0));
        scene.addGeometry(plane);

        Triangle triangle3=new Triangle(new Point3D(250,100,-1000),new Point3D(250,50,-1000),new Point3D(220,40,-1000));
        triangle3.setMaterial(new Material(1,1,0,0,20));
        triangle3.setEmission(new Color(255, 101, 0));
        scene.addGeometry(triangle3);

        scene.addLight(new SpotLight(new Color(255, 0, 0),  new Point3D(100, 500, -900),
                0, 0.00001, 0.000005,new Vector(-2, -2, -3)));

        scene.addLight(new SpotLight(new Color(0, 18, 255),  new Point3D(100, -500, -900),
               0, 0.00001, 0.000005,new Vector(-2, 2, -3)));

        scene.addLight(new PointLight(new Color(255, 255, 0),  new Point3D(1000, 800, -1000),
              0, 0.00001, 0.000005));


        ImageWriter imageWriter = new ImageWriter("Our Test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage(true);
    }
}
