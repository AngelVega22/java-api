package com.pichincha.api.service;

import com.pichincha.api.model.ExchangeRate;
import com.pichincha.api.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;

    @Autowired
    public ExchangeRateServiceImpl(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public ExchangeRate createExchangeRate(ExchangeRate exchangeRate) {
        return exchangeRateRepository.save(exchangeRate);
    }

    @Override
    public ExchangeRate updateExchangeRate(Long id, ExchangeRate exchangeRate) {
        Optional<ExchangeRate> existingExchangeRate = exchangeRateRepository.findById(id);

        if (existingExchangeRate.isPresent()) {
            exchangeRate.setId(id);
            return exchangeRateRepository.save(exchangeRate);
        } else {
             throw new RuntimeException("Tipo de cambio no encontrado con ID: " + id);
        }
    }

    @Override
    public ExchangeRate getExchangeRate(String sourceCurrency, String targetCurrency) {
        Optional<ExchangeRate> exchangeRate = exchangeRateRepository
                .findBySourceCurrencyAndTargetCurrency(sourceCurrency, targetCurrency);

        if (exchangeRate.isPresent()) {
            return exchangeRate.get();
        } else {
            throw new RuntimeException("Tipo de cambio no encontrado para las monedas: "
                    + sourceCurrency + " a " + targetCurrency);
        }
    }
}