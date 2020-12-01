package orange.exchange.repository;

import orange.exchange.model.entity.Cash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CashRepository extends JpaRepository<Cash, Long> {
    Optional<Cash> findByCurrencyCodeAndUserUsernameAndDate(String code, String username, LocalDate date);
}
