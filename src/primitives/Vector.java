// Bs"d

package primitives;

public class Vector {
    private Point3D head;

    /********** Constructors ***********/
    /**
     * Constructor that receives point head and creates a vector from her
     * @param head
     */
    public Vector(Point3D head) {
        this.head = new Point3D(head);
    }                                                     //constructor of vecror = gets a point

    /**
     * A constructor that gets three double numbers x, y and z and creates a vector with them
     * @param x
     * @param y
     * @param z
     */
    public Vector(double x, double y, double z) {
        head=new Point3D(x,y,z);
    }                                     //gets 3 parameters of double of his vector

    /**
     * A constructor that gets three double numbers x, y and z and creates a vector with them
     * @param x
     * @param y
     * @param z
     */
    public Vector(Coordinate x, Coordinate y, Coordinate z) {
        head = new Point3D(x,y,z);
    }                         //gets 3 coordinates of the head of the vector

    /**
     * Default Constructor
     */
    public Vector()
    {
        head=new Point3D(1,0,0);
    }        //default constructor

    /**
     * Copy Constructor
     * @param vector
     */
    public Vector(Vector vector) {
        this.head = new Point3D(vector.getHead());
    }           //copy constructor


    /************** Getters/Setters *******/

    /**
     * Get the point head of the vector
     * @return The point head of the vector
     */
    public Point3D getHead() {
        return head;
    }                                             //get vector's head

    /**
     * Set the point head of the vector
     * @param head The new point head of the vector
     */
    public void setHead(Point3D head) {
        this.head = head;
    }                               //set vector's head


    /*************** Admin *****************/

    /**
     * Checks whether the object received v is equal to the current vector
     * @param v The other object
     * @return if they equals - True; else - False
     */
    @Override
    public boolean equals(Object v) {
        if(v==null)
            return false;
        if (!(v instanceof Vector))
            return false;
        Vector vector=(Vector)v;
        // If the object is compared with itself then return true
        if (head == vector.getHead())
            return true;
        return false;
    }                                           //check if 2 vectors are equal

    /**
     * Displays the current vector as a string
     * @return the display of the current vector as string
     */
    @Override
    public String toString() {
        return "Vector{" +
                "head=" + getHead().toString() +
                '}';
    }                                                   //print vector


    /************** Operations ***************/
    /**
     * sub vector from our vector
     * @param other - the vector we sub him
     * @return new calculated vector
     */
    public Vector sub (Vector other){
        return new Vector(head.sub(other.getHead()));
    }                                             //sub vector from another and returns a vector;

    /**
     * add vector from our vector
     * @param other - the vector we add him
     * @return new calculated vector
     */
    public Vector add (Vector other){
        return new Vector(head.add(other.getHead()));
    }                                             //add vector from another and returns a vector;

    /**
     * mult our vector in scalar
     * @param scalar - in what we mult
     * @return the calculated vector
     */
    public Vector mult (double scalar){
        Coordinate x = head.getCoordinate_x().scale(scalar);
        Coordinate y = head.getCoordinate_y().scale(scalar);
        Coordinate z = head.getCoordinate_z().scale(scalar);
        head = new Point3D(x,y,z);
        return this;
    }                                           //mult the vector himself and returns himself;

    /**
     * dividing our vector in scalar
     * @param scalar - in what we divide
     * @return the calculated vector
     */
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
    }                                              //mult the vector himself

    /**
     * dot product between two vectors
     * @param other - the other vector
     * @return - tha calculated result- a number
     */
    public double dotProduct (Vector other){
        return head.getCoordinate_x().multiply(other.getHead().getCoordinate_x())+head.getCoordinate_y().multiply(other.getHead().getCoordinate_y())+head.getCoordinate_z().multiply(other.getHead().getCoordinate_z());
    }                                      //dot product between 2 vectors


    /**
     * cross product between two vectors
     * @param other - the other vector
     * @return - tha calculated result- a vector
     */
    public Vector crossProduct (Vector other) {
        try {
            Coordinate x = new Coordinate(head.getCoordinate_y().multiply(other.getHead().getCoordinate_z()) - (head.getCoordinate_z().multiply(other.getHead().getCoordinate_y())));  //y1*z2-z1*y2
            Coordinate y = new Coordinate(head.getCoordinate_z().multiply(other.getHead().getCoordinate_x()) - (head.getCoordinate_x().multiply(other.getHead().getCoordinate_z())));  //z1*x2-x1*z2
            Coordinate z = new Coordinate(head.getCoordinate_x().multiply(other.getHead().getCoordinate_y()) - (head.getCoordinate_y().multiply(other.getHead().getCoordinate_x())));  //x1*y2-y1*x2
            if (new Point3D(x, y, z).equals(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0))))
                throw new RuntimeException("vector 0 is not allowed\n");
            return new Vector(x, y, z);
        }
        catch (RuntimeException e) {
            System.out.print(e);
            return new Vector();
        }
    }                                   //cross product between 2 vectors

    /**
     * calculate the size of the vector (size of his head)
     * @return a double- the size
     */
    public double size(){
        return getHead().size(getHead());
    }                           //size(length) of the vector


    /**
     * dividing him in his size and returns the result
     * @return the new  normalized vector
     */
    public Vector normalize(){
        div(size());
        return new Vector(head);
    }                                                        //dividing in the length
}
