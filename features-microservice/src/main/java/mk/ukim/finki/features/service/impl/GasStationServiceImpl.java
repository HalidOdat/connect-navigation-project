package mk.ukim.finki.features.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.features.bootstrap.DataHolder;
import mk.ukim.finki.features.model.GasStation;
import mk.ukim.finki.features.repository.GasStationRepository;
import mk.ukim.finki.features.service.GasStationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GasStationServiceImpl implements GasStationService {
    final private GasStationRepository repository;

    @Override
    public List<GasStation> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(GasStation gasStation) {
        this.repository.saveAndFlush(gasStation);
    }
}
