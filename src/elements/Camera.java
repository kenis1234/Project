package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Camera {

    private Point3D p0;
    private Vector vto;
    private Vector vRight;
    private Vector vUp;


    /*public Camera() {
        p0=new Point3D(0,0,0);
        vto=new Vector(1,0,0);
        vRight=new Vector(0,-1,0);
        vUp=new Vector(0,0,1);
    }*/
    public Camera()
    {
        p0=new Point3D(0,0,0);
        vto=new Vector(0,0,-1);
        vUp=new Vector(1,0,0);
        vRight=new Vector(0,1,0);


    }
    /*public Camera(Point3D p,Vector v1, Vector v2) {
        p0=new Point3D(p);
        vto=new Vector(v1);
        vRight=new Vector(v1.crossProduct(v2));
        vUp=new Vector(v2);
        vto.normalize();
        vRight.normalize();
        vUp.normalize();
    }*/
    public Camera(Point3D P0, Vector vUp, Vector vTo)
    {
        p0=new Point3D(P0);
        vto=new Vector(vTo);
        vUp=new Vector(vUp);
        vRight=new Vector(vTo.crossProduct(vUp));
    }



    public Point3D getP0() {
        return new Point3D(p0);
    }
    public Vector getvto() {
        return new Vector(vto);
    }
    public Vector getvRight() {
        return new Vector(vRight);
    }
    public Vector getvUp() {
        return new Vector(vUp);
    }

    public Ray constructRayThroughPixel (double x, double y, double w,double h,int px,int py, double d){
        Point3D p2=new Point3D(p0);
        Vector to=new Vector(getvto());
        System.out.println(to);
        System.out.println(d);
        to.mult(d);
        Point3D pc=p2.add(to);
        System.out.println(p0);
        System.out.println(to);
        System.out.println(pc);
        double rx=w/px;
        double ry=h/py;
        double tx=(x-px/2.0)*rx-rx/2.0;
        double ty=(y-py/2.0)*ry-ry/2.0;
        System.out.println(tx);
        System.out.println(ty);
        Vector vx= getvRight().mult(tx);
        Vector vy=new Vector(getvUp().mult(ty*(-1)));
        Point3D p=(pc.add(vx)).add(vy);
        Vector res=p.sub(p0);
        res.normalize();
        return new Ray(res,p0);
    }

}
