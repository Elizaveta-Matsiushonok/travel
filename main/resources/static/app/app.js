var myApp = angular.module('myApp', ['ngRoute',"ngStorage"]);

myApp.config(function ($routeProvider, $locationProvider) {
    $locationProvider.hashPrefix('');
    $routeProvider

        .when('/', {
            templateUrl: 'pages/home.html',
            controller: 'mainController'
        })
        .when('/singin', {
            templateUrl: 'pages/singin.html',
            controller: 'mainController'
        })
        .when('/singup', {
            templateUrl: 'pages/singup.html',
            controller: 'mainController'
        })
        .when('/country/:id', {
            templateUrl: 'pages/country-info.html',
            controller: 'countryController'
        })
        .when('/countries', {
            templateUrl: 'pages/countries.html',
            controller: 'countryController'
        })
        .when('/add-country', {
            templateUrl: 'pages/add-country.html',
            controller: 'countryController'
        })
        .when('/update-country/:id', {
            templateUrl: 'pages/update-country.html',
            controller: 'countryController'
        });
});

myApp.controller('countryController', function ($scope, $http, $routeParams, $location) {
    $scope.countries = {};
    $scope.country = {};
    $scope.countryId = 0;

    $scope.title = '';
    $scope.language = '';
    $scope.population = 0;
    $scope.religion = '';
    $scope.climate = '';
    $scope.economy = '';
    $scope.culture = '';
    $scope.cuisine = '';
    $scope.area = 0;
    $scope.countryId = 0;
    $scope.image = '';

    $scope.getCountries = function () {
        $http({
            method: "GET",
            url: "/countries"
        }).then(function mySuccess(response) {
            $scope.countries = response.data;
        });
        console.log($scope.countries);
    }

    $scope.getCountry = function () {

        $http({
            method: "GET",
            url: '/country/' + $routeParams.id
        }).then(function mySuccess(response) {
            $scope.country = response.data;
        });
    }


    $scope.getCountryForUpdate = function () {

        $http({
            method: "GET",
            url: '/country/' + $routeParams.id
        }).then(function mySuccess(response) {
            $scope.countryId = response.data.id;
            $scope.title = response.data.title;
            $scope.language = response.data.language;
            $scope.population = response.data.population;
            $scope.religion = response.data.religion;
            $scope.climate = response.data.climate;
            $scope.economy = response.data.economy;
            $scope.culture = response.data.culture;
            $scope.cuisine = response.data.cuisine;
            $scope.area = response.data.area;
            $scope.image = response.data.image;
        });
    }

    $scope.delete = function (id) {

        $http({
            method: "GET",
            url: '/delete/' + id
        }).then(function mySuccess(response) {
            $location.path("/countries");
        });
    }

    $scope.add = function () {
        console.log($scope.title)
        $http({
            url: '/addCountry',
            method: "POST",
            data: {'title': $scope.title,
            'language' : $scope.language,
            'population': $scope.population,
                'religion' :  $scope.religion,
                'climate' : $scope.climate,
                'economy' : $scope.economy,
                'culture' :   $scope.culture,
                'cuisine' : $scope.cuisine,
                'area' : $scope.area,
                'image' : $scope.image
            }
        })
            .then(function (response) {
                    if(response.data.title !== null){
                        $scope.noCountry = false;
                        $scope.country = response.data;
                        $location.path("/country/" + $scope.country.id);
                    }else{
                        $scope.noCountry = true;
                    }
                },
                function (response) {
                    $scope.noCountry = true;
                });
    };

    $scope.update = function () {
        console.log("update " + $scope.countryId);
        $http({
            url: '/updateCountry',
            method: "POST",
            data: {'id' : $scope.countryId,
                'title': $scope.title,
                'language' : $scope.language,
                'population': $scope.population,
                'religion' :  $scope.religion,
                'climate' : $scope.climate,
                'economy' : $scope.economy,
                'culture' :   $scope.culture,
                'cuisine' : $scope.cuisine,
                'area' : $scope.area,
                'image' : $scope.image
            }
        })
            .then(function (response) {
                    if(response.data.title !== null){
                        $scope.country = response.data;
                        $location.path("/country/" + $scope.country.id);
                    }else{
                    }
                },
                function (response) {
                });
    };
});
myApp.controller('mainController', function ($scope, $http, $location,$localStorage) {
    $scope.isUser = false;
    $scope.user = {};

    $scope.login = '';
    $scope.password = '';


    $scope.getLastCountries = function () {
            $http({
                method: "GET",
                url: "/lastcountries"
            }).then(function mySuccess(response) {
                $scope.countries = response.data;
            });
            console.log($scope.countries);

    }
    $scope.singin = function () {
        $http({
            url: '/login',
            method: "POST",
            data: {'login': $scope.login, 'password' : $scope.password}
        })
            .then(function (response) {
                    if(response.data.login !== null){
                        $scope.noUser = false;
                        $scope.user = response.data;
                        $localStorage.user = response.data;
                        $location.path("/" );

                    }else{
                        $scope.noUser = true;
                    }
                },
                function (response) {
                    $scope.noUser = true;
                });
    };

    $scope.singup = function () {
        $http({
            url: '/singup',
            method: "POST",
            data: {'login': $scope.login, 'password' : $scope.password}
        })
            .then(function (response) {
                    if(response.data.login !== null){
                        console.log(response.data.login)
                        $scope.noUser = false;
                        $scope.user = response.data;
                        $localStorage.user = response.data;
                        $location.path("/" );
                    }else{
                        $scope.noUser = true;
                    }
                },
                function (response) {
                    $scope.noUser = true;
                });
    };
    $scope.isAuthorized = function () {
        if($localStorage.user != undefined || $localStorage.user != null){
            return true;
        }
        else{
            return false;
        }
    };

    $scope.isAdmin = function () {
        if($localStorage.user != undefined || $localStorage.user != null){
            if($localStorage.user.role == 1){
                return true;
            }
            return false;
        }
        else{
            return false;
        }
    };

    $scope.singOut = function () {

        $localStorage.user = null;
    }

});
