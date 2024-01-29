package com.nasa.fuelapplication.services;

import com.nasa.fuelapplication.domain.ActionType;
import com.nasa.fuelapplication.domain.FlightStep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Service class for calculating the total fuel required for a space mission.
 * It includes methods for calculating fuel for individual flight steps and the entire journey.
 * @author Pietro Corsale
 */

public class FuelCalculationService {
    private static final double LAUNCH_FUEL_CONSTANT = 0.042;
    private static final double LAUNCH_FUEL_BASE = 33;
    private static final double LAND_FUEL_CONSTANT = 0.033;
    private static final double LAND_FUEL_BASE = 42;

    /**
     * Calculates the total fuel required for the entire journey.
     * This method iterates through each flight step in reverse order to calculate the fuel needed,
     * including the additional fuel required to carry the fuel itself.
     *
     * @param commandModuleMass The CommandModule mass.
     * @param flightRoute   A List of FlightStep objects representing the flight route.
     * @return The total amount of fuel required for the journey.
     */
    public static double calculateTotalFuel(double commandModuleMass, List<FlightStep> flightRoute) throws IllegalArgumentException {
        if (commandModuleMass < 0) {
            throw new IllegalArgumentException("Command module mass can't be negative");
        }
        if (flightRoute == null || flightRoute.isEmpty()) {
            throw new IllegalArgumentException("Flight route must not be null or empty.");
        }

        double totalFuel = 0;
        double currentMass = commandModuleMass;

        List<FlightStep> modifiableList = new ArrayList<>(flightRoute);
        Collections.reverse(modifiableList);

        for (FlightStep step : modifiableList) {
            if (step == null) {
                throw new IllegalArgumentException("Flight steps must not contain null values.");
            }
            double stepFuel = calculateFuelForStep(currentMass, step);
            totalFuel += stepFuel;
            currentMass += stepFuel; // Incrementing mass by the fuel added for the current step
        }

        return totalFuel;
    }

    /**
     * Recursively calculates the fuel required for a single step of the journey.
     * It accounts for the fuel's own weight by recursively adding the fuel needed to carry the fuel.
     *
     * @param mass The mass of the spacecraft including any fuel already added.
     * @param step The FlightStep object representing a single step of the journey.
     * @return The total fuel required for this step, including fuel needed for the fuel's weight.
     */
    private static double calculateFuelForStep(double mass, FlightStep step) {
        double fuel = calculateBasicFuel(mass, step.getActionType(), step.getPlanet().getGravity());
        if (fuel <= 0) {
            return 0;
        } else {
            return fuel + calculateFuelForStep(fuel, step); // Recursively calculate the additional fuel required by the added fuel's weight
        }
    }

    /**
     * Calculates the basic fuel requirement for either launching or landing, not including the fuel's own weight.
     * This calculation is based on the spacecraft's mass, the action type (launch or land), and the planet's gravity.
     *
     * @param mass       The mass of the spacecraft.
     * @param actionType The type of action (launch or land).
     * @param gravity    The gravity of the planet for the current step.
     * @return The basic amount of fuel required for the action.
     */
    private static double calculateBasicFuel(double mass, ActionType actionType, double gravity) {
        double fuel;
        if (actionType == ActionType.LAUNCH) {
            fuel = mass * gravity * LAUNCH_FUEL_CONSTANT - LAUNCH_FUEL_BASE;
        } else { // ActionType.LAND
            fuel = mass * gravity * LAND_FUEL_CONSTANT - LAND_FUEL_BASE;
        }

        fuel = Math.floor(fuel); // Apply rounding down at the last step
        return Math.max(fuel, 0); // Ensure that the fuel is not negative
    }
}

