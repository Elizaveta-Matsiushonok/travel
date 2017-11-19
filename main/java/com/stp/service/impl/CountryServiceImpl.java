package com.stp.service.impl;


import com.stp.model.Country;
import com.stp.repository.CountryRepository;
import com.stp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return (List<Country>) countryRepository.findAll();
    }

    public Country getCountryById(int id){
        return countryRepository.findOne(id);
    }

    @Override
    public Country addCountry(Country country) {

        Country foundedCountry  = countryRepository.findCountryByTitle(country.getTitle());
        if(foundedCountry != null){
            return new Country();
        }
        return countryRepository.save(country);
    }

    @Override
    public void deleteCountry(int id) {
        countryRepository.delete(id);
    }

    @Override
    public Country updateCountry(Country country) {
        Country foundedCountry = countryRepository.findOne(country.getId());
        foundedCountry.setArea(country.getArea());
        foundedCountry.setClimate(country.getClimate());
        foundedCountry.setCuisine(country.getCuisine());
        foundedCountry.setCulture(country.getCulture());
        foundedCountry.setEconomy(country.getEconomy());
        foundedCountry.setPopulation(country.getPopulation());
        foundedCountry.setLanguage(country.getLanguage());
        foundedCountry.setReligion(country.getReligion());
        foundedCountry.setImage(country.getImage());
        return countryRepository.save(foundedCountry);
    }
}
