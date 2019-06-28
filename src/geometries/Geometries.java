package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.List;

public class Geometries implements Intersectable {

    private List<Geometry> geometries;


    /********** Constructors ***********/
    public Geometries(List<Geometry> list) {
        geometries=new ArrayList<Geometry>(list);
    }                             //constructor with list of geometries

    public Geometries()
    {
        geometries=new ArrayList<Geometry>();
    }            //default constructor

    public Geometries(Geometry g) {
        geometries=new ArrayList<Geometry>();
        geometries.add(g);
    }                                      //constructor with one geometry


    /************** Getters/Setters *******/
    public List<Geometry> getGeometries() {
        return geometries;
    }             //get the list of geometries


    /************** Operations ***************/
    @Override
    public List<GeoPoint> findIntersections(Ray ray) {
        List<GeoPoint> list = new ArrayList<GeoPoint>();
        for(Geometry g: geometries)
        {
            list.addAll(g.findIntersections(ray));
        }
        return list;
    }                   //find intersections with all of geometries

    public void add(Geometry g)
    {
        geometries.add(g);
    }                       //add one geometry

    public void add(List<Geometry> g)
    {
        geometries.addAll(g);
    }              //add list of geometries
}
