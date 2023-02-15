package mk.ukim.finki.features.service;

import mk.ukim.finki.features.model.CoffeeShop;
import mk.ukim.finki.features.model.GasStation;

import java.util.List;

public interface CoffeeShopService {
    List<CoffeeShop> findAll();
    void save(CoffeeShop coffeeShop);
}
