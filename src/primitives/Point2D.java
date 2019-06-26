package primitives;

public class Point2D {
    private Coordinate coordinate_x;
    private Coordinate coordinate_y;


    /********** Constructors ***********/
    public Point2D(Coordinate coordinate_x, Coordinate coordinate_y) {
        this.coordinate_x=new Coordinate(coordinate_x);
        this.coordinate_y=new Coordinate(coordinate_y);
    }  //counstruct point by 3 coordinates

    public Point2D(double coordinate_x, double coordinate_y) {
        this.coordinate_x = new Coordinate(coordinate_x);
        this.coordinate_y = new Coordinate(coordinate_y);
    }          //counstruct point by 3 doubles(coordinates)


    /************** Getters/Setters *******/
    public Coordinate getCoordinate_x() {
        return coordinate_x;
    }              //return coordinate of x

    public void setCoordinate_x(Coordinate coordinate_x) {
        this.coordinate_x = coordinate_x;
    }//set coordinate x

    public Coordinate getCoordinate_y() {
        return coordinate_y;
    }              //return coordinate of y

    public void setCoordinate_y(Coordinate coordinate_y) {
        this.coordinate_y = coordinate_y;
    }//set coordinate y


    /*************** Admin *****************/
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

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + getCoordinate_x() +
                ", y=" + getCoordinate_y() +
                '}';
    }                                              //print a point


    /************** Operations ***************/
    public Point2D sub(Point2D point2D) {
        Coordinate y=( getCoordinate_y().subtract(point2D.getCoordinate_y()));
        Coordinate x=( getCoordinate_x().subtract(point2D.getCoordinate_x()));
        return new Point2D(x,y);
    }                                    //sub point from other and returns a point

    public Point2D add(Point2D point2D) {
        Coordinate y=( getCoordinate_y().add(point2D.getCoordinate_y()));
        Coordinate x=( getCoordinate_x().add(point2D.getCoordinate_x()));
        return new Point2D(x,y);
    }                                    //add point to other and returns a point

    public double distance (Point2D other){
        return size(this.sub(other));
    }                                  //calculating the distance between 2 points

    public double size(Point2D point){
        double size=point.getCoordinate_x().multiply(point.getCoordinate_x())+point.getCoordinate_y().multiply(point.getCoordinate_y());
        return Math.pow(size,0.5);
    }                                       //size of point- the distance of zero
}
