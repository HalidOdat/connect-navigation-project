package mk.ukim.finki.features.service;

import mk.ukim.finki.features.model.Restaurant;
import mk.ukim.finki.features.model.SuperMarket;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> findAll();

    void save(Restaurant restaurant);
}
