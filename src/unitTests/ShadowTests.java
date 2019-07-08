// Bs"d

package unitTests;

import elements.*;
import geometries.*;
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
import java.util.ArrayList;

public class ShadowTests {


    @Test
    public void spotLightTest2() {
        Scene scene = new Scene("");
        scene.setBackground(new Color(0, 0, 0));
        scene.setAmbient(new AmbientLight(new Color(255, 255, 255), 0.1));
        scene.setCameraAndDistance(new Camera(), 200);

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setMaterial(new Material(1, 1, 0, 0, 20));
        sphere.setEmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(
                new Point3D(-125, -225, -260),
                new Point3D(-225, -125, -260),
                new Point3D(-225, -225, -270));

        triangle.setEmission(new Color(0, 0, 100));
        triangle.setMaterial(new Material(0.3, 2, 0, 0, 4));
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(
                new Color(255, 100, 100), new Point3D(-200, -200, -150),
                0.1, 0.00001, 0.000005, new Vector(2, 2, -3)));


        ImageWriter imageWriter = new ImageWriter("Spot test with shadow", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);
        render.renderImage(true);
    }

    @Test
    public void spotLightTest3() {
        Scene scene = new Scene("");
        scene.setBackground(new Color(0, 0, 0));
        scene.setAmbient(new AmbientLight(new Color(255, 255, 255), 0.01));
        scene.setCameraAndDistance(new Camera(), 200);

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setMaterial(new Material(1, 1, 0, 0, 20));
        sphere.setEmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(
                new Point3D(-150, -200, -260),
                new Point3D(-200, -150, -260),
                new Point3D(-200, -200, -270));

        triangle.setEmission(new Color(0, 0, 100));
        triangle.setMaterial(new Material(1, 1, 0, 0, 4));
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(
                new Color(255, 100, 100), new Point3D(-200, -200, -150),
                0.1, 0.00001, 0.000005, new Vector(2, 2, -3)));


        ImageWriter imageWriter = new ImageWriter("Spot test with shadow2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);
        render.renderImage(true);
    }

    @Test
    public void pointLightTest2() {
        Scene scene = new Scene("");
        scene.setBackground(new Color(0, 0, 0));
        scene.setAmbient(new AmbientLight(new Color(255, 255, 255), 0.1));
        scene.setCameraAndDistance(new Camera(), 200);

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setMaterial(new Material(1, 1, 0, 0, 20));
        sphere.setEmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(
                new Point3D(-125, -225, -260),
                new Point3D(-225, -125, -260),
                new Point3D(-225, -225, -270));

        triangle.setEmission(new Color(0, 0, 100));
        triangle.setMaterial(new Material(0.3, 2, 0, 0, 4));
        scene.addGeometry(triangle);

        scene.addLight(new PointLight(
                new Color(255, 100, 100), new Point3D(-200, -200, -150),
                0.1, 0.00001, 0.000005));


        ImageWriter imageWriter = new ImageWriter("Point test with shadow", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);
        render.renderImage(true);
    }
}
