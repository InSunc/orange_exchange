package orange.exchange.service.impl;

import lombok.RequiredArgsConstructor;
import orange.exchange.model.entity.Exchange;
import orange.exchange.repository.ExchangeRepository;
import orange.exchange.service.CashService;
import orange.exchange.service.ExchangeService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {
    private final ExchangeRepository exchangeRepository;
    private final CashService cashService;

    @Override
    public Exchange save(Exchange exchange) {
        // TODO: implement business logic for exchange transaction (substract)

        return exchangeRepository.save(exchange);
    }
}
