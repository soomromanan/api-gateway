package com.FAJIG.microservice.currencyexchangeservice.controller;

import com.FAJIG.microservice.currencyexchangeservice.bean.CurrencyExchange;
import com.FAJIG.microservice.currencyexchangeservice.service.CurrencyExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("currency-exchange")
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
    @Autowired
    private Environment environment;
    @Autowired
    CurrencyExchangeService currencyExchangeService;
    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from , @PathVariable String to){
        CurrencyExchange currencyExchange=currencyExchangeService.retreiveExchangeValue(from,to);

        logger.info("retrieveExchangeValue with params {} to {} ",from,to);
        if(currencyExchange == null){
            throw new RuntimeException("Unable to find data");
        }
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}
