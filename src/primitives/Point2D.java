// Bs"d

package primitives;

public class Point2D {
    private Coordinate coordinate_x;
    private Coordinate coordinate_y;


    /********** Constructors ***********/
    /**
     * Constructor that receives two coordinates and creates a point from them
     * @param coordinate_x The x coordinate
     * @param coordinate_y The y coordinate
     */
    public Point2D(Coordinate coordinate_x, Coordinate coordinate_y) {
        this.coordinate_x=new Coordinate(coordinate_x);
        this.coordinate_y=new Coordinate(coordinate_y);
    }  //counstruct point by 2 coordinates

    /**
     * Constructor that accepts two double numbers and creates a point from them
     * @param coordinate_x Value of x
     * @param coordinate_y Value of y
     */
    public Point2D(double coordinate_x, double coordinate_y) {
        this.coordinate_x = new Coordinate(coordinate_x);
        this.coordinate_y = new Coordinate(coordinate_y);
    }          //counstruct point by 2 doubles(coordinates)


    /************** Getters/Setters *******/
    /**
     * Get the x coordinate
     * @return the x coordinate
     */
    public Coordinate getCoordinate_x() {
        return coordinate_x;
    }              //return coordinate of x

    /**
     * Set the x coordinate
     * @return the new x coordinate
     * @param coordinate_x The new coordinate x
     */
    public void setCoordinate_x(Coordinate coordinate_x) {
        this.coordinate_x = coordinate_x;
    }//set coordinate x

    /**
     * Get the y coordinate
     * @return the y coordinate
     */
    public Coordinate getCoordinate_y() {
        return coordinate_y;
    }              //return coordinate of y

    /**
     * Set the y coordinate
     * @return the new y coordinate
     * @param coordinate_y The new coordinate y
     */
    public void setCoordinate_y(Coordinate coordinate_y) {
        this.coordinate_y = coordinate_y;
    }//set coordinate y


    /*************** Admin *****************/
    /**
     * Checks whether the object received is equal to the current point
     * @param point The other object
     * @return if they equals - True; else - False
     */
    @Override
    public boolean equals(Object point) {
        if(point==null)
            return false;
        if (!(point instanceof Point2D))                                   //if the point is a point
            return false;
        Point2D point2D=(Point2D)point;
        // If the object is compared with itself then return true
        if (getCoordinate_x().equals(point2D.getCoordinate_x()) && getCoordinate_y().equals( point2D.getCoordinate_y()) )
            return true;
        return false;
    }                                   //checks if 2 points are equal

    /**
     * Displays the current point as a string
     * @return the display of the current point as string
     */
    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + getCoordinate_x() +
                ", y=" + getCoordinate_y() +
                '}';
    }                                              //print a point


    /************** Operations ***************/

    /**
     * Calculates subtraction between two points
     * @param point2D The other point
     * @return The subtraction between the other point from the current point
     */
    public Point2D sub(Point2D point2D) {
        Coordinate y=( getCoordinate_y().subtract(point2D.getCoordinate_y()));
        Coordinate x=( getCoordinate_x().subtract(point2D.getCoordinate_x()));
        return new Point2D(x,y);
    }                                    //sub point from other and returns a point

    /**
     * Calculates addition between two points
     * @param point2D The other point
     * @return The addition between the other point and the current point
     */
    public Point2D add(Point2D point2D) {
        Coordinate y=( getCoordinate_y().add(point2D.getCoordinate_y()));
        Coordinate x=( getCoordinate_x().add(point2D.getCoordinate_x()));
        return new Point2D(x,y);
    }                                    //add point to other and returns a point

    /**
     * Calculates the distance between two points
     * @param other The other point
     * @return The distance between the other point and the current point
     */
    public double distance (Point2D other){
        return size(this.sub(other));
    }                                  //calculating the distance between 2 points

    /**
     * Calculates size of point
     * @param point The point
     * @return The size of the point
     */
    public double size(Point2D point){
        double size=point.getCoordinate_x().multiply(point.getCoordinate_x())+point.getCoordinate_y().multiply(point.getCoordinate_y());
        return Math.pow(size,0.5);
    }                                       //size of point - the distance of zero
}
