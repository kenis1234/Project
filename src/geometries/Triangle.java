//Bs"d

package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Plane implements FlatGeometry{
    private Point3D point1;
    private Point3D point2;
    private Point3D point3;


    /********** Constructors ***********/
    /**
     * constructor of triangle
     * @param point1- point 1
     * @param point2 point 2
     * @param point3 point 3
     */
    public Triangle(Point3D point1, Point3D point2, Point3D point3) {
        super(point1, point2, point3);
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }              //constructor by 3 points


    /************** Getters/Setters *******/

    /**
     * Get point 1
     * @return point 1
     */
    public Point3D getPoint1() {
        return point1;
    }                                       //get point1

    /**
     * Get point 2
     * @return point 2
     */
    public Point3D getPoint2() {
        return point2;
    }                                       //get point2

    /**
     * Get point 3
     * @return point 3
     */
    public Point3D getPoint3() {
        return point3;
    }                                       //get point3


    /*************** Admin *****************/

    /**
     * Checks whether the object received is equal to the current Triangle
     * @param t The other object
     * @return if they equals - True; else - False
     */
    @Override
    public boolean equals(Object t) {
        if(t==null)
            return false;
        if (!(t instanceof Triangle))                                   //if the point is a point
            return false;
        if (((((Triangle) t).point1==point1 )||(((Triangle) t).point1==point1)||(((Triangle) t).point1==point1))&&(((Triangle) t).getNormal(new Point3D(0,0,0))==getNormal(new Point3D(0,0,0))))
            return true;
        return false;
    }                                         //checks if 2 triangles are equal

    /**
     * Displays the current Triangle as a string
     * @return the display of the current Triangle as string
     */
    @Override
    public String toString() {
        return "triangle: " +
                "" + point1 +point2+point3;
    }                                              //print a sphere


    /************** Operations ***************/
    private boolean sign(double i){
        if (i>0)
            return true;
        return false;
    }

    /**
     * Calculating the normal vector in some point on the Triangle
     * @param point The point
     * @return The normal vector in the point
     */
    @Override
    public Vector getNormal(Point3D point) {
        return super.getNormal(point);
    }                            //returns the normal of the triangle in a point

    /**
     * Finds all the points of intersection of the given ray with the Triangle
     * @param ray The ray with which the cutting with the Triangle is calculated
     * @return All the points of intersection of the ray with the Triangle
     */
    @Override
    public List<GeoPoint> findIntersections(Ray ray){
        Point3D t1=point1;
        Point3D t2=point2;
        Point3D t3=point3;
        Point3D p0=ray.getHead();
        Vector v11=t1.sub(p0);                                       //triangle number 1
        Vector v12=t2.sub(p0);                                       //triangle number 1
        Vector v21=t2.sub(p0);                                       //triangle number 2
        Vector v22=t3.sub(p0);                                       //triangle number 2
        Vector v31=t3.sub(p0);                                       //triangle number 3
        Vector v32=t1.sub(p0);                                       //triangle number 3
        Vector n1=v12.crossProduct(v11);
        n1.div(n1.size());                                            //normal triangle 1
        Vector n2=v22.crossProduct(v21);
        n2.div(n2.size());                                            //normal triangle 2
        Vector n3=v32.crossProduct(v31);
        n3.div(n3.size());                                            //normal triangle 3
        List<GeoPoint> list=new ArrayList<GeoPoint>();
        list=super.findIntersections(ray);                            //intersections of plane
        if(list.isEmpty())
            return list;
        //if(ray.getDirection().dotProduct(ray.getHead().sub(list.get(0).point))<0)
          // return new ArrayList<GeoPoint>() ;
        Point3D p=list.get(0).point;
        double i1=(p.sub(p0)).dotProduct(n1);
        double i2=(p.sub(p0)).dotProduct(n2);
        double i3=(p.sub(p0)).dotProduct(n3);
        boolean f1=sign(i1);
        boolean f2=sign(i2);
        boolean f3=sign(i3);
        if((f1&&f2&&f3)||!(f1||f2|f3))                                //if it is inside the triangle
            return list;
        return new ArrayList<GeoPoint>();
    }                  //returns intersection points with the triangle
}
