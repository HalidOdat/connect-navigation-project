package mk.ukim.finki.features.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.features.bootstrap.DataHolder;
import mk.ukim.finki.features.model.Restaurant;
import mk.ukim.finki.features.repository.RestaurantRepository;
import mk.ukim.finki.features.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    final private RestaurantRepository repository;

    @Override
    public List<Restaurant> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Restaurant restaurant) {
        this.repository.saveAndFlush(restaurant);
    }
}
