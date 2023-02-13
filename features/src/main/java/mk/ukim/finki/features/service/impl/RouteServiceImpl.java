package mk.ukim.finki.features.service.impl;

import mk.ukim.finki.features.model.Point;
import mk.ukim.finki.features.model.Route;
import mk.ukim.finki.features.repository.RouteRepository;
import mk.ukim.finki.features.service.RouteService;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService  {

    final private RouteRepository repository;

    public RouteServiceImpl(RouteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Route getRoute(Point from, Point to) {
        return repository.getRoute(from, to);
    }
}
