package mk.ukim.finki.features.service.impl;

import mk.ukim.finki.features.bootstrap.DataHolder;
import mk.ukim.finki.features.model.GasStation;
import mk.ukim.finki.features.repository.GasStationRepository;
import mk.ukim.finki.features.service.GasStationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GasStationServiceImpl implements GasStationService {
    final private GasStationRepository repository;

    public GasStationServiceImpl(GasStationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GasStation> findAll() {
        if (repository.count() == 0) {
            repository.saveAll(DataHolder.gasStations);
        }
        return repository.findAll();
    }
}
