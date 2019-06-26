package primitives;

public class Material {
    private double kD;
    private double kS;
    private double kR;
    private double kT;

    public void setkD(double kD) {
        this.kD = kD;
    }

    public void setkS(double kS) {
        this.kS = kS;
    }

    public void setkR(double kR) {
        this.kR = kR;
    }

    public void setkT(double kT) {
        this.kT = kT;
    }

    public void setnShininess(int nShininess) {
        this.nShininess = nShininess;
    }

    private int nShininess;


    public Material(double kD, double kS, double kR, double kT, int nShininess) {
        this.kD = kD;
        this.kS = kS;
        this.kR = kR;
        this.kT = kT;
        this.nShininess = nShininess;
    }

    public double getkR() {
        return kR;
    }
    public double getkT() {
        return kT;
    }
    public double getkD() {
        return kD;
    }
    public double getkS() {
        return kS;
    }
    public int getnShininess() {
        return nShininess;
    }
}
