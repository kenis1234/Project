//Bs"d
package primitives;

public class Ray {
    private Vector direction;
    private Point3D head;

    /********** Constructors ***********/
    public Ray(Vector direction, Point3D head) {
        this.direction = new Vector(direction).normalize();
        this.head = new Point3D(head);
    }                   // Constructor that initializes the Ray in a vector and a Point


    /************** Getters/Setters *******/
    public Vector getDirection() {
        return new Vector(direction);
    }                                // Return the vector direction of the Ray



    public void setDirection(Vector direction) {
        this.direction = direction;
    }                  // Set the vector direction of the Ray

    public Point3D getHead() {
        return head;
    }                         // Return the point head of the Ray

    public void setHead(Point3D head) {
        this.head = head;
    }           // Set the head point of the Ray


    /*************** Admin *****************/
    @Override
    public boolean equals(Object r) {
        if(r==null)
            return false;
        if (!(r instanceof Ray))
            return false;
        Ray ray=(Ray)r;
        // If the object is compared with itself then return true
        if (direction==ray.getDirection()&&head==ray.getHead())
            return true;
        return false;

    }                             // Return "True" if r is equals to our Ray else return "False"

    @Override
    public String toString() {
        return "the direction vector is: "+ getDirection()+ "the head is: "+getHead();
    }                                    // Print the details of the Ray
}
