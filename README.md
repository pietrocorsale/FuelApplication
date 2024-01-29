# FuelApplication

## Overview

FuelApplication is a Java-based application designed to calculate the fuel requirements for space missions. This application takes into account the mass of the spacecraft and the flight route, including actions such as launching and landing on various planetary bodies.

## Package Structure

- `com.nasa.fuelapplication`: The root package containing the main application class.
- `com.nasa.fuelapplication.controller`: Contains classes responsible for parsing input data.
- `com.nasa.fuelapplication.domain`: This package includes domain classes such as `ActionType`, `FlightStep`, and `Planet` that represent the core concepts of the application.
- `com.nasa.fuelapplication.services`: Service classes that perform the fuel calculation logic.
- `com.nasa.fuelapplication.services.test`: Contains unit tests for the services.

## Key Classes

- `FuelApplication`: The entry point of the application.
- `FuelApplicationController`: Parses input arguments to extract Command Module mass and flight steps information.
- `ActionType`: An enumeration that defines the types of actions that can be performed during the flight (e.g., LAUNCH, LAND).
- `FlightStep`: Represents a single step in the flight route, containing an action and the associated planet.
- `Planet`: Represents a planetary body, encapsulating properties like gravity.
- `FuelCalculationService`: Provides methods to calculate the total fuel required for the mission.

## Usage

To use this application, you need to provide command-line arguments representing the spacecraft's mass and the flight route. The application will then calculate the total fuel requirements for the mission.

Example input format:
```shell
java -jar FuelApplication-1.0-SNAPSHOT.jar <shipMass> <flightSteps>
```
- `shipMass`: A double value representing the mass of the spacecraft in kilograms.
- `flightSteps`: A comma-separated list of flight steps. Each step is a space-separated value consisting of an `ActionType` and a gravity value (e.g., "LAUNCH 9.81, LAND 3.711").

## Running the Tests

To run the unit tests for the application, navigate to the test package `com.nasa.fuelapplication.services.test` and execute the `FuelCalculationServiceTest` class.

## Building and Running

- Ensure you have JDK 14 or higher installed.
- Ensure you have Maven installed.
- Compile and package the source code using `mvn install` or your preferred IDE.
- Run the jar in the target folder using the command mentioned above.
