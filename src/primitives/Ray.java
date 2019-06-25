package primitives;

public class Ray {
    private Vector direction;
    private Point3D head;

    /********** Constructors ***********/
    public Ray(Vector direction, Point3D head) {
        this.direction = new Vector(direction).normalize();
        this.head = new Point3D(head);
    }


    /************** Getters/Setters *******/
    public Vector getDirection() {
        return new Vector(direction);
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    public Point3D getHead() {
        return head;
    }

    public void setHead(Point3D head) {
        this.head = head;
    }


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
    }

    @Override
    public String toString() {
        return "the direction vector is: "+ getDirection()+ "the head is: "+getHead();
    }
}
