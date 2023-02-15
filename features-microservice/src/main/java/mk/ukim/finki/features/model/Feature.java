package mk.ukim.finki.features.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// Features in our application represent a location,
// name and other information about places that offer services,
// such as gas stations, hotels, etc.
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public abstract class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double lat;
    private Double lon;
    private String name;

    private byte stars;
    private String city;
}
