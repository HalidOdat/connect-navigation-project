package mk.ukim.finki.features.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.features.model.*;
import mk.ukim.finki.features.service.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DataHolder {
    private final CoffeeShopService coffeeShopService;
    private final GasStationService gasStationService;
    private final HotelService hotelService;
    private final RestaurantService restaurantService;
    private final SuperMarketService superMarketService;

    @PostConstruct
    void init() throws IOException {
        SplitByFilter splitByNewlineFilter = new SplitByFilter("\n");
        SkipFilter skipFirstLineFilter = new SkipFilter(1);
        RemoveUnnamedFilter removeUnnamedFilter = new RemoveUnnamedFilter();

        Pipe<String, List<String[]>> pipe = new Pipe<>();
        pipe.add(splitByNewlineFilter);
        pipe.add(skipFirstLineFilter);
        pipe.add(removeUnnamedFilter);

        String fileString = Files.readString(Path.of("bootstrap/coffee_shops.csv"), Charset.defaultCharset());
        List<String[]> values = pipe.run(fileString);
        for (String[] value : values) {
            coffeeShopService.save(
                CoffeeShop.builder()
                    .id(Long.parseLong(value[0]))
                    .lat(Double.parseDouble(value[1]))
                    .lon(Double.parseDouble(value[2]))
                    .name(value[3])
                    .stars(Byte.parseByte(value[4].trim()))
                    .city(value[5])
                    .street(value.length > 6 ? value[6] : "")
                    .build()
            );
        }

        fileString = Files.readString(Path.of("bootstrap/gas_stations.csv"), Charset.defaultCharset());
        values = pipe.run(fileString);
        for (String[] value : values) {
            gasStationService.save(
                GasStation.builder()
                    .id(Long.parseLong(value[0]))
                    .lat(Double.parseDouble(value[1]))
                    .lon(Double.parseDouble(value[2]))
                    .name(value[3])
                    .stars(Byte.parseByte(value[4].trim()))
                    .city(value[5])
                    .street(value.length > 6 ? value[6] : "")
                    .build()
            );
        }

        fileString = Files.readString(Path.of("bootstrap/hotels.csv"), Charset.defaultCharset());
        values = pipe.run(fileString);
        for (String[] value : values) {
            hotelService.save(
                Hotel.builder()
                    .id(Long.parseLong(value[0]))
                    .lat(Double.parseDouble(value[1]))
                    .lon(Double.parseDouble(value[2]))
                    .name(value[3])
                    .stars(Byte.parseByte(value[4].trim()))
                    .city(value[5])
                    .street(value.length > 6 ? value[6] : "")
                    .build()
            );
        }

        fileString = Files.readString(Path.of("bootstrap/restaurants.csv"), Charset.defaultCharset());
        values = pipe.run(fileString);
        for (String[] value : values) {
            restaurantService.save(
                Restaurant.builder()
                    .id(Long.parseLong(value[0]))
                    .lat(Double.parseDouble(value[1]))
                    .lon(Double.parseDouble(value[2]))
                    .name(value[3])
                    .stars(Byte.parseByte(value[4].trim()))
                    .city(value[5])
                    .street(value.length > 6 ? value[6] : "")
                    .build()
            );
        }

        fileString = Files.readString(Path.of("bootstrap/supermarkets.csv"), Charset.defaultCharset());
        values = pipe.run(fileString);
        for (String[] value : values) {
            superMarketService.save(
                SuperMarket.builder()
                    .id(Long.parseLong(value[0]))
                    .lat(Double.parseDouble(value[1]))
                    .lon(Double.parseDouble(value[2]))
                    .name(value[3])
                    .stars(Byte.parseByte(value[4].trim()))
                    .city(value[5])
                    .street(value.length > 6 ? value[6] : "")
                    .build()
            );
        }
    }
}
