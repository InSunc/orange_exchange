package orange.exchange.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CashDTO {
    String username;
    String currencyCode;
    float amount;
    LocalDate date;
}
