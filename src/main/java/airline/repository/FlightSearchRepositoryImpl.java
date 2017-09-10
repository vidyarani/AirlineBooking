package airline.repository;

import airline.model.Aeroplane;
import airline.model.Flight;
import airline.model.TravelClass;
import airline.model.TravelClassType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class FlightSearchRepositoryImpl implements FlightSearchRepository {
    private ArrayList<Flight> flights = new ArrayList<Flight>();

    @Override
    public ArrayList<Flight> getFlights() {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        List<TravelClass> travelClassList1 = Arrays.asList(
                new TravelClass(TravelClassType.FIRST, 8),
                new TravelClass(TravelClassType.BUSINESS, 35),
                new TravelClass(TravelClassType.ECONOMY, 195));
        Aeroplane aeroplane1 = new Aeroplane("Boeing 777-200LR", travelClassList1);

        List<TravelClass> travelClassList2 = Arrays.asList(
                new TravelClass(TravelClassType.FIRST, 0),
                new TravelClass(TravelClassType.BUSINESS, 0),
                new TravelClass(TravelClassType.ECONOMY, 144));
        Aeroplane aeroplane2 = new Aeroplane("Airbus A319 V2", travelClassList2);

        List<TravelClass> travelClassList3 = Arrays.asList(
                new TravelClass(TravelClassType.FIRST, 0),
                new TravelClass(TravelClassType.BUSINESS, 20),
                new TravelClass(TravelClassType.ECONOMY, 152));
        Aeroplane aeroplane3 = new Aeroplane("Airbus A321", travelClassList3);

        List<TravelClass> travelClassList4 = Arrays.asList(
                new TravelClass(TravelClassType.FIRST, 8),
                new TravelClass(TravelClassType.BUSINESS, 35),
                new TravelClass(TravelClassType.ECONOMY, 195));
        Aeroplane aeroplane4 = new Aeroplane("Boeing 724-34DS", travelClassList4);

        Map<TravelClassType, Integer> availableSeats1 = new HashMap<TravelClassType, Integer>();
        availableSeats1.put(TravelClassType.FIRST, 4);
        availableSeats1.put(TravelClassType.BUSINESS, 30);
        availableSeats1.put(TravelClassType.ECONOMY, 100);

        Map<TravelClassType, Integer> availableSeats2 = new HashMap<TravelClassType, Integer>();
        availableSeats2.put(TravelClassType.FIRST, 0);
        availableSeats2.put(TravelClassType.BUSINESS, 0);
        availableSeats2.put(TravelClassType.ECONOMY, 100);

        Map<TravelClassType, Integer> availableSeats3 = new HashMap<TravelClassType, Integer>();
        availableSeats3.put(TravelClassType.FIRST, 0);
        availableSeats3.put(TravelClassType.BUSINESS, 10);
        availableSeats3.put(TravelClassType.ECONOMY, 100);

        Map<TravelClassType, Integer> availableSeats4 = new HashMap<TravelClassType, Integer>();
        availableSeats4.put(TravelClassType.FIRST, 4);
        availableSeats4.put(TravelClassType.BUSINESS, 30);
        availableSeats4.put(TravelClassType.ECONOMY, 100);

        flights.add(new Flight("F1", "HYD", "BLR", LocalDate.now(), aeroplane1, availableSeats1));
        flights.add(new Flight("F2", "HYD", "PUN", LocalDate.of(2017, 11, 7), aeroplane2, availableSeats2));
        flights.add(new Flight("F3", "BLR", "PUN", LocalDate.of(2017, 12, 6), aeroplane3, availableSeats3));
        flights.add(new Flight("F4", "HYD", "BLR", LocalDate.now().plusDays(2), aeroplane4, availableSeats4));
        return flights;
    }
}
