package orange.exchange.model.dto;

import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Setter
@Getter
public class GET_RateDTO extends POST_RateDTO{
    LocalDate date;
}
