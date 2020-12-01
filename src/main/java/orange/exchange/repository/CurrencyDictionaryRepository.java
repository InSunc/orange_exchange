package orange.exchange.repository;

import orange.exchange.model.entity.CurrencyDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyDictionaryRepository extends JpaRepository<CurrencyDictionary, Long> {
    Optional<CurrencyDictionary> findByCode(String code);
}
