package mk.ukim.finki.routes.service.impl;

import mk.ukim.finki.routes.model.Point;
import mk.ukim.finki.routes.model.Route;
import mk.ukim.finki.routes.repository.RouteRepository;
import mk.ukim.finki.routes.service.RouteService;
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
