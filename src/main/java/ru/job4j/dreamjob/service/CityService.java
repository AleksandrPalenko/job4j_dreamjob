package ru.job4j.dreamjob.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.City;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
@Service
public class CityService {
    private final Map<Integer, City> cities = new HashMap<Integer, City>();
    private final AtomicInteger id = new AtomicInteger();

    public CityService() {
        cities.put(1, new City(1, "Москва"));
        cities.put(2, new City(2, "СПб"));
        cities.put(3, new City(3, "Екб"));
        cities.put(4, new City(4, "Казнь"));
        cities.put(5, new City(5, "Омск"));
        cities.put(6, new City(6, "Курск"));
        cities.put(7, new City(7, "Сочи"));

    }

    public List<City> getAllCities() {
        return new ArrayList<>(cities.values());
    }

    public City findById(int id) {
        return cities.get(id);
    }

    public void add(City city) {
        city.setId(id.incrementAndGet());
        cities.putIfAbsent(city.getId(), city);
    }

    public void update(City city) {
        cities.replace(city.getId(), city);
    }
}
