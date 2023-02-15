package mk.ukim.finki.features.service;

import mk.ukim.finki.features.model.SuperMarket;

import java.util.List;

public interface SuperMarketService {
    List<SuperMarket> findAll();

    void save(SuperMarket superMarket);
}
