package mk.ukim.finki.features.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.features.bootstrap.DataHolder;
import mk.ukim.finki.features.model.CoffeeShop;
import mk.ukim.finki.features.repository.CoffeeShopRepository;
import mk.ukim.finki.features.service.CoffeeShopService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoffeeShopServiceImpl implements CoffeeShopService {
    final private CoffeeShopRepository repository;

    @Override
    public List<CoffeeShop> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(CoffeeShop coffeeShop) {
        this.repository.saveAndFlush(coffeeShop);
    }
}
