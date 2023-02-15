package mk.ukim.finki.routes.bootstrap;

import com.graphhopper.GraphHopper;
import com.graphhopper.config.CHProfile;
import com.graphhopper.config.Profile;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class GraphHopperHolder {
    public static GraphHopper instance;

    @PostConstruct
    void init() {
        instance = new GraphHopper();
        instance.setOSMFile("bootstrap/macedonia-latest.osm.pbf");
        // specify where to store graphhopper files
        instance.setGraphHopperLocation("target/routing-graph-cache");

        // see docs/core/profiles.md to learn more about profiles
        instance.setProfiles(new Profile("car").setVehicle("car").setWeighting("fastest").setTurnCosts(false));

        // this enables speed mode for the profile we called car
        instance.getCHPreparationHandler().setCHProfiles(new CHProfile("car"));

        // now this can take minutes if it imports or a few seconds for loading of
        // course this is dependent on the area you import
        instance.importOrLoad();
    }
}
