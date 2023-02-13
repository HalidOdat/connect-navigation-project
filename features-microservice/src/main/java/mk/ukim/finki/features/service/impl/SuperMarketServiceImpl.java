package mk.ukim.finki.features.service.impl;

import mk.ukim.finki.features.bootstrap.DataHolder;
import mk.ukim.finki.features.model.SuperMarket;
import mk.ukim.finki.features.repository.SuperMarketRepository;
import mk.ukim.finki.features.service.SuperMarketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperMarketServiceImpl implements SuperMarketService {
    final private SuperMarketRepository repository;

    public SuperMarketServiceImpl(SuperMarketRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SuperMarket> findAll() {
        if (repository.count() == 0) {
            repository.saveAll(DataHolder.superMarkets);
        }
        return repository.findAll();
    }
}
