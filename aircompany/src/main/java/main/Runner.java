package main;

import airport.Airport;
import utilities.PlanesCreator;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class Runner {
    private static final Logger logger = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
        Airport airport = new Airport(PlanesCreator.getPlanes);
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlanes());
        logger.log(Level.INFO, "Military airport sorted by max distance: " +
                militaryAirport.sortPlanesByMaxFightDistance()
                        .toString());
        logger.log(Level.INFO, "Passenger airport sorted by max speed: " +
                passengerAirport.sortPlanesByMaxSpeed()
                        .toString());
        logger.log(Level.INFO, "Plane with max passenger capacity: " +
                passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }
}
