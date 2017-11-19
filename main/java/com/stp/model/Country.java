package com.stp.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by User on 26.10.2017.
 */
@Entity
public class Country {

    @Id
    @Column(name = "id_country")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @Column
    private String language;
    @Column
    private String climate;
    @Column
    private String economy;
    @Column
    private String religion;
    @Column
    private String image;
    @Column
    private String culture;
    @Column
    private int population;
    @Column
    private double area;
    @Column
    private String cuisine;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country", cascade = CascadeType.ALL)
    private Set<City> cities;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country", cascade = CascadeType.ALL)
    private Set<City> places;

    public Country(){

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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String client) {
        this.climate = client;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public String getEconomy() {
        return economy;
    }

    public void setEconomy(String economy) {
        this.economy = economy;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", climate='" + climate + '\'' +
                ", economy='" + economy + '\'' +
                ", religion='" + religion + '\'' +
                ", culture='" + culture + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", cuisine='" + cuisine + '\'' +
                ", cities=" + cities +
                ", places=" + places +
                '}';
    }
}
