package mk.ukim.finki.features.model;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CoffeeShop extends Feature {
    @Builder
    public CoffeeShop(Long id, Double lat, Double lon, String name, byte stars, String city) {
        super(id, lat, lon, name, stars, city);
    }

}
