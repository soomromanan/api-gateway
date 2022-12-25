package com.FAJIG.microservice.currencyexchangeservice.service;

import com.FAJIG.microservice.currencyexchangeservice.bean.CurrencyExchange;
import com.FAJIG.microservice.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;
    public CurrencyExchange retreiveExchangeValue(String from, String to) {

        return currencyExchangeRepository.findByFromAndTo(from,to);
    }

}