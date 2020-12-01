package orange.exchange.service;

import orange.exchange.model.entity.CurrencyDictionary;

public interface CurrencyDictionaryService {
    CurrencyDictionary getByCode(String code);
}
