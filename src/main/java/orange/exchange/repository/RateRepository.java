package orange.exchange.repository;

import orange.exchange.model.entity.CurrencyDictionary;
import orange.exchange.model.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
    Optional<Rate> findByCurrencyCodeAndDate(String code, LocalDate date);
}
