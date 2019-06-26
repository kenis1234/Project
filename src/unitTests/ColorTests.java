package unitTests;

import elements.AmbientLight;
import elements.Camera;
import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.Test;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

import javax.swing.*;
import java.awt.*;

public class ColorTests {


    @Test
    public void f1() {
        Triangle t1 = new Triangle(new Point3D(200, 200, -200), new Point3D(200, 0, -200), new Point3D(0, 200, -200));
        Triangle t2 = new Triangle(new Point3D(-200, 200, -200), new Point3D(0, 200, -200), new Point3D(-200, 0, -200));
        Triangle t3 = new Triangle(new Point3D(0, -200, -200), new Point3D(-200, -200, -200), new Point3D(-200, 0, -200));
        Triangle t4 = new Triangle(new Point3D(0, -200, -200), new Point3D(200, -200, -200), new Point3D(200, -0, -200));
        Sphere s = new Sphere(100, new Point3D(0, 0, -200));
        Scene scene = new Scene("testemission");
        String imageName = "testemission";
        double width = 500;
        double height = 500;
        int nX = 500;
        int nY = 500;
        t4.setEmission(new Color(73, 200, 54));
        t1.setEmission(new Color(30, 30, 30));
        t3.setEmission(new Color(200, 64, 95));
        t2.setEmission(new Color(57, 84, 200));
        s.setEmission(new Color(30, 30, 30));
        ImageWriter im = new ImageWriter(imageName, width, height, nX, nY);
        scene.addGeometry(t1);
        scene.addGeometry(t2);
        scene.addGeometry(t3);
        scene.addGeometry(t4);
        scene.addGeometry(s);
        scene.setBackground(new Color(0, 0, 0));
        scene.setAmbient(new AmbientLight(new Color(20, 20, 20), 1));
        scene.setCameraAndDistance(new Camera(), 100);
        Render r = new Render(im, scene);
        r.renderImage();
    }

    /*@Test
    public void f2() {
        Triangle t1 = new Triangle(new Point3D(200,200,-200), new Point3D(-200,-200,-200), new Point3D(300,-200,-100));
        Triangle t2 = new Triangle(new Point3D(200,200,-200), new Point3D(-200,-200,-200), new Point3D(-300,200,-350));

    }*/

    @Test
    public void spotLightTest2() {
        Scene scene = new Scene("");
        scene.setBackground(new Color(0, 0, 0));
        scene.setAmbient(new AmbientLight(new Color(255, 255, 255), 0.1));
        scene.setCameraAndDistance(new Camera(), 200);

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setMaterial(new Material(1, 1, 1, 1, 20));
        sphere.setEmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(
                new Point3D(-125, -225, -260),
                new Point3D(-225, -125, -260),
                new Point3D(-225, -225, -270));

        triangle.setEmission(new Color(0, 0, 100));
        triangle.setMaterial(new Material(1, 1, 1, 1, 4));
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(
                new Color(255, 255, 255), new Point3D(-200, -200, -150),
                0.1, 0.00001, 0.000005, new Vector(2, 2, -3)));


        ImageWriter imageWriter = new ImageWriter("Spot test 2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);
        render.renderImage();
    }

}
