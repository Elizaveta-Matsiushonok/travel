package com.stp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private int role;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<FoodAndDrink> articlesOfFoodAndDrink;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<CityPlace> articlesOfCityPlace;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "city", cascade = CascadeType.ALL)
    private Set<CityPlace> articlesOfHotel;


    public User(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", articlesOfFoodAndDrink=" + articlesOfFoodAndDrink +
                ", articlesOfCityPlace=" + articlesOfCityPlace +
                ", articlesOfHotel=" + articlesOfHotel +
                '}';
    }
}
