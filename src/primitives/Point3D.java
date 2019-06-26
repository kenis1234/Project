package primitives;

public class Point3D extends Point2D {
    private Coordinate coordinate_z;


    /********** Constructors ***********/
    public Point3D(Coordinate coordinate_x, Coordinate coordinate_y, Coordinate coordinate_z) {
        super(coordinate_x, coordinate_y);
        this.coordinate_z = new Coordinate(coordinate_z);
    }//counstruct point by 3 coordinates

    public Point3D(double coordinate_x, double coordinate_y, double coordinate_z) {
        super(coordinate_x, coordinate_y);
        this.coordinate_z = new Coordinate(coordinate_z);
    }            //counstruct point by 3 doubles (coordinates)

    public Point3D(Point3D point3D) {
        super(point3D.getCoordinate_x(), point3D.getCoordinate_y());
        this.coordinate_z = new Coordinate(point3D.getCoordinate_z());
    }                                                          //copy constructor


    /************** Getters/Setters *******/
    public Coordinate getCoordinate_z() {
        return coordinate_z;
    }                                                      //return coordinate of z

    public void setCoordinate_z(Coordinate coordinate_z) {
        this.coordinate_z = new Coordinate(coordinate_z);
    }                                     //set coordinate z


    /*************** Admin *****************/
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

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + super.getCoordinate_x() +
                ", y=" + super.getCoordinate_y() +
                ", z=" + getCoordinate_z() +
                '}';
    }                                                                 //print a point


    /************** Operations ***************/


    public Vector sub(Point3D point3D) {
        Coordinate z=( coordinate_z.subtract(point3D.getCoordinate_z()));
        Coordinate y=( getCoordinate_y().subtract(point3D.getCoordinate_y()));
        Coordinate x=( getCoordinate_x().subtract(point3D.getCoordinate_x()));
        return new Vector(x,y,z);
    }                                                      //sub 2 points and returns vector

    public Point3D add(Point3D point3D) {
        Coordinate z=( coordinate_z.add(point3D.getCoordinate_z()));
        Coordinate y=( getCoordinate_y().add(point3D.getCoordinate_y()));
        Coordinate x=( getCoordinate_x().add(point3D.getCoordinate_x()));
        return new Point3D(x,y,z);
    }                                                     //add point to point and returns point

    public Point3D add(Vector point3D) {
        Coordinate z=( coordinate_z.add(point3D.getHead().getCoordinate_z()));
        Coordinate y=( getCoordinate_y().add(point3D.getHead().getCoordinate_y()));
        Coordinate x=( getCoordinate_x().add(point3D.getHead().getCoordinate_x()));
        return new Point3D(x,y,z);
    }                                                      //add vector to point and returns point

    public double distance (Point3D other){
        return (this.sub(other)).size();
    }                                                   //calculating the distance between 2 points;

    public double size(Point3D point){
        double size=point.getCoordinate_z().multiply(point.getCoordinate_z())+super.size(point)*super.size(point);
        return Math.pow(size,0.5);
    }                                                       //size of point- the distance of zero

}
