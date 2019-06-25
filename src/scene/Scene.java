package scene;
import elements.AmbientLight;
import elements.Camera;
import elements.LightSource;
import geometries.Geometries;
import geometries.Geometry;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Scene {
    private String name;
    private Color background;
    private AmbientLight ambient;
    private Geometries geometries;
    private Camera camera;
    private double distance;



    private List<LightSource> lights;


    public Scene(String name) {
        this.name = name;
        this.geometries = new Geometries();
        this.lights=new ArrayList<LightSource>();
    }


    public String getName() {
        return new String(name);
    }
    public Color getBackground() { return new Color(background.getRGB()); }
    public AmbientLight getAmbient() {
        return ambient;
    }
    public Geometries getGeometries() {
        return geometries;
    }
    public Camera getCamera() {
        return camera;
    }
    public double getDistance() {
        return distance;
    }
    public List<LightSource> getLights() {
        return lights;
    }

    public void setBackground(Color background) {
        this.background = background;
    }
    public void setAmbient(AmbientLight ambient) {
        this.ambient = ambient;
    }
    public void setCameraAndDistance(Camera camera, double distance) {
        this.camera = camera;
        this.distance = distance;
    }

    public void addGeometry(Geometry g){
        geometries.add(g);
    }
    public void addLight(LightSource l){
        lights.add(l);
    }

    public Iterator<Geometry> getGeometriesIterator(){
        return geometries.getGeometries().iterator();
    }
}
