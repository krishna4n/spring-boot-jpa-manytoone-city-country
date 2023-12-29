package com.example.geohub.service;

import java.util.ArrayList;
import java.util.List;

import com.example.geohub.model.City;
import com.example.geohub.model.Country;
import com.example.geohub.repository.CityJpaRepository;
import com.example.geohub.repository.CityRepository;
import com.example.geohub.repository.CountryJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CityJpaService implements CityRepository {

    @Autowired
    private CityJpaRepository cityJpaRepository;

    @Autowired
    private CountryJpaRepository countryJpaRepository;

    @Override
    public ArrayList<City> getAllCities() {
        try {
            List<City> city = cityJpaRepository.findAll();
            return (ArrayList<City>) city;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public City addCity(City city) {
        try {
            Country c = city.getCountry();
            int countryId = c.getCountryId();
            Country country = countryJpaRepository.findById(countryId).get();
            city.setCountry(country);
            cityJpaRepository.save(city);
            return city;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public City getCityById(int cityId) {
        try {

            City city = cityJpaRepository.findById(cityId).get();
            return city;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public City updateCity(City city, int cityId) {
        try {
            City c = cityJpaRepository.findById(cityId).get();

            if (city.getCityName() != null) {
                c.setCityName(city.getCityName());
            }
            if (city.getPopulation() != 0) {
                c.setPopulation(city.getPopulation());
            }
            if (city.getLatitude() != null) {
                c.setLatitude(city.getLatitude());
            }
            if (city.getLongitude() != null) {
                c.setLongitude(city.getLongitude());
            }

            cityJpaRepository.save(c);
            return c;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteCity(int cityId) {
        try {
            cityJpaRepository.deleteById(cityId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        throw new ResponseStatusException(HttpStatus.NO_CONTENT);

    }

    @Override
    public Country getCityCountry(int cityId) {
        try {
            City city = cityJpaRepository.findById(cityId).get();
            Country country = city.getCountry();
            int countryId = country.getCountryId();
            Country newCountry = countryJpaRepository.findById(countryId).get();
            return newCountry;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}