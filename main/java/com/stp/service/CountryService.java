package com.stp.service;

import com.stp.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountries();

    Country getCountryById(int id);

    Country addCountry(Country country);

    void deleteCountry(int id);

    void updateCountry(Country country);

}
