package com.stp.controller;

import com.stp.model.Country;
import com.stp.model.User;
import com.stp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getAllCountries(){
        return  countryService.getAllCountries();
    }

    @GetMapping("/country/{id}")
    public Country getCountryById(@PathVariable int id){
        System.out.println("kihk" + id);
        return countryService.getCountryById(id);
    }
    @PostMapping("/addCountry")
    public Country addCountry(@RequestBody Country country){
        System.out.println(country);
        return countryService.addCountry(country);
    }
    @GetMapping("/delete/{id}")
    public void deleteCountry(@PathVariable int id){
        System.out.println("kihk" + id);
        countryService.deleteCountry(id);
    }

    @PostMapping("/updateCountry")
    public Country updateCountry(@RequestBody Country country){
        System.out.println(country);
        return countryService.updateCountry(country);
    }

    @GetMapping("/lastcountries")
    public List<Country> getLastCountries(){
        return  countryService.getAllCountries().subList(0, 3);
    }

}
