package airline.service;

import airline.model.City;
import airline.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    public List<City> getCities() {
        CityRepository cityRepository = new CityRepository();
        return cityRepository.getCities();
    }
}
