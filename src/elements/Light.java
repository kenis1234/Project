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

    public Color mult(Color color, double ka){
        double d=color.getRGB();
        int r=(int)(color.getRed()*ka);
        int g=(int)(color.getGreen()*ka);
        int b=(int)(color.getBlue()*ka);
        return new Color(r,g,b);
    }        //mult a color with a skalar
}
