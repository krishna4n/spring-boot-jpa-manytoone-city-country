package com.example.geohub.service;

import java.util.ArrayList;
import java.util.List;

import com.example.geohub.model.Country;
import com.example.geohub.repository.CountryJpaRepository;
import com.example.geohub.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CountryJpaService implements CountryRepository {

    @Autowired
    private CountryJpaRepository countryJpaRepository;

    @Override
    public ArrayList<Country> getAllCountries() {
        try {
            List<Country> country = countryJpaRepository.findAll();
            return (ArrayList<Country>) country;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Country addCountry(Country country) {
        try {
            countryJpaRepository.save(country);
            return country;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Country getCountryById(int countryId) {
        try {
            Country country = countryJpaRepository.findById(countryId).get();
            return country;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Country updateCountry(Country country, int countryId) {
        try {
            Country c = countryJpaRepository.findById(countryId).get();
            if (country.getCountryName() != null) {
                c.setCountryName(country.getCountryName());
            }
            if (country.getCurrency() != null) {
                c.setCurrency(country.getCurrency());
            }
            if (country.getPopulation() != 0) {
                c.setPopulation(country.getPopulation());
            }
            if (country.getLatitude() != null) {
                c.setLatitude(country.getLatitude());
            }
            if (country.getLongitude() != null) {
                c.setLongitude(country.getLongitude());
            }

            countryJpaRepository.save(c);
            return c;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteCountry(int countryId) {
        try {
            countryJpaRepository.deleteById(countryId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        throw new ResponseStatusException(HttpStatus.NO_CONTENT);

    }

}