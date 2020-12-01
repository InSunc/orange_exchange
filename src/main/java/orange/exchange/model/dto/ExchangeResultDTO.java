package orange.exchange.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ExchangeResultDTO extends ExchangeDTO{
    float exchangedResult;
    LocalDate date;
}
