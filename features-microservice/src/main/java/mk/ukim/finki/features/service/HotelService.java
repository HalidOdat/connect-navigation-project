package mk.ukim.finki.features.service;

import mk.ukim.finki.features.model.Hotel;
import mk.ukim.finki.features.model.SuperMarket;

import java.util.List;

public interface HotelService {
    List<Hotel> findAll();

    void save(Hotel hotel);
}
