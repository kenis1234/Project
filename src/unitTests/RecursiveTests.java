// Bs"d

package unitTests;

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

public class RecursiveTests {

    @Test
    public void recursiveTest(){
        Scene scene = new Scene();
        scene.setCameraAndDistance(new Camera(),300);

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setMaterial(new Material(1, 1, 0, 0.5, 20));
        sphere.setEmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(250, new Point3D(0.0, 0.0, -1000));
        sphere2.setMaterial(new Material(1, 1, 0, 0, 20));
        sphere2.setEmission(new Color(255, 0, 0));
        scene.addGeometry(sphere2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 0.1, 0.00001, 0.000005, new Vector(2, 2, -3)));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 1", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage(true);
    }

    @Test
    public void recursiveTest2(){

        Scene scene = new Scene();
        scene.setCameraAndDistance(new Camera(),300);

        Sphere sphere = new Sphere(300, new Point3D(-550, -500, -1000));
        sphere.setMaterial(new Material(1,1,0,0.5,20));
        sphere.setEmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(150, new Point3D(-550, -500, -1000));
        sphere2.setMaterial(new Material(1,1,0,0,20));
        sphere2.setEmission(new Color(100, 20, 20));
        scene.addGeometry(sphere2);

        Triangle triangle = new Triangle(new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D(  200,  200, -375));

        Triangle triangle2 = new Triangle(new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D( -1500, -1500, -1500));

        triangle.setEmission(new Color(20, 20, 20));
        triangle2.setEmission(new Color(20, 20, 20));
        triangle.setMaterial(new Material(1,1,1,0,1));
        triangle2.setMaterial(new Material(1,1,0.5,0,1));
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150),
                0, 0.00001, 0.000005,new Vector(-2, -2, -3)));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage(true);
    }

}

