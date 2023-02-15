package mk.ukim.finki.routes.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.routes.model.Point;
import mk.ukim.finki.routes.model.Route;
import mk.ukim.finki.routes.repository.RouteRepository;
import mk.ukim.finki.routes.service.RouteService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RouteServiceImpl implements RouteService  {

    final private RouteRepository repository;

    @Override
    public Route getRoute(Point from, Point to) {
        return repository.getRoute(from, to);
    }
}
