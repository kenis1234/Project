package elements;
import primitives.Point3D;
import java.awt.Color;
public abstract class Light {
    public Color getColor() {
        return color;
    }

    Color color;
    public abstract Color getIntensity(Point3D tmp);

    public Light(Color color) {
        this.color = color;
    }

}
