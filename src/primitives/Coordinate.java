// Bs"d
package primitives;

import static primitives.Util.*;

public final class Coordinate {
    //private static final double EPSILON = 0.0000001;
    protected double _coord;

    public static Coordinate ZERO = new Coordinate(0.0);

    /********** Constructors ***********/
    /**
     * Constructor that receives a double number and initializes as a coordinate
     * @param coord The value for the coordinate
     */
    public Coordinate(double coord) {
        // if it too close to zero make it zero
        _coord = alignZero(coord);
    }

    /**
     * Copy Constructor
     * @param other The other Coordinate
     */
    public Coordinate(Coordinate other) {
        _coord = other._coord;
    }

    /************** Getters/Setters *******/
    /**
     * Returns the value of the Coordinate as double
     * @return The value of the Coordinate as double
     */
    public double get() {
        return _coord;
    }

    /*************** Admin *****************/
    /**
     * Checks whether the object received is equal to the current coordinate
     * @param obj The other object
     * @return if they equals - True; else - False
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Coordinate)) return false;
        return usubtract(_coord, ((Coordinate)obj)._coord) == 0.0;
    } // Checks whether two coordinates are equal

    /**
     * Displays the current coordinate as a string
     * @return the display of the current coordinate as string
     */
    @Override
    public String toString() {
        return "" + _coord;
    }

    /************** Operations ***************/
    /**
     * Subtracts the other coordinate from the current coordinate
     * @param other The other coordinate
     * @return The result of subtraction between the other coordinate and the current coordinate
     */
    public Coordinate subtract(Coordinate other) {
        return new Coordinate(usubtract(_coord, other._coord));
    } // Performs subtraction between coordinates

    /**
     * Adding the other coordinate from the current coordinate
     * @param other The other coordinate
     * @return The result of adding between the other coordinate and the current coordinate
     */
    public Coordinate add(Coordinate other) {
        return new Coordinate(uadd(_coord, other._coord));
    } // Performs add between coordinates

    /**
     * Multiplication of the current coordinate in scale
     * @param num The scale
     * @return The result of multiplication of the current coordinate in scale
     */
    public Coordinate scale(double num) {
        return new Coordinate(uscale(_coord, num));
    } // Multiply the coordinate in scale

    /**
     * Multiply the other coordinate from the current coordinate
     * @param other The other coordinate
     * @return The result of multiply between the other coordinate and the current coordinate
     */
    public double multiply(Coordinate other) {
        return uscale(_coord, other._coord);
    } // Multiply the coordinate in other coordinate

}
