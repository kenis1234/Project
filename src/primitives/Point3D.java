// Bs"d

package primitives;

public class Point3D extends Point2D {

    private Coordinate coordinate_z;


    /********** Constructors ***********/

    /**
     * Constructor that receives three coordinates and creates a point from them
     * @param coordinate_x The x coordinate
     * @param coordinate_y The y coordinate
     * @param coordinate_z The z coordinate
     */
        public Point3D(Coordinate coordinate_x, Coordinate coordinate_y, Coordinate coordinate_z) {
        super(coordinate_x, coordinate_y);
        this.coordinate_z = new Coordinate(coordinate_z);
    }//counstruct point by 3 coordinates

    /**
     * Constructor that accepts three double numbers and creates a point from them
     * @param coordinate_x
     * @param coordinate_y
     * @param coordinate_z
     */
    public Point3D(double coordinate_x, double coordinate_y, double coordinate_z) {
        super(coordinate_x, coordinate_y);
        this.coordinate_z = new Coordinate(coordinate_z);
    }            //counstruct point by 3 doubles (coordinates)

    /**
     * copy constructor
     * @param point3D The other point3D
     */
    public Point3D(Point3D point3D) {
        super(point3D.getCoordinate_x(), point3D.getCoordinate_y());
        this.coordinate_z = new Coordinate(point3D.getCoordinate_z());
    }                                                          //copy constructor


    /************** Getters/Setters *******/
    /**
     * Get z coordinate
     * @return The coordinate z
     */
    public Coordinate getCoordinate_z() {
        return coordinate_z;
    }                                                      //return coordinate of z

    /**
     * Set z coordinate
     * @param coordinate_z The coordinate z
     */
    public void setCoordinate_z(Coordinate coordinate_z) {
        this.coordinate_z = new Coordinate(coordinate_z);
    }                                     //set coordinate z


    /*************** Admin *****************/
    /**
     * Checks whether the object received is equal to the current point
     * @param point The other object
     * @return if they equals - True; else - False
     */
    @Override
    public boolean equals(Object point) {                                                          //if 2 points are equal
        if(point==null)
            return false;
        if (!(point instanceof Point3D))                                                            //if it is not a point
            return false;
        if (!super.equals(point))
            return false;
        Point3D point3D=(Point3D)point;
        // If the object is compared with itself then return true
        if (coordinate_z.equals( point3D.getCoordinate_z()))
            return true;
        return false;
    }                                                      //if 2 points are equal

    /**
     * Displays the current point as a string
     * @return the display of the current point as string
     */
    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + super.getCoordinate_x() +
                ", y=" + super.getCoordinate_y() +
                ", z=" + getCoordinate_z() +
                '}';
    }                                                                 //print a point


    /************** Operations ***************/

    /**
     * Calculates subtraction between two points
     * @param point3D The other point
     * @return The subtraction between the other point from the current point
     */
    public Vector sub(Point3D point3D) {
        Coordinate z=( coordinate_z.subtract(point3D.getCoordinate_z()));
        Coordinate y=( getCoordinate_y().subtract(point3D.getCoordinate_y()));
        Coordinate x=( getCoordinate_x().subtract(point3D.getCoordinate_x()));
        return new Vector(x,y,z);
    }                                                      //sub 2 points and returns vector

    /**
     * Calculates addition between two points
     * @param point3D The other point
     * @return The addition between the other point and the current point
     */
    public Point3D add(Point3D point3D) {
        Coordinate z=( coordinate_z.add(point3D.getCoordinate_z()));
        Coordinate y=( getCoordinate_y().add(point3D.getCoordinate_y()));
        Coordinate x=( getCoordinate_x().add(point3D.getCoordinate_x()));
        return new Point3D(x,y,z);
    }                                                     //add point to point and returns point

    /**
     * Adding a vector to a point
     * @param point3D The vector
     * @return The adding of the vector and the point
     */
    public Point3D add(Vector point3D) {
        Coordinate z=( coordinate_z.add(point3D.getHead().getCoordinate_z()));
        Coordinate y=( getCoordinate_y().add(point3D.getHead().getCoordinate_y()));
        Coordinate x=( getCoordinate_x().add(point3D.getHead().getCoordinate_x()));
        return new Point3D(x,y,z);
    }                                                      //add vector to point and returns point

    /**
     * Calculates the distance between two points
     * @param other The other point
     * @return The distance between the other point and the current point
     */
    public double distance (Point3D other){
        return (this.sub(other)).size();
    }                                                   //calculating the distance between 2 points;

    /**
     * Calculates size of point
     * @param point The point
     * @return The size of the point
     */
    public double size(Point3D point){
        double size = point.getCoordinate_z().multiply(point.getCoordinate_z())+super.size(point)*super.size(point);
        return Math.pow(size,0.5);
    }                                                       //size of point - the distance of zero

}
