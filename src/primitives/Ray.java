//Bs"d

package primitives;

public class Ray {
    private Vector direction;
    private Point3D head;

    /********** Constructors ***********/

    /**
     * Constructor that gets a direction vector and creates a ray
     * @param direction The direction vector of the ray
     * @param head The head of the ray
     */
    public Ray(Vector direction, Point3D head) {
        this.direction = new Vector(direction).normalize();
        this.head = new Point3D(head);
    }                   // Constructor that initializes the Ray in a vector and a Point


    /************** Getters/Setters *******/
    /**
     * Get the vector direction
     * @return the vector direction
     */
    public Vector getDirection() {
        return new Vector(direction);
    }                                // Return the vector direction of the Ray

    /**
     * Set the vector direction
     * @param direction The new vector direction
     */
    public void setDirection(Vector direction) {
        this.direction = direction;
    }                  // Set the vector direction of the Ray

    /**
     * GEt the head of the ray
     * @return The head of the ray
     */
    public Point3D getHead() {
        return head;
    }                         // Return the point head of the Ray

    /**
     * Set the head of the ray
     * @param head The new head of the ray
     */
    public void setHead(Point3D head) {
        this.head = head;
    }           // Set the head point of the Ray


    /*************** Admin *****************/

    /**
     * Checks whether the object received is equal to the current ray
     * @param r The other object
     * @return if they equals - True; else - False
     */
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

    /**
     * Displays the current ray as a string
     * @return the display of the current ray as string
     */
    @Override
    public String toString() {
        return "the direction vector is: "+ getDirection()+ "the head is: "+getHead();
    }                                    // Print the details of the Ray
}
