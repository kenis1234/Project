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

import java.awt.*;

public class RenderTest {
    @Test
    public void func(){
        String imageName="grid";
        double width=500;
        double height=500;
        int nX=500;
        int nY=500;
        ImageWriter im=new ImageWriter( imageName,  width,  height,  nX,  nY);
        Scene s=new Scene("TestGrid");
        Render render=new Render(im,s);
        render.printGrid(50);
        im.writeToimage();
    }

    @Test
    public void f1(){
        Triangle t1=new Triangle(new Point3D(200,200,-200),new Point3D(200,0,-200),new Point3D(0,200,-200));
        Triangle t2=new Triangle(new Point3D(-200,200,-200),new Point3D(0,200,-200),new Point3D(-200,0,-200));
        Triangle t3=new Triangle(new Point3D(0,-200,-200),new Point3D(-200,-200,-200),new Point3D(-200,0,-200));
        Triangle t4=new Triangle(new Point3D(0,-200,-200),new Point3D(200,-200,-200),new Point3D(200,-0,-200));
        Sphere s=new Sphere(100,new Point3D(0,0,-200));
        Scene scene=new Scene("ambient1");
//        String imageName="ambient1";
        double width=500;
        double height=500;
        int nX=500;
        int nY=500;
        ImageWriter im=new ImageWriter(scene.getName(),  width,  height,  nX,  nY);
        scene.addGeometry(t1);
        scene.addGeometry(t2);
        scene.addGeometry(t3);
        scene.addGeometry(t4);
        scene.addGeometry(s);
        scene.setBackground(new Color(255,51,204));
        scene.setAmbient(new AmbientLight(new Color(26, 65, 10),1));
        scene.setCameraAndDistance(new Camera(),100);
        Render r=new Render(im,scene);
        r.renderImage(true);
    }

    @Test
    public void f3()
    {
        Scene scene = new Scene("spotLightTest");
        Triangle triangle = new Triangle(new Point3D(  -3500,  3500, -2000),
                new Point3D( 3500, -3500, -1000),
                new Point3D(  3500, 3500, -2000));
        triangle.setEmission(new Color(40, 29, 28));
        Triangle triangle2 = new Triangle(new Point3D(  -3500,  3500, -2000),
                new Point3D( 3500,  -3500, -1000),
                new Point3D( -3500, -3500, -1000));
        triangle2.setEmission(new Color(40, 29, 28));

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setMaterial(new Material(1, 1, 0, 0, 20));
        sphere.setEmission(new Color(0, 0, 100));

        scene.addGeometry(sphere);
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.setAmbient(new AmbientLight(java.awt.Color.BLACK,0.3));
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100)
                , 0, 0.000001, 0.0000005, new Vector(new Point3D(-2, -2, -3))));

        ImageWriter imageWriter = new ImageWriter("Spot test with shadow5", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);
        render.renderImage(true);
    }


}
