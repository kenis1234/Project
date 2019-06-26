package elements;

import java.awt.Color;
import primitives.Point3D;

public class AmbientLight extends Light{
    private double ka;


    public AmbientLight(Color c, double k){
        super(c);
        ka=k;
    }



    public Color getIntensity(Point3D t){
        double d=color.getRGB();
        int r=(int)(color.getRed()*ka);
        int g=(int)(color.getGreen()*ka);
        int b=(int)(color.getBlue()*ka);
        return new Color(r,g,b);
    }
}
