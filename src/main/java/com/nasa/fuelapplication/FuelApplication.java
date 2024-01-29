/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nasa.fuelapplication;

import com.nasa.fuelapplication.controller.FuelApplicationController;
import com.nasa.fuelapplication.domain.*;
import com.nasa.fuelapplication.services.FuelCalculationService;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pietro Corsale
 */
public class FuelApplication {

    public static void main(String[] args) {
        
        try {
            
            if (args.length < 2) {
                System.out.println("Usage: java -jar 28801 \"launch 9.801,land 1.67\" ");
                System.exit(1);
            }
            
            double                    commandModuleMass = FuelApplicationController.estractCommandModuleFromArgs(args);
            List<FlightStep>          flightRoute       = FuelApplicationController.estractStepsFromArgs(args);
           
            double                    totalFuelRequired = FuelCalculationService.calculateTotalFuel(commandModuleMass, flightRoute);

            System.out.println("Total Fuel Required: " + totalFuelRequired);
            
        }catch(IllegalArgumentException e) {
            System.out.println("Wrong input format, Usage Example: java -jar 28801 \"launch 9.801,land 1.67\" ");
            System.exit(1);
        }catch(Exception e) {       
            System.out.println("Generic Error, Usage Example: java -jar 28801 \"launch 9.801,land 1.67\" ");
            System.exit(1);
        }
    }
}
