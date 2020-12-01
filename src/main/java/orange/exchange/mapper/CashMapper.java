package orange.exchange.mapper;

import lombok.RequiredArgsConstructor;
import orange.exchange.model.dto.CashDTO;
import orange.exchange.model.entity.Cash;
import orange.exchange.repository.CashRepository;
import orange.exchange.service.CashService;
import orange.exchange.service.CurrencyDictionaryService;
import orange.exchange.service.UserService;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class CashMapper {
    private final CashService cashService;
    private final UserService userService;
    private final CurrencyDictionaryService currencyDictionaryService;


    public Cash fromDTO(CashDTO cashDTO) {
        Cash cash = new Cash();

        cash.setAmount(cashDTO.getAmount());
        cash.setCurrency(currencyDictionaryService.getByCode(cashDTO.getCurrencyCode()));
        cash.setDate(cashDTO.getDate());
        cash.setUser(userService.getByUsername(cashDTO.getUsername()));

        return cash;
    }

    public CashDTO fromEntity(Cash repoCash) {
        CashDTO cashDTO = new CashDTO();

        cashDTO.setAmount(repoCash.getAmount());
        cashDTO.setCurrencyCode(repoCash.getCurrency().getCode());
        cashDTO.setDate(repoCash.getDate());
        cashDTO.setUsername(repoCash.getUser().getUsername());

        return cashDTO;
    }
}
