// Bs"d

package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.List;

public class Geometries implements Intersectable {

    private List<Geometry> geometries;


    /********** Constructors ***********/

    /**
     * Constructor that gets a list of geometries
     * @param list The list of the geometries
     */
    public Geometries(List<Geometry> list) {
        geometries=new ArrayList<Geometry>(list);
    }                             //constructor with list of geometries

    /**
     * Default constructor
     */
    public Geometries()
    {
        geometries=new ArrayList<Geometry>();
    }            //default constructor

    /**
     * A constructor that receives one geometry
     * @param g The geometry
     */
    public Geometries(Geometry g) {
        geometries=new ArrayList<Geometry>();
        geometries.add(g);
    }                                      //constructor with one geometry


    /************** Getters/Setters *******/

    /**
     * Get the list of geometries
     * @return The list of geometries
     */
    public List<Geometry> getGeometries() {
        return geometries;
    }             //get the list of geometries


    /************** Operations ***************/

    /**
     * Finds all the points of intersection of the given ray with for each of the geometries from the list of geometries
     * @param ray The ray with which the cutting with the Geometries is calculated
     * @return All the points of intersection of the given ray with  for each of the geometries from the list of geometries
     */
    @Override
    public List<GeoPoint> findIntersections(Ray ray) {
        List<GeoPoint> list = new ArrayList<GeoPoint>();
        for(Geometry g: geometries)
        {
            list.addAll(g.findIntersections(ray));
        }
        return list;
    }                   //find intersections with all of geometries

    /**
     * adding a geometry to the list
     * @param g - the geometry we add
     */
    public void add(Geometry g)
    {
        geometries.add(g);
    }

    /**
     * adding list of geometries
     * @param g - the list we add
     */
    public void add(List<Geometry> g)
    {
        geometries.addAll(g);
    }              //add list of geometries
}
