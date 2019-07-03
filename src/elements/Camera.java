//bs"d
package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Camera {

    private Point3D p0;
    private Vector vto;
    private Vector vRight;
    private Vector vUp;

    /********** Constructors ***********/
    public Camera() {
        p0=new Point3D(0,0,0);
        vto=new Vector(0,0,-1);
        vUp=new Vector(1,0,0);
        vRight=new Vector(0,1,0);
    }                //default constructor

    /*public Camera() {
        p0=new Point3D(0,0,0);
        vto=new Vector(0,0,-1);
        vUp=new Vector(0,1,0);
        vRight=vUp.crossProduct(vto).normalize();
    }                //default constructor*/

    public Camera(Point3D P0, Vector vUp, Vector vTo) {
        p0=new Point3D(P0);
        vto=new Vector(vTo);
        vUp=new Vector(vUp);
        vRight=new Vector(vTo.crossProduct(vUp));
        vto.normalize();
        vUp.normalize();
        vRight.normalize();
    }   //regular constructor


    /************** Getters/Setters *******/
    public Point3D getP0() {
        return new Point3D(p0);
    }           //get the point of the camera

    public Vector getvto() {
        return new Vector(vto);
    }           //get the toward vector

    public Vector getvRight() {
        return new Vector(vRight);
    }           //get the right vector

    public Vector getvUp() {
        return new Vector(vUp);
    }           //get the up vector


    /************** Operations ***************/
    //constructing ray throw some pixel
    //x,y- the number of the pixel
    //w- the width of the image
    //h- the height of the image
    //px-number of pixels in the x
    //py- number of pixels in y
    //d- the distance of the plane from the camera
    public Ray constructRayThroughPixel (double x, double y, double w,double h,int px,int py, double d){
        Point3D p2=new Point3D(p0);
        Vector to=new Vector(getvto());
        to.mult(d);
        Point3D pc=p2.add(to);         //pc-pc of the lectures
        double rx=w/px;
        double ry=h/py;
        double tx=(x-px/2.0)*rx-rx/2.0;
        double ty=(y-py/2.0)*ry-ry/2.0;
        Vector vx= getvRight().mult(tx);             //how much move in x
        Vector vy=new Vector(getvUp().mult(ty*(-1)));//how much move in y
        Point3D p=(pc.add(vx)).add(vy);
        Vector res=p.sub(p0);
        res.normalize();
        return new Ray(res,p);
    }
}
