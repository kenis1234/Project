package primitives;

public class Point3D extends Point2D {
    private Coordinate coordinate_z;

    /********** Constructors ***********/
    public Point3D(Coordinate coordinate_x, Coordinate coordinate_y, Coordinate coordinate_z) {
        super(coordinate_x, coordinate_y);
        this.coordinate_z = new Coordinate(coordinate_z);
    }
    public Point3D(double coordinate_x, double coordinate_y, double coordinate_z) {
        super(coordinate_x, coordinate_y);
        this.coordinate_z = new Coordinate(coordinate_z);
    }

    public Point3D(Point3D point3D) {
        super(point3D.getCoordinate_x(), point3D.getCoordinate_y());
        this.coordinate_z = point3D.getCoordinate_z();
    }


    /************** Getters/Setters *******/
    public Coordinate getCoordinate_z() {
        return coordinate_z;
    }

    public void setCoordinate_z(Coordinate coordinate_z) {
        this.coordinate_z = coordinate_z;
    }


    /*************** Admin *****************/
    @Override
    public boolean equals(Object point) {
        if(point==null)
            return false;
        if (!(point instanceof Point3D))
            return false;
        if (!super.equals(point))
            return false;
        Point3D point3D=(Point3D)point;
        // If the object is compared with itself then return true
        if (coordinate_z.equals( point3D.getCoordinate_z()))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + super.getCoordinate_x() +
                ", y=" + super.getCoordinate_y() +
                ", z=" + getCoordinate_z() +
                '}';
    }


    /************** Operations ***************/


    public Vector sub(Point3D point3D) {
        Coordinate z=( coordinate_z.subtract(point3D.getCoordinate_z()));
        Coordinate y=( getCoordinate_y().subtract(point3D.getCoordinate_y()));
        Coordinate x=( getCoordinate_x().subtract(point3D.getCoordinate_x()));
        return new Vector(x,y,z);
    }


    public Point3D add(Point3D point3D) {
        Coordinate z=( coordinate_z.add(point3D.getCoordinate_z()));
        Coordinate y=( getCoordinate_y().add(point3D.getCoordinate_y()));
        Coordinate x=( getCoordinate_x().add(point3D.getCoordinate_x()));
        return new Point3D(x,y,z);
    }

    public Point3D add(Vector point3D) {
        Coordinate z=( coordinate_z.add(point3D.getHead().getCoordinate_z()));
        Coordinate y=( getCoordinate_y().add(point3D.getHead().getCoordinate_y()));
        Coordinate x=( getCoordinate_x().add(point3D.getHead().getCoordinate_x()));
        return new Point3D(x,y,z);
    }

    public double distance (Point3D other){
        return (this.sub(other)).size();

    }

    public double size(Point3D point){
        double size=point.getCoordinate_z().multiply(point.getCoordinate_z())+super.size(point)*super.size(point);
        return Math.pow(size,0.5);
    }

}
