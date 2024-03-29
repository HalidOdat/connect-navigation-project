package mk.ukim.finki.features.repository;

import mk.ukim.finki.features.model.SuperMarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperMarketRepository extends JpaRepository<SuperMarket, Long> {
}
