package mk.ukim.finki.routes.web.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.routes.model.Point;
import mk.ukim.finki.routes.model.Route;
import mk.ukim.finki.routes.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v2/route")
@Validated
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class RouteRestController {

    private final RouteService service;

    @GetMapping(value = "/{from-lat}/{from-lon}/{to-lat}/{to-lon}")
    public ResponseEntity<Route> getAll(
            @PathVariable("from-lat") double fromLat,
            @PathVariable("from-lon") double fromLon,
            @PathVariable("to-lat") double toLat,
            @PathVariable("to-lon") double toLon
    ) {
        Point from = new Point(fromLat, fromLon);
        Point to = new  Point(toLat, toLon);

        try {
            Route route = service.getRoute(from, to);
            return new ResponseEntity<>(route, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}