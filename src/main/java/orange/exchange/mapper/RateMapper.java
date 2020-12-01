package orange.exchange.mapper;

import lombok.RequiredArgsConstructor;
import orange.exchange.model.dto.GET_RateDTO;
import orange.exchange.model.dto.POST_RateDTO;
import orange.exchange.model.entity.Rate;
import orange.exchange.service.CurrencyDictionaryService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class RateMapper {
    private final CurrencyDictionaryService currencyDictionaryService;

    public Rate fromDTO(POST_RateDTO rateDTO) {
        Rate rate = new Rate();

        rate.setCurrency(currencyDictionaryService.getByCode(rateDTO.getCurrencyCode()));
        rate.setDate(LocalDate.now());
        rate.setBuyFor(rateDTO.getBuyFor());
        rate.setSellFor(rateDTO.getSellFor());

        return rate;
    }

    public POST_RateDTO fromEntity(Rate rate) {
        POST_RateDTO rateDTO = new POST_RateDTO();

        rateDTO.setBuyFor(rate.getBuyFor());
        rateDTO.setSellFor(rate.getSellFor());
        rateDTO.setCurrencyCode(rate.getCurrency().getCode());

        return rateDTO;
    }

    public GET_RateDTO fromEntityToGetDTO(Rate rate) {
        GET_RateDTO rateDTO = new GET_RateDTO();

        rateDTO.setBuyFor(rate.getBuyFor());
        rateDTO.setSellFor(rate.getSellFor());
        rateDTO.setCurrencyCode(rate.getCurrency().getCode());
        rateDTO.setDate(rate.getDate());

        return rateDTO;
    }

}
