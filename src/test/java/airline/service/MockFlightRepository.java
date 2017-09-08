package airline.service;

import airline.model.Aeroplane;
import airline.model.Flight;
import airline.model.TravelClass;
import airline.model.TravelClassType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MockFlightRepository {
    static ArrayList<Flight> getFlights() {
        ArrayList<Flight> flights = new ArrayList<Flight>();

        List<TravelClass> travelClassList1 = Arrays.asList(
                new TravelClass(TravelClassType.FIRST, 8),
                new TravelClass(TravelClassType.BUSINESS, 35),
                new TravelClass(TravelClassType.ECONOMY, 195));
        Aeroplane aeroplane1 = new Aeroplane("Boeing", travelClassList1);

        List<TravelClass> travelClassList2 = Arrays.asList(
                new TravelClass(TravelClassType.FIRST, 0),
                new TravelClass(TravelClassType.BUSINESS, 0),
                new TravelClass(TravelClassType.ECONOMY, 144));
        Aeroplane aeroplane2 = new Aeroplane("Airbus", travelClassList2);

        List<TravelClass> travelClassList3 = Arrays.asList(
                new TravelClass(TravelClassType.FIRST, 0),
                new TravelClass(TravelClassType.BUSINESS, 20),
                new TravelClass(TravelClassType.ECONOMY, 152));
        Aeroplane aeroplane3 = new Aeroplane("Airbus", travelClassList3);

        List<TravelClass> travelClassList4 = Arrays.asList(
                new TravelClass(TravelClassType.FIRST, 8),
                new TravelClass(TravelClassType.BUSINESS, 35),
                new TravelClass(TravelClassType.ECONOMY, 195));
        Aeroplane aeroplane4 = new Aeroplane("Airbus", travelClassList4);

        flights.add(new Flight("F1", "HYD", "BLR", LocalDate.now(), aeroplane1));
        flights.add(new Flight("F2", "HYD", "PUN", LocalDate.of(2017, 11, 7), aeroplane2));
        flights.add(new Flight("F3", "BLR", "PUN", LocalDate.of(2017, 12, 6), aeroplane3));
        flights.add(new Flight("F4", "HYD", "BLR", LocalDate.now().plusDays(2), aeroplane4));
        return flights;
    }
}
