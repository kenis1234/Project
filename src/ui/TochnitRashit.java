package ui;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Vector;

public class TochnitRashit {
    public static void main(String[] args) {
        //examination for point3D:
        Point3D p=new Point3D(new Coordinate(1),new Coordinate(2.5),new Coordinate(0));
        Point3D p2=new Point3D(new Coordinate(3),new Coordinate(4),new Coordinate(-3));
        System.out.print("some tests on points: \n\n");
        System.out.print("point number one is: "+p);
        System.out.print("point number two is: "+p2);
        System.out.print("point number one plus number two: "+p.add(p2));
        System.out.print("point number one minus number two: "+p.sub(p2));
        System.out.print("the distance between them is: "+p.distance(p2)+"\n\n\n\n");



        //examination for vectors:
        System.out.print("some tests on vectors: \n\n");
        Vector vector = new Vector(p);
        Vector vector2=new Vector(p2);
        System.out.print("the vector: "+vector);
        System.out.print("size of the vector: "+vector.size()+"\n");
        vector.mult(3);
        System.out.print("the vector after mult by 3: "+vector);
        vector.div(1.5);
        System.out.print("the vector after div by 1.5: "+vector);
        System.out.print("vector's size before normalization: "+vector.size()+"\n");
        vector.normalize();
        System.out.print("the vector after normalization: "+vector);
        System.out.print("vector's size after normalization: "+vector.size()+"\n");
        vector=new Vector(new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3)));
        System.out.print("\nvector number one is: "+vector);
        System.out.print("vector number two is: "+vector2);
        System.out.print("add: "+vector.add(vector2));
        System.out.print("sub "+vector.sub(vector2));
        System.out.print("dot product: "+vector.dotProduct(vector2)+"\n");
        System.out.print("cross product: "+vector.crossProduct(vector2)+"\n");

    }
}
