package unitTests;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Vector;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;


public class VectorTests {
    @Test
    void add() {
        Vector v1=new Vector(new Point3D(1.0,2.0,4));
        Vector v2=new Vector(new Point3D(0.0,3,2.0));
        Vector v3=new Vector(v1.add(v2));
        assertEquals("Vector{head=Point3D{x=1.0, y=5.0, z=6.0}}",v3.toString());
            v2=new Vector();
            try
            {
                v2.add(v2);
                fail("its a zero vector");
            }
            catch (Exception ex)
            {
            assertTrue(true);
        }

    }

    @Test
    void sub(){

        Vector v1=new Vector(new Point3D(1.0,2.0,4));
        Vector v2=new Vector(new Point3D(0.0,3,2.0));
        assertEquals("Vector{head=Point3D{x=1.0, y=-1.0, z=2.0}}",v1.sub(v2).toString());
        v2=new Vector();
        /*try
        {
            v2.sub(v2);
            fail("its a zero vector");
        }
        catch (Exception ex)
        {
            assertTrue(true);
        }*/
    }

    @Test
    void mult() {
        Vector v1=new Vector(new Point3D(1.0,2.0,4));
        v1.mult(5);
        assertEquals("Vector{head=Point3D{x=5.0, y=10.0, z=20.0}}",v1.toString());
        /*try
        {
            v1.mult(0);
            fail("its a zero vector");
        }
        catch (Exception ex)
        {
            assertTrue(true);
        }*/
    }

    @Test
    void dotProduct() {
        Vector v1=new Vector(new Point3D(1.0,0.0,0.0));
        Vector v2=new Vector(new Point3D(0.0,1.0,0.0) );
        double result=v1.dotProduct(v2);
        assertEquals(0,result);
        v1=new Vector(new Point3D(1.0,2.0,4.0));
        v2=new Vector(new Point3D(2.0,4.0,8.0));
        result=v1.dotProduct(v2);
        assertEquals(42,result);
        v1=new Vector(new Point3D(2.0,2.0,3.0));
        v2=new Vector(new Point3D(1.0,2.0,3.0));
        result=v1.dotProduct(v2);
        assertEquals(15,result);
        v1=new Vector(new Point3D(1.0,2.0,3.0));
        v2=new Vector(new Point3D(-1.0,-2.0,-3.0));
        result=v1.dotProduct(v2);
        assertEquals(-14,result);
        v1=new Vector(new Point3D(2.0,2.0,3.0));
        v2=new Vector(new Point3D(-1.0,1.0,-3.0));
        result=v1.dotProduct(v2);
        assertEquals(-9,result);
    }

    @Test
    void crossProduct() {
        Vector v1=new Vector(new Point3D(1.0,0.0,0.0));
        Vector v2=new Vector(new Point3D(0.0,1.0,0.0) );
        Vector v3=v1.crossProduct(v2);
        v3.normalize();
        assertEquals("Vector{head=Point3D{x=0.0, y=0.0, z=1.0}}",v3.toString());
        v1=new Vector(new Point3D(1.0,2.0,4.0));
        v2=new Vector(new Point3D(2.0,4.0,8.0));
        /*try {
            v3 = v1.crossProduct(v2);
            fail("its a zero vector!!");
        }
        catch (Exception ex)
        {
            assertTrue(true);
        }*/
        v1=new Vector(new Point3D(1.0,2.0,3.0));
        v2=new Vector(new Point3D(-1.0,-2.0,-3.0));
        /*try {
            v3 = v1.crossProduct(v2);
            fail("its a zero vector!!");
        }
        catch (Exception ex)
        {
            assertTrue(true);
        }*/
        v1=new Vector(new Point3D(2.0,2.0,3.0));
        v2=new Vector(new Point3D(-1.0,2.0,-3.0));
        v3=v1.crossProduct(v2);
        assertEquals("Vector{head=Point3D{x=-12.0, y=3.0, z=6.0}}",v3.toString());
        v1=new Vector(new Point3D(2.0,2.0,3.0));
        v2=new Vector(new Point3D(1.0,2.0,3.0));
        v3=v1.crossProduct(v2);
        assertEquals("Vector{head=Point3D{x=0.0, y=-3.0, z=2.0}}",v3.toString());
    }

    @Test
    void length() {
        Vector v1=new Vector(new Point3D(1.0,0.0,0.0));
        assertEquals(1,v1.size());
        Vector v2=new Vector(new Point3D(1,2,3));
        assertEquals(Math.sqrt(14),v2.size());
    }

    @Test
    void testNormalize() {
        Vector v = new Vector(new Point3D(.5, -5, 10));
        v.normalize();
        assertEquals(1, v.size(), 1e-10);
        v = new Vector();
        /*try {
            v.normalize();
            fail("Didn't throw divide by zero exception!");
        } catch (ArithmeticException e) {
            assertTrue(true);
        }*/
    }
}




