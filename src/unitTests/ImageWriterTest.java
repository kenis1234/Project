package unitTests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import renderer.ImageWriter;

public class ImageWriterTest {

    @Test
    public void testGrid() {
        ImageWriter iw = new ImageWriter("grid1", 500, 500, 500, 500);
        for(int i = 1; i < 500; i++)
            for (int j = 1; j < 500; j++) {
                if (i % 50 != 0 && j % 50 != 0)
                    iw.writePixel(i, j, Color.black);
                else
                    iw.writePixel(i, j, Color.white);
            }
        iw.writeToimage();
    }

}
