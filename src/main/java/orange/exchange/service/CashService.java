package orange.exchange.service;

import orange.exchange.model.entity.Cash;
import org.springframework.stereotype.Service;

public interface CashService {
    Cash save(Cash cash);
}
