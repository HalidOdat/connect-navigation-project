package mk.ukim.finki.features.service;

import mk.ukim.finki.features.model.GasStation;
import mk.ukim.finki.features.model.SuperMarket;

import java.util.List;

public interface GasStationService {
    List<GasStation> findAll();

    void save(GasStation gasStation);
}
