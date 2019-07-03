// Bs"d

package unitTests;

import elements.AmbientLight;
import elements.SpotLight;
import geometries.Triangle;
import org.junit.Test;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

import java.awt.*;

public class SpotPointTests {

    @Test
    public void spotLightTest(){
        Scene scene = new Scene();

        Triangle triangle = new Triangle(new Point3D(  -3500,  3500, -2000),
                new Point3D( 3500, -3500, -1000),
                new Point3D(  3500, 3500, -2000));
        triangle.setEmission(new Color(40, 29, 28));
        triangle.setMaterial(new Material());

        Triangle triangle2 = new Triangle(new Point3D(  -3500,  3500, -2000),
                new Point3D( 3500,  -3500, -1000),
                new Point3D( -3500, -3500, -1000));

        triangle2.setEmission(new Color(40, 29, 28));
        triangle2.setMaterial(new Material());

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.setBackground(new Color(0,0,0));
        scene.setAmbient(new AmbientLight(new Color(0,0,0),0.1));
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100)
                ,0, 0.0001, 0.00005, new Vector(new Point3D(-2, -2, -3))));


        ImageWriter imageWriter = new ImageWriter( "spotLightTest", 500, 500, 500, 500);

        Render render = new Render(imageWriter,scene);

        render.renderImage();
    }

    /*@Test
    void pointLightTest(){
        Scene scene = new Scene("pointLightTest");

        Triangle triangle = new Triangle(new Color(40, 29, 28),new Point3D(  -3500,  3500, -2000),
                new Point3D( 3500, -3500, -1000),
                new Point3D(  3500, 3500, -2000));

        Triangle triangle2 = new Triangle(new Color(40, 29, 28),new Point3D(  -3500,  3500, -2000),
                new Point3D( 3500,  -3500, -1000),
                new Point3D( -3500, -3500, -1000));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new pointLight(new Color(255, 100, 100), new Point3D(200, 200, -100)
                , 0, 0.000001, 0.0000005));
        scene.setAmbientLight(new AmbientLight(new Color(java.awt.Color.BLACK)));
        ImageWriter imageWriter = new ImageWriter( "pointLightTest", 500, 500, 500, 500);

        Render render = new Render(imageWriter,scene);

        render.renderImage();
        render.writeToImage();
    }*/
}
