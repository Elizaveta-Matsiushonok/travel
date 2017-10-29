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
}
