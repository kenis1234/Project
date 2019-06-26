package unitTests;

import elements.AmbientLight;
import elements.Camera;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.Test;
import primitives.Point3D;
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
        //Triangle t1=new Triangle(new Point3D(200,-200,200),new Point3D(200,-200,0),new Point3D(0,-200,200));
        //Triangle t2=new Triangle(new Point3D(-200,-200,200),new Point3D(0,-200,200),new Point3D(-200,-200,0));
        //Triangle t3=new Triangle(new Point3D(0,-200,-200),new Point3D(-200,-200,-200),new Point3D(-200,-200,0));
        //Triangle t4=new Triangle(new Point3D(0,-200,-200),new Point3D(200,-200,-200),new Point3D(200,-200,0));
        //Sphere s=new Sphere(141.4,new Point3D(0,-20,0));
        //Triangle t1=new Triangle(new Point3D(-200,0,-200),new Point3D(-200,-200,-200),new Point3D(0,-200,-200));
        Triangle t1=new Triangle(new Point3D(200,200,-200),new Point3D(200,0,-200),new Point3D(0,200,-200));
        Triangle t2=new Triangle(new Point3D(-200,200,-200),new Point3D(0,200,-200),new Point3D(-200,0,-200));
        Triangle t3=new Triangle(new Point3D(0,-200,-200),new Point3D(-200,-200,-200),new Point3D(-200,0,-200));
        Triangle t4=new Triangle(new Point3D(0,-200,-200),new Point3D(200,-200,-200),new Point3D(200,-0,-200));
        Sphere s=new Sphere(100,new Point3D(0,0,-200));
        Scene scene=new Scene("ambient1");
        String imageName="ambient1";
        double width=500;
        double height=500;
        int nX=500;
        int nY=500;
        ImageWriter im=new ImageWriter(imageName,  width,  height,  nX,  nY);
        scene.addGeometry(t1);
        scene.addGeometry(t2);
        scene.addGeometry(t3);
        scene.addGeometry(t4);
        scene.addGeometry(s);
        scene.setBackground(new Color(255,51,204));
        scene.setAmbient(new AmbientLight(new Color(26, 65, 10),1));
        scene.setCameraAndDistance(new Camera(),100);
        Render r=new Render(im,scene);
        r.renderImage();
    }


    @Test
    public void f2() {
        Triangle t1=new Triangle(new Point3D(200,200,-200),new Point3D(200,0,-200),new Point3D(0,200,-200));
        Triangle t2=new Triangle(new Point3D(-200,200,-200),new Point3D(0,200,-200),new Point3D(-200,0,-200));
        Triangle t3=new Triangle(new Point3D(0,-200,-200),new Point3D(-200,-200,-200),new Point3D(-200,0,-200));
        Triangle t4=new Triangle(new Point3D(0,-200,-200),new Point3D(200,-200,-200),new Point3D(200,-0,-200));
        Sphere s=new Sphere(100,new Point3D(0,0,-200));
        Scene scene=new Scene("testemission");
        String imageName="testemission";
        double width=500;
        double height=500;
        int nX=500;
        int nY=500;
        t4.setEmission(new Color(73,200, 54));
        t1.setEmission(new Color(30, 30, 30));
        t3.setEmission(new Color(200, 64, 95));
        t2.setEmission(new Color(57, 84,200));
        s.setEmission(new Color(30, 30, 30));
        ImageWriter im=new ImageWriter(imageName,  width,  height,  nX,  nY);
        scene.addGeometry(t1);
        scene.addGeometry(t2);
        scene.addGeometry(t3);
        scene.addGeometry(t4);
        scene.addGeometry(s);
        scene.setBackground(new Color(0,0,0));
        scene.setAmbient(new AmbientLight(new Color(20, 20, 20),1));
        scene.setCameraAndDistance(new Camera(),100);
        Render r=new Render(im,scene);
        r.renderImage();
    }
}
