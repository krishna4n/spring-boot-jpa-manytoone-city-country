package com.example.geohub.repository;

import java.util.ArrayList;
import com.example.geohub.model.*;

public interface CityRepository {
    ArrayList<City> getAllCities();

    City addCity(City city);

    City getCityById(int cityId);

    City updateCity(City city, int cityId);

    void deleteCity(int cityId);

    Country getCityCountry(int cityId);

}