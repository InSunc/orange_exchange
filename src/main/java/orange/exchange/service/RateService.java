package orange.exchange.service;

import orange.exchange.model.entity.Exchange;
import orange.exchange.model.entity.Rate;

import java.util.List;

public interface RateService {
    Rate save(Rate rate);
    List<Rate> getAll();
    Rate getCurrent(String currencyCode);
}
