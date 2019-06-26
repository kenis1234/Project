//bs"d
package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.List;

public interface Intersectable
{
    public List<GeoPoint> findIntersections(Ray ray);            //function that all geometries must to implement
    static class GeoPoint {                       //class og Geometry and Point
        public Geometry geometry;
        public Point3D point;

        public GeoPoint(GeoPoint geoPoint) {
            this.geometry = geoPoint.geometry;
            this.point = new Point3D(geoPoint.point);
        }                  //copy constructor

        public GeoPoint(Geometry geometry, Point3D point) {
            this.geometry = geometry;
            this.point = point;
        }   //constructor with geometry and point
    }

}
