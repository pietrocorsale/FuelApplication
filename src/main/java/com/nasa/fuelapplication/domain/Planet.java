package com.nasa.fuelapplication.domain;

/**
 *
 * @author Pietro Corsale
 */
public class Planet {

    private String name;     // planet name
    private double gravity;  // planet gravity m/s^2

     // Constructor
    public Planet(double gravity) {
        this.gravity = gravity;
    }

    // Constructor 
    public Planet(String name, double gravity) {
        this.name = name;
        this.gravity = gravity;
    }

    // getter for the name
    public String getName() {
        return name;
    }

    // setter for the name
    public void setName(String name) {
        this.name = name;
    }

    //  getter for the gravity
    public double getGravity() {
        return gravity;
    }

    //  setter for the gravity
    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    // Method toString to show the object as a string
    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", gravity=" + gravity +
                '}';
    }
}

