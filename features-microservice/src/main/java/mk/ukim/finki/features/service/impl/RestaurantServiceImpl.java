package mk.ukim.finki.features.service.impl;

import mk.ukim.finki.features.bootstrap.DataHolder;
import mk.ukim.finki.features.model.Restaurant;
import mk.ukim.finki.features.repository.RestaurantRepository;
import mk.ukim.finki.features.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    final private RestaurantRepository repository;

    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Restaurant> findAll() {
        if (repository.count() == 0) {
            repository.saveAll(DataHolder.restaurants);
        }
        return repository.findAll();
    }
}
