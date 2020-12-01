package orange.exchange.service.impl;

import lombok.RequiredArgsConstructor;
import orange.exchange.exception.EntityNotFoundException;
import orange.exchange.model.entity.CurrencyDictionary;
import orange.exchange.repository.CurrencyDictionaryRepository;
import orange.exchange.service.CurrencyDictionaryService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyDictionaryServiceImpl implements CurrencyDictionaryService {
    private final CurrencyDictionaryRepository currencyDictionaryRepository;

    @Override
    public CurrencyDictionary getByCode(String code) {
        return currencyDictionaryRepository.findByCode(code).orElseThrow(() -> new EntityNotFoundException("Could not find entity with code:" + code));
    }
}
