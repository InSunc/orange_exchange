package orange.exchange.service.impl;

import lombok.RequiredArgsConstructor;
import orange.exchange.exception.EntityNotFoundException;
import orange.exchange.model.entity.CurrencyDictionary;
import orange.exchange.model.entity.Rate;
import orange.exchange.repository.RateRepository;
import orange.exchange.service.CurrencyDictionaryService;
import orange.exchange.service.RateService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {
    private final RateRepository rateRepository;
    private final CurrencyDictionaryService currencyDictionaryService;

    @Override
    public Rate save(Rate rate) {
        Optional<Rate> repoRate = rateRepository.findByCurrencyCodeAndDate(rate.getCurrency().getCode(), LocalDate.now());

        repoRate.ifPresent(value -> rate.setId(value.getId()));
        rateRepository.save(rate);

        return rateRepository.save(rate);
    }

    @Override
    public List<Rate> getAll() {
        return rateRepository.findAll();
    }

    @Override
    public Rate getCurrent(String currencyCode) {
        return rateRepository.findByCurrencyCodeAndDate(currencyCode, LocalDate.now()).orElseThrow(() -> new EntityNotFoundException("Couldn't find entity"));
    }
}
