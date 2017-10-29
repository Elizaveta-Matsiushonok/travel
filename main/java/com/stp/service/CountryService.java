package com.stp.service;

import com.stp.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountries();

}
