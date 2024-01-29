package com.nasa.fuelapplication.controller;

import com.nasa.fuelapplication.domain.ActionType;
import com.nasa.fuelapplication.domain.FlightStep;
import com.nasa.fuelapplication.domain.Planet;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for the Fuel Application.
 * This class provides methods to extract mission data from input arguments.
 * @author Pietro Corsale
 */
public class FuelApplicationController {
    /**
     * Extracts a CommandModule object from the provided arguments.
     * The first argument is expected to be a numeric value representing the ship mass.
     *
     * @param args The command line arguments passed to the application.
     * @return the command module mass.
     * @throws IllegalArgumentException If the first argument is not a valid double value.
     */
    
    public static double estractCommandModuleFromArgs(String[] args) throws IllegalArgumentException {
        double shipMass;
        try {
            shipMass = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid ship mass: " + args[0], e);
        }
        return shipMass;
    }
    /**
     * Extracts a list of FlightStep objects from the provided arguments.
     * The second argument is expected to be a comma-separated string,
     * where each part is a space-separated pair consisting of an ActionType and a gravity value.
     *
     * @param args The command line arguments passed to the application.
     * @return A list of FlightStep objects representing the flight route.
     * @throws IllegalArgumentException If the second argument is not in the expected format or contains invalid values.
     */
    public static List<FlightStep> estractStepsFromArgs(String[] args) throws IllegalArgumentException {
        String[] steps               = args[1].split(",");          //extract the second argument , the flight route
        List<FlightStep> flightRoute = new ArrayList<>();

        for (String step : steps) {
            String[] parts           = step.trim().split(" ");      // separate the first and the second part of the step
            if (parts.length != 2) {
                throw new IllegalArgumentException("Invalid step format: " + step);
            }
            ActionType actionType    = ActionType.valueOf(parts[0].toUpperCase());// screate action type 
            double gravity;
            try {
                gravity = Double.parseDouble(parts[1]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid gravity value: " + parts[1], e);
            }
            flightRoute.add(new FlightStep(actionType, new Planet(gravity)));    // update the list of flight steps
        }
        return flightRoute;
    }
    
}
