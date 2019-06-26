package unitTests;

import geometries.Sphere;
import geometries.Triangle;
import org.junit.Test;
import primitives.Point3D;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

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
        Triangle t1=new Triangle(new Point3D(20,-20,20),new Point3D(20,-20,0),new Point3D(0,-20,20));
        Triangle t2=new Triangle(new Point3D(-20,-20,20),new Point3D(0,-20,20),new Point3D(-20,-20,0));
        Triangle t3=new Triangle(new Point3D(0,-20,-20),new Point3D(-20,-20,-20),new Point3D(-20,-20,0));
        Triangle t4=new Triangle(new Point3D(0,-20,-20),new Point3D(20,-20,-20),new Point3D(20,-20,0));
        Sphere s=new Sphere(14.14,new Point3D(0,-20,0));
        Scene scene=new Scene("ambient");
        String imageName="ambient";
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
        Render r=new Render(im,scene);
        r.renderImage();
    }
}
