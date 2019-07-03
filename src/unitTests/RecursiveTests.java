// Bs"d

package unitTests;

import elements.Camera;
import elements.SpotLight;
import geometries.Sphere;
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
    public void recursiveTest()
    {
        Scene scene = new Scene();
        scene.setCameraAndDistance(new Camera(),300);

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setMaterial(new Material(1, 1, 0, 0.1, 20));
        sphere.setEmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(250, new Point3D(0.0, 0.0, -1000));
        sphere2.setMaterial(new Material(1, 1, 0.5, 0, 20));
        sphere2.setEmission(new Color(255, 0, 0));
        scene.addGeometry(sphere2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 0.1, 0.00001, 0.000005, new Vector(2, 2, -3)));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 1", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
    }

}

