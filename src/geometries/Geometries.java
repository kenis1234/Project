package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.List;

public class Geometries implements Intersectable {


    private List<Geometry> geometries;

    public Geometries(List<Geometry> list)
    {
        geometries=new ArrayList<Geometry>(list);
    }
    public Geometries()
    {
        geometries=new ArrayList<Geometry>();
    }
    public Geometries(Geometry g)
    {
        geometries=new ArrayList<Geometry>();
        geometries.add(g);
    }

    public List<Geometry> getGeometries() {
        return geometries;
    }

    @Override
    public List<GeoPoint> findIntersections(Ray ray) {
        List<GeoPoint> list = new ArrayList<GeoPoint>();
        for(Geometry g: geometries)
        {
            list.addAll(g.findIntersections(ray));
        }
        return list;
    }


    public void add(Geometry g)
    {
        geometries.add(g);
    }
    public void add(List<Geometry> g)
    {
        geometries.addAll(g);
    }
}
