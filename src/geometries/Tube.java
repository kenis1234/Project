/*package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

public class Tube extends RadialGeometry  implements Geometry{
    private Vector vector;
    private Point3D point;


    /********** Constructors ***********
    public Tube(double radius, Vector vector, Point3D point) {
        super(radius);
        this.vector = vector;
        this.point = point;
    }


    /************** Getters/Setters *******
    public Vector getVector() {
        return vector;
    }

    public Point3D getPoint() {
        return point;
    }


    /************** Operations ***************
    @Override
    public Vector getNormal(Point3D point0) {
        double t= ((new Vector(point0)).dotProduct(vector)-new Vector(point).dotProduct(vector))/vector.dotProduct(vector);
        Point3D a=new Point3D(point.add((vector.mult(t)).getHead()));
        return new Vector(point0.sub(a)).normalize();
    }
    @Override
    public List<Point3D> findIntersections(Ray ray){
        return null;
    }
}*/
