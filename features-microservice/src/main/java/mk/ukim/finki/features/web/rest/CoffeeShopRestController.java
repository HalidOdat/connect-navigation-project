package mk.ukim.finki.features.web.rest;

import mk.ukim.finki.features.model.CoffeeShop;
import mk.ukim.finki.features.service.CoffeeShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/coffee-shops")
@Validated
@CrossOrigin(origins = "*")
public class CoffeeShopRestController {
    private final CoffeeShopService coffeeShopService;

    public CoffeeShopRestController(CoffeeShopService coffeeShopService) {
        this.coffeeShopService = coffeeShopService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<CoffeeShop>> getAll() {
        List<CoffeeShop> list = coffeeShopService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
