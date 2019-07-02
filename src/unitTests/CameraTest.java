package unitTests;

//import org.junit.Assert;
//import org.junit.Test;
import elements.Camera;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static junit.framework.TestCase.*;


//import static org.junit.Assert.*;
//import static org.junit.Assert.*;


public class CameraTest {
    /*** Camera test ***/
    @Test
    public void func()
    {
        Camera c=new Camera();
        Ray ray=c.constructRayThroughPixel(3,3,5,5,5,5,10);
        assertEquals("the direction vector is: Vector{head=Point3D{x=0.0, y=0.0, z=-1.0}}the head is: Point3D{x=0.0, y=0.0, z=0.0}",ray.toString());
    }
    @Test
    public void func1()
    {
        Camera c=new Camera();
        Ray ray=c.constructRayThroughPixel(1,1,5,5,10,7,10);
        assertEquals("the direction vector is: Vector{head=Point3D{x=0.20463518708865724, y=-0.21486694644309012, z=-0.9549642064137338}}the head is: Point3D{x=0.0, y=0.0, z=0.0}",ray.toString());
    }
    @Test
    public void testRaysConstruction(){
        final int WIDTH = 3;
        final int HEIGHT = 3;
        Point3D[][] screen = new Point3D [HEIGHT][WIDTH];
        Camera camera = new Camera();
        System.out.println("Camera:\n" + camera);
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                Ray ray = camera.constructRayThroughPixel( i,j, WIDTH, HEIGHT, 3 * HEIGHT, 3 * WIDTH, 1);
                screen[i][j] = ray.getHead();
                System.out.print(screen[i][j]);
                System.out.println(ray.getDirection());
// Checking z-coordinate
                assertTrue(Double.compare(screen[i][j].getCoordinate_z().get(), -1.0) != 0);
// Checking all options
                double x = screen[i][j].getCoordinate_y().get();
                double y = screen[i][j].getCoordinate_x().get();
                if (Double.compare(x, 3) == 0 ||
                        Double.compare(x, 0) == 0 ||
                        Double.compare(x, -3) == 0){
                    if (Double.compare(y, 3) == 0 ||
                            Double.compare(y, 0) == 0 ||
                            Double.compare(y, -3) == 0){
                        assertTrue(true);
                    }
                    else
                        fail("Wrong y coordinate");
                } else
                    fail("Wrong x coordinate");
            }
            System.out.println("---");
        }
    }

    /*@Test
    public void Test13() {

        final int WIDTH = 10;
        final int HEIGHT = 10;

        Point3D[][] screen = new Point3D[HEIGHT][WIDTH];

        Camera camera = new Camera(new Point3D(0.0, 0.0, 0.0),
                new Vector(0.0, 1.0, 0.0),
                new Vector(0.0, 0.0, -1.0));

        System.out.println("Test13: Camera test:\n" + camera);

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {

                Ray ray = camera.constructRayThroughPixel(WIDTH, HEIGHT, j + 1, i + 1, 1, 3 * WIDTH, 3 * HEIGHT);

                screen[i][j] = ray.getHead();

                System.out.printf("[%d,%d]=", i, j);
                System.out.print(screen[i][j]);
                System.out.println(ray.getDirection());


                         System.out.printf("x = %f ",screen[i][j].getCoordinate_x().get());
                         System.out.printf("y = %f ",screen[i][j].getCoordinate_y().get());
                         System.out.printf("z = %f\n",screen[i][j].getCoordinate_z().get());
                // Checking z-coordinate
                //assertTrue(Double.compare(screen[i][j].getCoordinate_z().get(), -1.0) == 0);

                // Checking all options
                double x = screen[i][j].getCoordinate_x().get();
                double y = screen[i][j].getCoordinate_y().get();

                double[] values = {1.5, 4.5, 7.5, 10.5, 13.5};

                int k = 0;
                for (; k < values.length; k++)
                    if (values[k] == Math.abs(x))
                        break;
                if (k == values.length);
//                    fail("Wrong X coordinate");

                k = 0;
                for (; k < values.length; k++)
                    if (values[k] == Math.abs(y))
                        break;
                if (k == values.length);
     //               fail("Wrong Y coordinate");
            }
            System.out.println("---");
        }

    }*/
    /*@Test
    public void rayToPixeltest() {
        try {
            Camera camera = new Camera(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0)), new Vector(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(1))), new Vector(new Point3D(new Coordinate(1), new Coordinate(0), new Coordinate(0))),3);
            Ray r1 = camera.rayToPixel(1300.5, 900.5);
            Vector v1 = (new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0))).subtractionVector(new Point3D(new Coordinate(3), new Coordinate(4), new Coordinate(3)));
            Ray r2 = camera.rayToPixel(-1300.5, -900.5);
            Vector v2 = (new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0))).subtractionVector(new Point3D(new Coordinate(-3), new Coordinate(-4), new Coordinate(3)));
            assertEquals(r1.getV(), v1.normalVec());
            assertEquals(r2.getV(), v2.normalVec());
        } catch (Exception e) {
            fail("exception thrown");
        }
    }*/
}