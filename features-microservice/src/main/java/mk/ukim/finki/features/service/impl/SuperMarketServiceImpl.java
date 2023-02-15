package mk.ukim.finki.features.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.features.bootstrap.DataHolder;
import mk.ukim.finki.features.model.SuperMarket;
import mk.ukim.finki.features.repository.SuperMarketRepository;
import mk.ukim.finki.features.service.SuperMarketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SuperMarketServiceImpl implements SuperMarketService {
    final private SuperMarketRepository repository;

    @Override
    public List<SuperMarket> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(SuperMarket superMarket) {
        this.repository.saveAndFlush(superMarket);
    }
}
