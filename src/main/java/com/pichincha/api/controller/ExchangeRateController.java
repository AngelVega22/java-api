package com.pichincha.api.controller;

import com.pichincha.api.model.ExchangeRate;
import com.pichincha.api.service.ExchangeRateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exchange-rates")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @PostMapping
    public ResponseEntity<ExchangeRate> createExchangeRate(@RequestBody ExchangeRate exchangeRate) {
        ExchangeRate createdExchangeRate = exchangeRateService.createExchangeRate(exchangeRate);
        return new ResponseEntity<>(createdExchangeRate, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExchangeRate> updateExchangeRate(@PathVariable Long id, @RequestBody ExchangeRate exchangeRate) {
        ExchangeRate updatedExchangeRate = exchangeRateService.updateExchangeRate(id, exchangeRate);
        return new ResponseEntity<>(updatedExchangeRate, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ExchangeRate> getExchangeRate(
            @RequestParam String sourceCurrency,
            @RequestParam String targetCurrency) {
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(sourceCurrency, targetCurrency);
        return new ResponseEntity<>(exchangeRate, HttpStatus.OK);
    }

    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("La aplicación está en funcionamiento");
    }
}