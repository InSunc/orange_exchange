package orange.exchange.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class POST_RateDTO {
    String currencyCode;
    float sellFor;
    float buyFor;
    int rate;
}
