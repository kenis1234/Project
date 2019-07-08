// Bs"d

package renderer;
import elements.LightSource;
import elements.PointLight;
import elements.SpotLight;
import geometries.FlatGeometry;
import geometries.Geometry;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static geometries.Intersectable.GeoPoint;
import static java.lang.Math.*;

public class Render {
    private static final int RECURSION_LEVEL = 3;
    public ImageWriter imageWriter;
    public Scene scene;


    /***********constructors*************/
    /**
     * constructo render
     * @param i - image writer
     * @param s- scene
     */
    public Render(ImageWriter i, Scene s){
        imageWriter=i;
        scene=s;
    }




    /******************operations**************/
    /**
     *defines if render image without super sumpling or with
     */
    public void renderImage(boolean superSumpling)
    {
        if (superSumpling)
            renderImageWithSuperSumpling();
        else
            renderImageWithoutSuperSumpling();
    }

    /**
     * build the scene- checking every pixel what color it and building the image
     */
    public void renderImageWithoutSuperSumpling(){
        for(int x=0;x<imageWriter.getNx();x++)                      //every pixel
            for(int y=0;y<imageWriter.getNy();y++) {
                Ray ray=scene.getCamera().constructRayThroughPixel(x,y,imageWriter.getWidth(),imageWriter.getHeight(),imageWriter.getNx(),imageWriter.getNy(),scene.getDistance());  //construct ray with the camera
                Point3D tmp=new Point3D(ray.getHead());                                                                // temp we store in him some point
                ray.setHead(scene.getCamera().getP0());                                                                //set in the ray the point of the camera
                List<GeoPoint> intersectionPoints=getSceneRayIntersections(ray);                                       //find the intersection points
                ray.setHead(tmp);                                                                                      //returns the point we stored
                if (intersectionPoints.isEmpty())                                                                      // if it is not intersecting with nothing
                    imageWriter.writePixel(x,y,scene.getBackground());                                                 //the color os the background
                else
                {
                    GeoPoint closestPoint=getClosestPoint(intersectionPoints,scene.getCamera().getP0());               //get the closest intersection point
                    imageWriter.writePixel(x,y,calcColor(closestPoint,ray));                                           //write in this pixel the calculated color
                }
            //printGrid(50);
            }
            imageWriter.writeToimage();                                                                              // this function build the image
    }

    /**
     * build the scene- checking every pixel 5 times what color it and building the image
     */
    public void renderImageWithSuperSumpling(){
        for(int x=0;x<imageWriter.getNx();x++)                      //every pixel
            for(int y=0;y<imageWriter.getNy();y++) {
                Ray ray1=scene.getCamera().constructRayThroughPixel(
                        x,y,
                        imageWriter.getWidth(),imageWriter.getHeight(),
                        imageWriter.getNx(),imageWriter.getNy(),
                        scene.getDistance());   //construct rays with the camera
                Ray ray2=scene.getCamera().constructRayThroughPixel(x+0.4,y,imageWriter.getWidth(),imageWriter.getHeight(),imageWriter.getNx(),imageWriter.getNy(),scene.getDistance());
                Ray ray3=scene.getCamera().constructRayThroughPixel(x-0.4,y,imageWriter.getWidth(),imageWriter.getHeight(),imageWriter.getNx(),imageWriter.getNy(),scene.getDistance());
                Ray ray4=scene.getCamera().constructRayThroughPixel(x,y+0.4,imageWriter.getWidth(),imageWriter.getHeight(),imageWriter.getNx(),imageWriter.getNy(),scene.getDistance());
                Ray ray5=scene.getCamera().constructRayThroughPixel(x,y-0.4,imageWriter.getWidth(),imageWriter.getHeight(),imageWriter.getNx(),imageWriter.getNy(),scene.getDistance());
                List<Ray> rays=new ArrayList<Ray>();
                rays.add(ray1);
                rays.add(ray2);
                rays.add(ray3);
                rays.add(ray4);
                rays.add(ray5);
                Color color =new Color(0,0,0);
                Color temp=new Color(0,0,0);
                for (Ray ray : rays)
                {
                    Point3D tmp=new Point3D(ray.getHead());              // temp we store in him some point
                    ray.setHead(scene.getCamera().getP0());
                    List<GeoPoint> intersectionPoints=getSceneRayIntersections(ray);       //find the intersection points
                    ray.setHead(tmp);                                                    //returns the point we stored
                    if (intersectionPoints.isEmpty())                                    // if it is not intersecting with nothing
                        temp=scene.getBackground();                                      //the color os the background
                    else
                    {
                        GeoPoint closestPoint=getClosestPoint(intersectionPoints,scene.getCamera().getP0());              //get the closest intersection point
                        temp=calcColor(closestPoint,ray);                                                             //calculate the color

                    }
                    temp=mult(temp,1/5.0);                       //for the memuza
                    color=add(color,temp);                           //color is the memuza
                }
                imageWriter.writePixel(x,y,color);                //write in this pixel the calculated color

            }
        imageWriter.writeToimage();
    }

    /**
     *  finds the intersections
     * @param ray - the ray with him we check if there are intersection points
     * @return - list of geopoints
     */
    private List<GeoPoint> getSceneRayIntersections(Ray ray) {
        Iterator<Geometry> geometries=scene.getGeometriesIterator();          //for the loop
        List<GeoPoint> intersecrionsPoints=new ArrayList<GeoPoint>();
        while(geometries.hasNext())              //for each geometry
        {
            Geometry geometry=geometries.next();
            List<GeoPoint> geometryIntersectionPoints=geometry.findIntersections(ray);        //find iintersection of this geometry
            intersecrionsPoints.addAll(geometryIntersectionPoints);                        //add them to the overall intersections
        }
        List<GeoPoint> tmp=new ArrayList<GeoPoint>();               //temp we store in him the "fake" intersection points
        for (GeoPoint gp : intersecrionsPoints)
        {
            Vector v=gp.point.sub(ray.getHead());
            if(abs(v.getHead().getCoordinate_x().get())<8&&abs(v.getHead().getCoordinate_y().get())<8&&abs(v.getHead().getCoordinate_z().get())<8)  //if there are too close
                tmp.add(gp);
        }
        for (GeoPoint gp : tmp)
        {
            intersecrionsPoints.remove(gp);                 //remove them from the intersection points
        }

        return intersecrionsPoints;
    }
   // private static final double MIN_CALC_COLOR_K = 0.001;

    /**
     * calculating the color in specific point
     * @param geopoint - the point and geometry that we check the color there
     * @param inRay - the ray we got to this point
     * @return - the calculated color
     */
    private Color calcColor(GeoPoint geopoint, Ray inRay) {
        return calcColor(geopoint,inRay,0);
    }

    /**
     * calculating the color in specific point
     * @param geopoint the point and geometry that we check the color there
     * @param inRay the ray we got to this point
     * @param level - the recursion level
     * @return the calculated color
     */
    private Color calcColor(GeoPoint geopoint, Ray inRay, int level) {
        if(level==RECURSION_LEVEL)
            return new Color(0,0,0);

        Color color = scene.getAmbient().getIntensity(new Point3D(0, 0, 0));   //adding the ambient
        System.out.println("ambient: "+color);
        System.out.println( "emission: "+geopoint.geometry.getEmission());
        color = add(color, geopoint.geometry.getEmission());                                                  //adding the enission


        Vector v =geopoint.point.sub(scene.getCamera().getP0()).normalize();                        //vector from camera to point
        Vector n = geopoint.geometry.getNormal(geopoint.point);                                     //normal of the geometry in this point
        int nShininess = geopoint.geometry.getMaterial().getnShininess();                           //factors
        double kd = geopoint.geometry.getMaterial().getkD();
        double ks = geopoint.geometry.getMaterial().getkS();
        for (LightSource lightSource : scene.getLights()) {                                         //foreach lightsource
            Vector l = lightSource.getL(geopoint.point);                                             //direction of the light source to the point
            if (unshaded(lightSource,geopoint.point,geopoint.geometry)) {                            //if the point is unshaded of the light source
                Color lightIntensity = lightSource.getIntensity(geopoint.point);                     //the original intensity of the light source
                color=add(color,calcDiffusive(kd, l, n, lightIntensity));                            //calculating and adding the diffusion
                color=add(color,calcSpecular(ks, l, n, v, nShininess, lightIntensity));              //calculating and adding the specular
            }
        }

        Color reflectedLight = new Color(0,0,0);
        // Recursive call for a reflected ray
        Ray reflectedRay = constructReflectedRay(geopoint.geometry.getNormal(geopoint.point), geopoint.point, inRay);   //calculating the reflected ray
        List<GeoPoint> intersectionPoints=getSceneRayIntersections(reflectedRay);                                       //find intersection points
        if(!intersectionPoints.isEmpty()){                                                                            //if there are intersection points
            GeoPoint reflectedEntry = getClosestPoint(intersectionPoints, geopoint.point);                           //choose the close point

            Color reflectedColor = calcColor(reflectedEntry,reflectedRay,level+1);                             //calculating the color
            double kr = geopoint.geometry.getMaterial().getkR();                                                    //factor

           reflectedLight = mult(reflectedColor,kr);                                                                     //calculating the reflected light
        }


// Recursive call for a refracted ray
        Ray refractedRay = constructRefractedRay(geopoint.geometry.getNormal(geopoint.point), geopoint.point, inRay); //calculating the refracted ray
        List<GeoPoint> intersectionPoints1=getSceneRayIntersections(refractedRay);                       //find intersection points
        Color refractedLight = new Color(0,0,0);
        if(!intersectionPoints1.isEmpty()){                                                        //if there are intersection points
            GeoPoint refractedEntry = getClosestPoint(intersectionPoints1, geopoint.point);      //choose the close point

            Color refractedColor = calcColor(refractedEntry, refractedRay,level+1);                           //calculating the color
            double kt = geopoint.geometry.getMaterial().getkT();                                                   //factor
            refractedLight = mult(refractedColor,kt);                                                         //calculating the reflected light
        }
        color=add(color,reflectedLight);                          //addingg the reflected light
        color=add(color,refractedLight);                          //addingg the refracted light
        return color;
    }

    /**
     * constructs reflected ray
     * @param normal - the normal of the geometry in the point
     * @param point - the point we construct the ray throw him
     * @param inRay - the original ray
     * @return - reflected ray
     */
    private Ray constructRefractedRay(Vector normal, Point3D point, Ray inRay) {
        Vector v=inRay.getDirection();
        Vector no=new Vector(normal);
        no.mult(-2);
        Point3D p=new Point3D(point);
        p=p.add(no);                                         //so there will not be floating point

        Ray r=new Ray(v,p);
        return r;
    }

    /**
     * constructs refracted ray
     * @param normal- the normal of the geometry in the point
     * @param point - the point we construct the ray throw him
     * @param inRay - the original ray
     * @return - reflected ray
     */

    private Ray constructReflectedRay(Vector normal, Point3D point, Ray inRay) {
        Vector D = new Vector(inRay.getDirection());
        Vector R = D.sub(normal.mult(2 * D.dotProduct(normal)));   //calculating the direction of reflected ray
        R.normalize();                                           //direction

        Vector v = new Vector(normal);
        v.mult(2);
        Point3D p = new Point3D(point);
        p=p.add(v);                                         //so there will not be floating point

        return new Ray(R, p);
    }

    /**
     * checking if the point dont have shade of some light source
     * @param light - the light source
     * @param point - the point we check in the shadow
     * @param geometry - the geometry of the point
     * @return - bool- if it doeasnt shaded- true
     */
    private boolean unshaded(LightSource light, Point3D point, Geometry geometry) {

        Vector lightDirection=new Vector(light.getL(point));
        lightDirection.mult(-1);
        lightDirection.normalize();                                    // from point to light source

        Point3D geometryPoint=new Point3D(point);
        Vector epsVector = new Vector(geometry.getNormal(point).normalize());
        epsVector.mult(2);
        geometryPoint = geometryPoint.add(epsVector);                               //so there will not be floating point


        Ray lightRay = new Ray( lightDirection,geometryPoint);
        List<GeoPoint> intersectionPoints=getSceneRayIntersections(lightRay);      //checking if there are something between the point and the light


        List<GeoPoint> tmp=new ArrayList<GeoPoint>();
        for (GeoPoint gp:intersectionPoints)             //searching for faked intersection points
        {
            Vector v=gp.point.sub(geometryPoint);
            if(abs(v.getHead().getCoordinate_x().get())<8&&abs(v.getHead().getCoordinate_y().get())<8&&abs(v.getHead().getCoordinate_z().get())<8)      //if too close
                tmp.add(gp);
            else if(gp.geometry instanceof FlatGeometry &&geometry==gp.geometry)                                         //if it flat and intersect with himself
                tmp.add(gp);
            else if(gp.geometry.getMaterial().getkT() != 0)                                                              //if it a little shakuf
                tmp.add(gp);
            else if(light instanceof PointLight)
            {
                PointLight pl = (PointLight)light;
                if(point.distance(pl.getPosition()) < point.distance(gp.point))
                    tmp.add(gp);
            }
            else if(light instanceof SpotLight)
            {
                SpotLight sl = (SpotLight)light;
                if(point.distance(sl.getPosition()) < point.distance(gp.point))
                    tmp.add(gp);
            }
        }
        for (GeoPoint gp:tmp)
        {
                intersectionPoints.remove(gp);                 //remove all the faked points
        }
        return intersectionPoints.isEmpty();          //if there are no intersection- it is not sahded


    }

    /**
     * printing a white grid
     * @param interval - how much pixels in each square
     */
    public void printGrid(int interval) {
        Color white=new Color(255,255,255);
        int px=imageWriter.getNx();
        int py=imageWriter.getNy();
        for(int i=0;i<px;i+=interval)
        {
            for (int j=0;j<py;j++)
            {
                imageWriter.writePixel(i,j,white);
            }
        }
        for(int i=0;i<py;i+=interval)
        {
            for (int j=0;j<px;j++)
            {
                imageWriter.writePixel(j,i,white);
            }
        }
    }

    /**
     * calculating the difuusive color
     * @param kd - some factor
     * @param l - the direction of the light to the point
     * @param n - the normal of the geometry in that point
     * @param lightIntensity - the original light of the light source
     * @return the claculated color
     */
    private Color calcDiffusive(double kd, Vector l, Vector n, Color lightIntensity) {
        l.normalize();
        n.normalize();
        double k=kd*(abs(l.dotProduct(n)));
        return (mult(lightIntensity,k));           //according to the lecture
    }

    /**
     * Calculates the calculated color of the Specular
     * @param ks The attenuation coefficient KS
     * @param l The vector from the light source to the desired point
     * @param n The normal at the desired point
     * @param v The vector from camera to desired point
     * @param nShininess  The attenuation coefficient nShininess
     * @param lightIntensity The intensity of the lightSource in the desired point
     * @return The calculated color in the desired point
     */
    private Color calcSpecular(double ks, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {
        v.normalize();
        n.normalize();
        l.normalize();
        Vector n1 = new Vector(n);
        Vector r = new Vector(l.sub(n1.mult(2 * (l.dotProduct(n1)))));
        Vector v1 = new Vector(v);
        v1.mult(-1);
        double k = max(0, ks * (pow(v1.dotProduct(r), nShininess)));            //according to the lecture
        return (mult(lightIntensity, k));
    }

    /**
     * The function returns from the list of points the closest point to the current point
     * @param points The list of points
     * @param p The main point
     * @return
     */
    private GeoPoint getClosestPoint(List<GeoPoint> points, Point3D p){
        double distance=Double.MAX_VALUE;
        Point3D P0=new Point3D(p);
        GeoPoint minDistancePoint=null;

        for(GeoPoint geoPoint: points)       //for each point
            if(P0.distance(geoPoint.point)<distance)           //if it the closest point until now
            {
                minDistancePoint=new GeoPoint(geoPoint);
                distance=P0.distance(geoPoint.point);
            }
        return minDistancePoint;
    }

    /**
     * The function multiplies color with an attenuation coefficient
     * @param color The color
     * @param ka The reduction factor KA
     * @return The result of the multiplies between the color with the reduction factor KA
     */
    public Color mult(Color color, double ka){
        double d=color.getRGB();
        int r=min((int)(color.getRed()*ka),255);                //because it cant be bigger than 255
        int g=min((int)(color.getGreen()*ka),255);
        int b=min((int)(color.getBlue()*ka),255);
        return new Color(r,g,b);
    }

    /**
     * The function has been summed up two colors
     * @param a color a
     * @param b color b
     * @return The result of the connection between color A and color b
     */
    private Color add (Color a,Color b){
        int r=min(255,a.getRed()+b.getRed());                //because it cant be bigger than 255
        int g=min(255,a.getGreen()+b.getGreen());
        int bl=min(255,a.getBlue()+b.getBlue());
        return new Color(r,g,bl);
    }
}
