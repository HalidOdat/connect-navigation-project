package mk.ukim.finki.features.model;


import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Hotel extends Feature {
    @Builder
    public Hotel(Long id, Double lat, Double lon, String name, byte stars, String city, String street) {
        super(id, lat, lon, name, stars, city, street);
    }
}
