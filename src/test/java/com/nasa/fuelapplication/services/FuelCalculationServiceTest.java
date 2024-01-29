package com.nasa.fuelapplication.services;
import com.nasa.fuelapplication.domain.ActionType;
import com.nasa.fuelapplication.domain.Planet;
import com.nasa.fuelapplication.domain.FlightStep;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class FuelCalculationServiceTest {

    @Test
    void testApollo11() {
        double commandModuleMass = 28801; 
        Planet earth = new Planet("Earth",9.807d); 
        Planet moon = new Planet("Moon",1.62d); 

        FlightStep launchEarth = new FlightStep(ActionType.LAUNCH, earth);
        FlightStep landMoon = new FlightStep(ActionType.LAND, moon);
        FlightStep launchMoon = new FlightStep(ActionType.LAUNCH, moon);
         FlightStep landEarth = new FlightStep(ActionType.LAND, earth);
        List<FlightStep> flightRoute = List.of(launchEarth, landMoon,launchMoon,landEarth);

        double totalFuel = FuelCalculationService.calculateTotalFuel(commandModuleMass, flightRoute);
        System.out.println("totalFuel");
        System.out.println(totalFuel);
        assertTrue(51898 ==  totalFuel);
        
    }
    @Test
    void testMissionOnMars() {
        double commandModuleMass = 14606;
        Planet earth = new Planet("Earth",9.807d); 
        Planet mars = new Planet("Mars",3.711d);

        FlightStep launchEarth = new FlightStep(ActionType.LAUNCH, earth);
        FlightStep landMars = new FlightStep(ActionType.LAND, mars);
        FlightStep launchMars = new FlightStep(ActionType.LAUNCH, mars);
         FlightStep landEarth = new FlightStep(ActionType.LAND, earth);
        List<FlightStep> flightRoute = List.of(launchEarth, landMars,launchMars,landEarth);

        double totalFuel = FuelCalculationService.calculateTotalFuel(commandModuleMass, flightRoute);
        System.out.println("totalFuel");
        System.out.println(totalFuel);
        assertTrue(33388 ==  totalFuel); 
    }
    @Test
    void testPassengerShip() {
        double commandModuleMass = 75432;
        Planet earth = new Planet("Earth",9.807d); 
        Planet moon = new Planet("Moon",1.62d); 
        Planet mars = new Planet("Mars",3.711d); 

        FlightStep launchEarth = new FlightStep(ActionType.LAUNCH, earth);
        FlightStep landMoon = new FlightStep(ActionType.LAND, moon);
        FlightStep launchMoon = new FlightStep(ActionType.LAUNCH, moon);
        FlightStep landMars = new FlightStep(ActionType.LAND, mars);
        FlightStep launchMars = new FlightStep(ActionType.LAUNCH, mars);
         FlightStep landEarth = new FlightStep(ActionType.LAND, earth);
        List<FlightStep> flightRoute = List.of(launchEarth, landMoon,launchMoon,landMars,launchMars,landEarth);

        double totalFuel = FuelCalculationService.calculateTotalFuel(commandModuleMass, flightRoute);
        System.out.println("totalFuel");
        System.out.println(totalFuel);
        assertTrue(212161 ==  totalFuel);
    }
}