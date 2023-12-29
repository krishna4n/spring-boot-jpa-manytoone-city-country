package com.example.geohub.controller;

import com.example.geohub.service.CountryJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import com.example.geohub.model.*;

@RestController
public class CountryController {

    @Autowired
    private CountryJpaService countryJpaService;

    @GetMapping("/countries")
    public ArrayList<Country> getAllCountried() {
        return countryJpaService.getAllCountries();
    }

    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country country) {
        return countryJpaService.addCountry(country);
    }

    @GetMapping("/countries/{countryId}")
    public Country getCountyById(@PathVariable("countryId") int countryId) {
        return countryJpaService.getCountryById(countryId);
    }

    @PutMapping("/countries/{countryId}")
    public Country updateCountry(@RequestBody Country country, @PathVariable("countryId") int countryId) {
        return countryJpaService.updateCountry(country, countryId);
    }

    @DeleteMapping("/countries/{countryId}")
    public void deleteCountry(@PathVariable("countryId") int countryId) {
        countryJpaService.deleteCountry(countryId);
    }

}