package com.example.geohub.repository;

import com.example.geohub.model.Country;
import java.util.ArrayList;

public interface CountryRepository {
    ArrayList<Country> getAllCountries();

    Country addCountry(Country country);

    Country getCountryById(int countryId);

    Country updateCountry(Country country, int countryId);

    void deleteCountry(int countryId);
}