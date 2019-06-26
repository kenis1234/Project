package geometries;

public abstract class RadialGeometry extends Geometry{
    private double radius;

    /********** Constructors ***********/
    public RadialGeometry(double radius) {
        this.radius = radius;
    }    //constructor with the radius
    public RadialGeometry(RadialGeometry radialGeometry) {
        this.radius = radialGeometry.getRadius();
    }        //copy constructor


    /************** Getters/Setters *******/
    public double getRadius() {
        return radius;
    }                      //get the radius
}
