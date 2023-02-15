package mk.ukim.finki.features.model;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SuperMarket extends Feature {
    @Builder
    public SuperMarket(Long id, Double lat, Double lon, String name, byte stars, String city) {
        super(id, lat, lon, name, stars, city);
    }
}
