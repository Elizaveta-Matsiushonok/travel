package com.stp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class City {

    @Id
    @Column(name = "id_city")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_country", insertable = false, updatable = false)
    private Country country;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "city", cascade = CascadeType.ALL)
    private Set<FoodAndDrink> articlesOfFoodAndDrink;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "city", cascade = CascadeType.ALL)
    private Set<CityPlace> articlesOfCityPlace;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "city", cascade = CascadeType.ALL)
    private Set<CityPlace> articlesOfHotel;

    public City(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<FoodAndDrink> getArticlesOfFoodAndDrink() {
        return articlesOfFoodAndDrink;
    }

    public void setArticlesOfFoodAndDrink(Set<FoodAndDrink> articlesOfFoodAndDrink) {
        this.articlesOfFoodAndDrink = articlesOfFoodAndDrink;
    }

    public Set<CityPlace> getArticlesOfCityPlace() {
        return articlesOfCityPlace;
    }

    public void setArticlesOfCityPlace(Set<CityPlace> articlesOfCityPlace) {
        this.articlesOfCityPlace = articlesOfCityPlace;
    }

    public Set<CityPlace> getArticlesOfHotel() {
        return articlesOfHotel;
    }

    public void setArticlesOfHotel(Set<CityPlace> articlesOfHotel) {
        this.articlesOfHotel = articlesOfHotel;
    }
}
