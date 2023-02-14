package mk.ukim.finki.features.web.rest;

import mk.ukim.finki.features.model.Hotel;
import mk.ukim.finki.features.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v2/features/hotels")
@Validated
@CrossOrigin(origins = "*")
public class HotelRestController {
    private final HotelService service;

    public HotelRestController(HotelService service) {
        this.service = service;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Hotel>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}