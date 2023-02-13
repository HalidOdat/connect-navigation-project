package mk.ukim.finki.routes.service;

import mk.ukim.finki.routes.model.Point;
import mk.ukim.finki.routes.model.Route;

public interface RouteService {
    Route getRoute(Point from, Point to);
}
