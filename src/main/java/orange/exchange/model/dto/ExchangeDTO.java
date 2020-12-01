package orange.exchange.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExchangeDTO {
    String currencyTo;
    String currencyFrom;
    float amount;
    float buysFor;
    String username;
}
