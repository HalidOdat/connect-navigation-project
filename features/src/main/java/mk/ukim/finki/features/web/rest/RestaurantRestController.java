package mk.ukim.finki.features.web.rest;

import mk.ukim.finki.features.model.Restaurant;
import mk.ukim.finki.features.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/restaurants")
@Validated
@CrossOrigin(origins = "*")
public class RestaurantRestController {
    private final RestaurantService service;

    public RestaurantRestController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Restaurant>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}