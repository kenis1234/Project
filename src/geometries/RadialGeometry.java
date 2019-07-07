// Bs"d

package geometries;

public abstract class RadialGeometry extends Geometry{
    private double radius;

    /********** Constructors ***********/

    /**
     * Constructor that receives a radius and initializes the radius
     * @param radius The radius
     */
    public RadialGeometry(double radius) {
        this.radius = radius;
    }    //constructor with the radius

    /**
     * Copy Constructor
     * @param radialGeometry the other radialGeometry
     */
    public RadialGeometry(RadialGeometry radialGeometry) {
        this.radius = radialGeometry.getRadius();
    }        //copy constructor


    /************** Getters/Setters *******/

    /**
     * Get the radius of the radialGeometry
     * @return The radius of the radialGeometry
     */
    public double getRadius() {
        return radius;
    }                      //get the radius
}
