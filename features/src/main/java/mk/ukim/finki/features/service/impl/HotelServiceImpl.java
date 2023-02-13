package mk.ukim.finki.features.service.impl;

import mk.ukim.finki.features.bootstrap.DataHolder;
import mk.ukim.finki.features.model.Hotel;
import mk.ukim.finki.features.repository.HotelRepository;
import mk.ukim.finki.features.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    final private HotelRepository repository;

    public HotelServiceImpl(HotelRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Hotel> findAll() {
        if (repository.count() == 0) {
            repository.saveAll(DataHolder.hotels);
        }
        return repository.findAll();
    }
}
