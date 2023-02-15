package mk.ukim.finki.routes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Route {
    Point from;
    Point to;
    List<Point> points;

    double distance;
}
