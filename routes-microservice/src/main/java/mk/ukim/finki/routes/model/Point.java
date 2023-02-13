package mk.ukim.finki.routes.model;

import lombok.Data;

@Data
public class Point {
    double lat;
    double lon;

    public Point(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
}
