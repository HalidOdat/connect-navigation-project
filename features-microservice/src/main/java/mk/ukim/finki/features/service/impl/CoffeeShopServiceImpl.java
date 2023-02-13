package mk.ukim.finki.features.service.impl;

import mk.ukim.finki.features.bootstrap.DataHolder;
import mk.ukim.finki.features.model.CoffeeShop;
import mk.ukim.finki.features.repository.CoffeeShopRepository;
import mk.ukim.finki.features.service.CoffeeShopService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeShopServiceImpl implements CoffeeShopService {
    final private CoffeeShopRepository repository;

    public CoffeeShopServiceImpl(CoffeeShopRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CoffeeShop> findAll() {
        if (repository.count() == 0) {
            repository.saveAll(DataHolder.coffeeShops);
        }
        return repository.findAll();
    }
}
