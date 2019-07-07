// Bs"d

package primitives;

public class Material {
    private double kD;
    private double kS;
    private double kR;
    private double kT;
    private int nShininess;


    /********** Constructors ***********/
    /**
     * Default constructor
     */
    public Material() {
        this.kD = 1;
        this.kS = 1;
        this.kR = 0;
        this.kT = 0;
        this.nShininess = 1;
    }

    /**
     * Constructor that accepts all required parameters
     * @param kD Attenuation coefficient kD
     * @param kS Attenuation coefficient kS
     * @param kR Attenuation coefficient kR
     * @param kT Attenuation coefficient kT
     * @param nShininess Level of the Shininess
     */
    public Material(double kD, double kS, double kR, double kT, int nShininess) {
        this.kD = kD;
        this.kS = kS;
        this.kR = kR;
        this.kT = kT;
        this.nShininess = nShininess;
    }      //constructor of material

    /**
     * Copy constructor
     * @param material The other Material
     */
    public Material(Material material){
        this.kD = material.getkD();
        this.kS = material.getkS();
        this.kR = material.getkR();
        this.kT = material.getkT();
        this.nShininess = material.getnShininess();
    }                                                //copy constructor



    /************** Getters/Setters *******/
    /**
     * Set the attenuation coefficient kD
     * @param kD Attenuation coefficient kD
     */
    public void setkD(double kD) {
        this.kD = kD;
    }                                         //set the kd in the material

    /**
     * Set the attenuation coefficient kS
     * @param kS Attenuation coefficient kS
     */
    public void setkS(double kS) {
        this.kS = kS;
    }                                         //set the ks in the material

    /**
     * Set the attenuation coefficient kR
     * @param kR Attenuation coefficient kR
     */
    public void setkR(double kR) {
        this.kR = kR;
    }                                         //set the kr in the material

    /**
     * Set the attenuation coefficient kT
     * @param kT  Attenuation coefficient kT
     */
    public void setkT(double kT) {
        this.kT = kT;
    }                                         //set the kt in the material

    /**
     * Set the value of level of the Shininess
     * @param nShininess The level of the Shininess
     */
    public void setnShininess(int nShininess) {
        this.nShininess = nShininess;
    }                                         //set the nshininess in the material

    /**
     * Get the attenuation coefficient kR
     * @return  Attenuation coefficient kR
     */
    public double getkR() {
        return kR;
    }                                                    //get the kr

    /**
     * Get the attenuation coefficient kT
     * @return Attenuation coefficient kT
     */
    public double getkT() {
        return kT;
    }                                                    //get the kt

    /**
     * Get the attenuation coefficient kD
     * @return Attenuation coefficient kD
     */
    public double getkD() {
        return kD;
    }                                                    //get the kd

    /**
     * Get the attenuation coefficient kS
     * @return Attenuation coefficient kS
     */
    public double getkS() {
        return kS;
    }                                                    //get the ks

    /**
     * Get the value of level of the Shininess
     * @return The the value of level of the Shininess
     */
    public int getnShininess() {
        return nShininess;
    }                                        //get the nshininess
}
