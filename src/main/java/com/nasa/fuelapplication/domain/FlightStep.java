package com.nasa.fuelapplication.domain;

/**
 *
 * @author Pietro Corsale
 */
public class FlightStep {
    private ActionType actionType;
    private Planet planet;

    // Constructor
    public FlightStep(ActionType actionType, Planet planet) {
        this.actionType = actionType;
        this.planet = planet;
    }

    // Getter for actionType
    public ActionType getActionType() {
        return actionType;
    }

    // Setter for actionType
    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    // Getter for planet
    public Planet getPlanet() {
        return planet;
    }

    // Setter for planet
    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}
