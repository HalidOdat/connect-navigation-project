package mk.ukim.finki.features.service;

import mk.ukim.finki.features.model.Point;
import mk.ukim.finki.features.model.Route;

public interface RouteService {
    Route getRoute(Point from, Point to);
}
