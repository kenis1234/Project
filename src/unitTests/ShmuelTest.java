// Bs"d

package unitTests;

import elements.AmbientLight;
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

import java.awt.*;

public class ShmuelTest {
    @Test
    public void myTest()
    {
        Scene scene = new Scene();
        scene.setAmbient(new AmbientLight(new Color(255, 0, 235),0.1));
        scene.setCameraAndDistance(new Camera(), 200);

        Sphere sphere1 = new Sphere(100, new Point3D(0,0,-500));
        sphere1.setEmission(new Color(255, 0, 235));
        sphere1.setMaterial(new Material(1,1,1,0.5,20));

        scene.addGeometry(sphere1);

        scene.addLight(new SpotLight(new Color(255, 0, 0), new Point3D(0,0,0),0.4,0.0001,0.000004,new Vector(1,0,0)));

        ImageWriter i=new ImageWriter("kjsh",500,500,500,500);
        Render r=new Render(i,scene);
        r.renderImage(true);

    }
}
