package primitives;

public class Material {
    private double kD;
    private double kS;
    private double kR;
    private double kT;
    private int nShininess;


    /********** Constructors ***********/
    public Material(double kD, double kS, double kR, double kT, int nShininess) {
        this.kD = kD;
        this.kS = kS;
        this.kR = kR;
        this.kT = kT;
        this.nShininess = nShininess;
    }      //constructor of material


    /************** Getters/Setters *******/
    public void setkD(double kD) {
        this.kD = kD;
    }                                         //set the kd in the material

    public void setkS(double kS) {
        this.kS = kS;
    }                                         //set the ks in the material

    public void setkR(double kR) {
        this.kR = kR;
    }                                         //set the kr in the material

    public void setkT(double kT) {
        this.kT = kT;
    }                                         //set the kt in the material

    public void setnShininess(int nShininess) {
        this.nShininess = nShininess;
    }                                         //set the nshininess in the material

    public double getkR() {
        return kR;
    }                                                    //get the kr

    public double getkT() {
        return kT;
    }                                                    //get the kt

    public double getkD() {
        return kD;
    }                                                    //get the kd

    public double getkS() {
        return kS;
    }                                                    //get the ks

    public int getnShininess() {
        return nShininess;
    }                                        //get the nshininess
}
