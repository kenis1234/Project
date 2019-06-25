package primitives;

public class Point2D {
    private Coordinate coordinate_x;
    private Coordinate coordinate_y;

    /********** Constructors ***********/
    public Point2D(Coordinate coordinate_x, Coordinate coordinate_y) {
        this.coordinate_x=new Coordinate(coordinate_x);
        this.coordinate_y=new Coordinate(coordinate_y);
    }
    public Point2D(double coordinate_x, double coordinate_y) {
        this.coordinate_x = new Coordinate(coordinate_x);
        this.coordinate_y = new Coordinate(coordinate_y);
    }


    /************** Getters/Setters *******/
    public Coordinate getCoordinate_x() {
        return coordinate_x;
    }

    public void setCoordinate_x(Coordinate coordinate_x) {
        this.coordinate_x = coordinate_x;
    }

    public Coordinate getCoordinate_y() {
        return coordinate_y;
    }

    public void setCoordinate_y(Coordinate coordinate_y) {
        this.coordinate_y = coordinate_y;
    }


    /*************** Admin *****************/
    @Override
    public boolean equals(Object point) {
        if(point==null)
            return false;
        if (!(point instanceof Point2D))
            return false;
        Point2D point2D=(Point2D)point;
        // If the object is compared with itself then return true
        if (getCoordinate_x().equals(point2D.getCoordinate_x()) && getCoordinate_y().equals( point2D.getCoordinate_y()) )
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + getCoordinate_x() +
                ", y=" + getCoordinate_y() +
                '}';
    }


    /************** Operations ***************/
    public Point2D sub(Point2D point2D) {
        Coordinate y=( getCoordinate_y().subtract(point2D.getCoordinate_y()));
        Coordinate x=( getCoordinate_x().subtract(point2D.getCoordinate_x()));
        return new Point2D(x,y);
    }

    public Point2D add(Point2D point2D) {
        Coordinate y=( getCoordinate_y().add(point2D.getCoordinate_y()));
        Coordinate x=( getCoordinate_x().add(point2D.getCoordinate_x()));
        return new Point2D(x,y);
    }

    public double distance (Point2D other){
        return size(this.sub(other));
    }

    public double size(Point2D point){
        double size=point.getCoordinate_x().multiply(point.getCoordinate_x())+point.getCoordinate_y().multiply(point.getCoordinate_y());
        return Math.pow(size,0.5);
    }
}
