package mk.ukim.finki.features.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.features.model.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<CoffeeShop> coffeeShops = new ArrayList<>();
    public static List<GasStation> gasStations = new ArrayList<>();
    public static List<Hotel> hotels = new ArrayList<>();
    public static List<Restaurant> restaurants = new ArrayList<>();
    public static List<SuperMarket> superMarkets = new ArrayList<>();

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
            coffeeShops.add(
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
            gasStations.add(
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
            hotels.add(
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
            restaurants.add(
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
            superMarkets.add(
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
