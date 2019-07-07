// Bs"d

package renderer;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageWriter {

    private double _imageWidth, _imageHeight;
    private int _nX, _nY;

    final String PROJECT_PATH = System.getProperty("user.dir");

    private BufferedImage _image;

    private String _imageName;

    // ***************** Constructors ********************** //

    /**
     * constructor image writer
     * @param imageName - image name
     * @param width- scene width
     * @param height- senen height
     * @param nX- pixels x
     * @param nY- pixels y
     */
    public ImageWriter(String imageName, double width, double height, int nX, int nY) {
        _imageName = imageName;
        _imageWidth = width;
        _imageHeight = height;
        _nX = nX;
        _nY = nY;

        _image = new BufferedImage(_nX, _nY, BufferedImage.TYPE_INT_RGB);
    }

    /**
     * Copy Constructor
     * @param imageWriter The other imageWriter
     */
    public ImageWriter (ImageWriter imageWriter) {
        this(	imageWriter._imageName,
                imageWriter._imageWidth, imageWriter._imageHeight,
                imageWriter._nX, imageWriter._nY);
    }

    // ***************** Getters/Setters ********************** //

    /**
     * Get the width of the imageWriter
     * @return The width of the imageWriter
     */
    public double getWidth()  { return _imageWidth;  }

    /**
     * Get the height of the imageWriter
     * @return The height of the imageWriter
     */
    public double getHeight() { return _imageHeight; }

    /**
     * Get the nY
     * @return The nY
     */
    public int getNy() { return _nY; }

    /**
     * Get the nX
     * @return The nX
     */
    public int getNx() { return _nX; }

    /**
     * Set the nY
     * @param _Ny the new nY
     */
    public void setNy(int _Ny) { this._nY = _Ny; }

    /**
     * Set the nX
     * @param _Nx The new nX
     */
    public void setNx(int _Nx) { this._nX = _Nx; }

    // ***************** Operations ******************** //

    /**
     * Builds the file itself
     */
    public void writeToimage(){
        File ouFile = new File(PROJECT_PATH + "/" + _imageName + ".jpg");
        try {
            javax.imageio.ImageWriter jpgWriter = ImageIO.getImageWritersByFormatName("jpg").next();
            ImageWriteParam jpgWriteParam = jpgWriter.getDefaultWriteParam();
            jpgWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            jpgWriteParam.setCompressionQuality(1f);
            jpgWriter.setOutput(new FileImageOutputStream(ouFile));
            jpgWriter.write(null,new IIOImage(_image, null, null), jpgWriteParam);
            //ImageIO.write(_image, "jpg", ouFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes to pixel his color
     * @param xIndex The value x of the pixel
     * @param yIndex The value y of the pixel
     * @param color The color
     */
    public void writePixel(int xIndex, int yIndex, Color color){
        _image.setRGB(xIndex, yIndex, color.getRGB());
    }

}