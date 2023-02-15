package mk.ukim.finki.routes.repository;

import com.graphhopper.GHRequest;
import com.graphhopper.GraphHopper;

import com.graphhopper.GHResponse;
import com.graphhopper.ResponsePath;
import com.graphhopper.util.*;
import com.graphhopper.util.shapes.GHPoint;

import mk.ukim.finki.routes.bootstrap.GraphHopperHolder;
import mk.ukim.finki.routes.model.Point;
import mk.ukim.finki.routes.model.Route;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Locale;
import java.util.List;

@Repository
public class RouteRepository {
    public Route getRoute(Point from, Point to) {
        GraphHopper hopper = GraphHopperHolder.instance;

        // simple configuration of the request object
        GHRequest req = new GHRequest(from.getLat(), from.getLon(), to.getLat(), to.getLon())
            // note that we have to specify which profile we are using even when there is only one like here
            .setProfile("car")
            // define the language for the turn instructions
            .setLocale(Locale.US);

        GHResponse rsp = hopper.route(req);

        // handle errors
        if (rsp.hasErrors())
            throw new RuntimeException(rsp.getErrors().toString());

        // Use the best path, see the GHResponse class for more possibilities.
        ResponsePath path = rsp.getBest();

        PointList pointList = path.getPoints();
        double distance = path.getDistance();

        List<Point> points = new ArrayList<>();
        for (GHPoint point : pointList) {
            points.add(new Point(point.getLat(), point.getLon()));
        }
        return new Route(from, to, points, distance);
    }
}
