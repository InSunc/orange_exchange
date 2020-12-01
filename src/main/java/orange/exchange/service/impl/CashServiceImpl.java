package orange.exchange.service.impl;

import lombok.RequiredArgsConstructor;
import orange.exchange.exception.EntityNotFoundException;
import orange.exchange.model.entity.Cash;
import orange.exchange.repository.CashRepository;
import orange.exchange.service.CashService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CashServiceImpl implements CashService {
    private final CashRepository cashRepository;

    @Override
    public Cash save(Cash cash) {
        Optional<Cash> repoCash = cashRepository.findByCurrencyCodeAndUserUsernameAndDate(
                cash.getCurrency().getCode(),
                cash.getUser().getUsername(),
                cash.getDate()
        );

        if (repoCash.isPresent()) {
            cash.setId(repoCash.get().getId());
            return cashRepository.save(cash);
        } else {
            throw new EntityNotFoundException("Couldn't find cash for the given input parameters");
        }
    }
}
