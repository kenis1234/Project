// Bs"d

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


    /********** Constructors ***********/

    public Scene(String name) {
        this.name = name;
        this.background = new Color(0,0,0);
        this.ambient = new AmbientLight(new Color(255,255,255),0.1);
        this.geometries = new Geometries();
        this.camera = new Camera();
        this.lights=new ArrayList<LightSource>();
        distance = 100;
    }                                                 // A constructor that initializes the scene with a name and default values ​​in the rest

    public Scene()
    {
        this.name = "";
        this.background = new Color(0,0,0);
        this.ambient = new AmbientLight(new Color(255,255,255),0.1);
        this.geometries = new Geometries();
        this.camera = new Camera();
        this.distance = 100;
        this.lights = new ArrayList<LightSource>();
    }


    /************** Getters/Setters *******/

    public String getName() {
        return new String(name);
    }                            // Get the secne's name

    public Color getBackground() { return new Color(background.getRGB()); }         // Get the secne's background

    public AmbientLight getAmbient() {
        return ambient;
    }                            //  Get the secne's ambient

    public Geometries getGeometries() {
        return geometries;
    }                        // Get the secne's geometries

    public Camera getCamera() {
        return camera;
    }                                    // Get the secne's camera

    public double getDistance() {
        return distance;
    }                                // Get the secne's distance

    public List<LightSource> getLights() {
        return lights;
    }                         // Get the secne's lights

    public void setBackground(Color background) {
        this.background = background;
    }   // Set the secne's background

    public void setAmbient(AmbientLight ambient) {
        this.ambient = ambient;
    }        // Set the secne's ambient

    public void setCameraAndDistance(Camera camera, double distance) {
        this.camera = camera;
        this.distance = distance;
    }          // Get the secne's camera and the secne's distance


    /************** Operations ***************/
    /**
     * Add geometry to the list of geometries of the scene
     * @param g The geometry for add
     */
    public void addGeometry(Geometry g){
        geometries.add(g);
    }                                       // Add geometry to secne's geometries

    /**
     *  Add light source to the list of lights of the scene
     * @param l The light source for add
     */
    public void addLight(LightSource l){
        lights.add(l);
    }                        //  Add light to secne's lights

    /**
     * Get the iterator of the secne's geometries
     * @return The iterator of the secne's geometries
     */
    public Iterator<Geometry> getGeometriesIterator(){
        return geometries.getGeometries().iterator();
    }
}
