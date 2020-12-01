package orange.exchange.mapper;

import lombok.RequiredArgsConstructor;
import orange.exchange.model.dto.ExchangeDTO;
import orange.exchange.model.dto.ExchangeResultDTO;
import orange.exchange.model.entity.CurrencyDictionary;
import orange.exchange.model.entity.Exchange;
import orange.exchange.service.CurrencyDictionaryService;
import orange.exchange.service.ExchangeService;
import orange.exchange.service.RateService;
import orange.exchange.service.UserService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class ExchangeMapper {
    private final ExchangeService exchangeService;
    private final UserService userService;
    private final CurrencyDictionaryService currencyDictionaryService;
    private final RateService rateService;

    public Exchange fromDTO(ExchangeDTO exchangeDTO) {
        Exchange exchange = new Exchange();

        CurrencyDictionary fromCurrency = currencyDictionaryService.getByCode(exchangeDTO.getCurrencyFrom());
        CurrencyDictionary toCurrency = currencyDictionaryService.getByCode(exchangeDTO.getCurrencyTo());
        exchange.setCurrencyFrom(fromCurrency);
        exchange.setCurrencyTo(toCurrency);
        exchange.setDate(LocalDate.now());
        exchange.setUser(userService.getByUsername(exchangeDTO.getUsername()));

        return exchange;
    }

    public ExchangeResultDTO fromEntity(Exchange exchange) {
        ExchangeResultDTO exchangeResultDTO = new ExchangeResultDTO();

        exchangeResultDTO.setCurrencyFrom(exchange.getCurrencyFrom().getCode());
        exchangeResultDTO.setCurrencyTo(exchange.getCurrencyTo().getCode());
        exchangeResultDTO.setDate(exchange.getDate());
        exchangeResultDTO.setUsername(exchange.getUser().getUsername());

        float buyFor = rateService.getCurrent(exchangeResultDTO.getCurrencyTo()).getBuyFor();

        exchangeResultDTO.setExchangedResult(buyFor * exchangeResultDTO.getAmount());

        return exchangeResultDTO;
    }
}
