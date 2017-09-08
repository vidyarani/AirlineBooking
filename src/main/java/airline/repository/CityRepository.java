package airline.repository;

import airline.model.City;

import java.util.ArrayList;
import java.util.List;

public class CityRepository {

    public List<City> getCities() {
        List<City> cities = new ArrayList<City>();
        cities.add(new City("HYD", "Hyderabad"));
        cities.add(new City("BLR", "Bengaluru"));
        cities.add(new City("PUN", "Pune"));
        return cities;
    }

}
