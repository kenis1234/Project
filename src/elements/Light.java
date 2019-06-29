package elements;
import primitives.Point3D;
import java.awt.Color;
public abstract class Light {
    Color color;

    /********** Constructors ***********/
    public Light(Color color) {
        this.color = new Color(color.getRGB());
    }  //copy constructor


    /************** Getters/Setters *******/
    public Color getColor() {
        return color;
    }             //get the color


    /************** Operations ***************/
    public abstract Color getIntensity(Point3D tmp);      //abstract function that all lights have to implement
}
