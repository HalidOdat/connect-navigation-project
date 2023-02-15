package mk.ukim.finki.features.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.features.model.Hotel;
import mk.ukim.finki.features.bootstrap.DataHolder;
import mk.ukim.finki.features.repository.HotelRepository;
import mk.ukim.finki.features.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    final private HotelRepository repository;

    @Override
    public List<Hotel> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Hotel hotel) {
        this.repository.saveAndFlush(hotel);
    }
}
