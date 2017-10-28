package com.stp.controller;

import com.stp.model.Country;
import com.stp.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by User on 26.10.2017.
 */
@Controller
public class UserController {

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping("/")
    public String index(){
        return "index.html";
    }
}
