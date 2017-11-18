package com.stp.repository;

import com.stp.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends CrudRepository<Country, Integer>{

    Country findCountryByTitle(String title);

}
