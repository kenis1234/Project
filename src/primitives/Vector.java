package primitives;

public class Vector {
    private Point3D head;


    /********** Constructors ***********/
    public Vector(Point3D head) {
        this.head = new Point3D(head);
    }
    public Vector(double x, double y, double z)
    {
        head=new Point3D(x,y,z);
    }
    public Vector(Coordinate x, Coordinate y, Coordinate z)
    {
        head=new Point3D(x,y,z);
    }
    public Vector()
    {
        head=new Point3D(0,0,0);
    }
    public Vector(Vector vector) {
        this.head = new Point3D(vector.getHead());
    }

    /************** Getters/Setters *******/
    public Point3D getHead() {
        return head;
    }

    public void setHead(Point3D head) {
        this.head = head;
    }


    /*************** Admin *****************/
    @Override
    public boolean equals(Object v) {
        if(v==null)
            return false;
        if (!(v instanceof Vector))
            return false;
        Vector vector=(Vector)v;
        // If the object is compared with itself then return true
        if (head==vector.getHead())
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "head=" + getHead().toString() +
                '}';
    }



    /************** Operations ***************/
    public Vector sub (Vector other){
        return new Vector(head.sub(other.getHead()));
    }

    public Vector add (Vector other){
        return new Vector(head.add(other.getHead()));
    }

    public Vector mult (double scalar){
        Coordinate x=head.getCoordinate_x().scale(scalar);
        Coordinate y=head.getCoordinate_y().scale(scalar);
        Coordinate z=head.getCoordinate_z().scale(scalar);
        head=new Point3D(x,y,z);
        return this;
    }

    public void div (double scalar){
        try{
            if(scalar==0)
                throw new RuntimeException("dividing in 0 is not allowed\n");
            Coordinate x=head.getCoordinate_x().scale(1/scalar);
            Coordinate y=head.getCoordinate_y().scale(1/scalar);
            Coordinate z=head.getCoordinate_z().scale(1/scalar);
            head= new Point3D(x,y,z);
        }
        catch (RuntimeException e)
        {
            System.out.print(e);
        }
    }

    public double dotProduct (Vector other){
        return head.getCoordinate_x().multiply(other.getHead().getCoordinate_x())+head.getCoordinate_y().multiply(other.getHead().getCoordinate_y())+head.getCoordinate_z().multiply(other.getHead().getCoordinate_z());
    }

    public Vector crossProduct (Vector other) {
        try {
            Coordinate x = new Coordinate(head.getCoordinate_y().multiply(other.getHead().getCoordinate_z()) - (head.getCoordinate_z().multiply(other.getHead().getCoordinate_y())));
            Coordinate y = new Coordinate(head.getCoordinate_z().multiply(other.getHead().getCoordinate_x()) - (head.getCoordinate_x().multiply(other.getHead().getCoordinate_z())));
            Coordinate z = new Coordinate(head.getCoordinate_x().multiply(other.getHead().getCoordinate_y()) - (head.getCoordinate_y().multiply(other.getHead().getCoordinate_x())));
            if (new Point3D(x, y, z).equals(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0))))
                throw new RuntimeException("vector 0 is not allowed\n");
            return new Vector(x, y, z);
        }
        catch (RuntimeException e) {
            System.out.print(e);
            return new Vector();
        }
    }

    public double size(){
        return getHead().size(getHead());
    }

    public Vector normalize(){
        div(size());
        return new Vector(head);
    }
}
