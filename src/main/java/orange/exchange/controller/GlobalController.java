package orange.exchange.controller;

import lombok.RequiredArgsConstructor;
import orange.exchange.mapper.CashMapper;
import orange.exchange.mapper.ExchangeMapper;
import orange.exchange.mapper.RateMapper;
import orange.exchange.model.dto.*;
import orange.exchange.model.entity.Cash;
import orange.exchange.model.entity.Exchange;
import orange.exchange.model.entity.Rate;
import orange.exchange.service.CashService;
import orange.exchange.service.ExchangeService;
import orange.exchange.service.RateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GlobalController {
    private final RateMapper rateMapper;
    private final CashMapper cashMapper;
    private final RateService rateService;
    private final CashService cashService;
    private final ExchangeService exchangeService;
    private final ExchangeMapper exchangeMapper;



    @PostMapping("/rates")
    public ResponseEntity<POST_RateDTO> addRate(@RequestBody POST_RateDTO rateDTO) {
        Rate rate = rateMapper.fromDTO(rateDTO);

        rateService.save(rate);

        POST_RateDTO dbRate = rateMapper.fromEntity(rate);
        return ResponseEntity.ok(dbRate);
    }

    @GetMapping("/rates/{currencyCode}")
    public ResponseEntity<GET_RateDTO> getRate(@PathVariable String currencyCode) {
        Rate rate = rateService.getCurrent(currencyCode.toUpperCase());

        GET_RateDTO rateDTO = rateMapper.fromEntityToGetDTO(rate);

        return ResponseEntity.ok(rateDTO);
    }

    @PutMapping("/cash")
    public ResponseEntity<CashDTO> updateCash(@RequestBody CashDTO cashDTO) {
        Cash cash = cashMapper.fromDTO(cashDTO);
        Cash repoCash = cashService.save(cash);

        return ResponseEntity.ok(cashMapper.fromEntity(repoCash));
    }

    @PostMapping("/exchange")
    public ResponseEntity<ExchangeDTO> exchange(@RequestBody ExchangeDTO exchangeDTO) {
        Exchange exchange = exchangeMapper.fromDTO(exchangeDTO);


        return ResponseEntity.ok(exchangeMapper.fromEntity(exchangeService.save(exchange)));
    }
}
