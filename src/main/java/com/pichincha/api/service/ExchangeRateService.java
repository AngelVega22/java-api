package com.pichincha.api.service;

import com.pichincha.api.model.ExchangeRate;

public interface ExchangeRateService {
    ExchangeRate createExchangeRate(ExchangeRate exchangeRate);
    ExchangeRate updateExchangeRate(Long id, ExchangeRate exchangeRate);
    ExchangeRate getExchangeRate(String sourceCurrency, String targetCurrency);
}