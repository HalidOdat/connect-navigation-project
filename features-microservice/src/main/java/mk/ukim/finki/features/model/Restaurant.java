package mk.ukim.finki.features.model;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Restaurant extends Feature {
    @Builder
    public Restaurant(Long id, Double lat, Double lon, String name, byte stars, String city, String street) {
        super(id, lat, lon, name, stars, city, street);
    }
}
