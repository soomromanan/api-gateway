package com.FAJIG.microservices.limitsservicedemo.controller;

import com.FAJIG.microservices.limitsservicedemo.bean.Limits;
import com.FAJIG.microservices.limitsservicedemo.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    Configuration configuration;
    @GetMapping("/limits")
    public Limits getLimits(){
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }
}
