package com.rental.controller;

import com.rental.model.Car;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RentalController {

    @Value("${customer.service.url}")
    private String customerServiceUrl;


    Logger logger = org.slf4j.LoggerFactory.getLogger(RentalController.class);


    @GetMapping("/customer/{name}")
    public String bonjour(@PathVariable String name) {
        RestTemplate restTemplate = new RestTemplate();
        String url = customerServiceUrl + "/customers/" + name + "/address";
        logger.info("Requesting URL: " + url);
        String response = restTemplate.getForObject(url, String.class);
        return "Bonjour " + name + " " + "! Votre adresse est " +response;
    }
}