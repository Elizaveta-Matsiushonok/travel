var scotchApp = angular.module('scotchApp', ['ngRoute']);

scotchApp.config(function($routeProvider, $locationProvider) {
    $locationProvider.hashPrefix('');
    $routeProvider

        .when('/', {
            templateUrl : 'pages/home.html',
            controller  : 'mainController'
        })
        .when('/singin', {
            templateUrl : 'pages/singin.html',
            controller  : 'singController'
        })
        .when('/singup', {
            templateUrl : 'pages/singup.html',
            controller  : 'singController'
        })
        .when('/countries', {
            templateUrl : 'pages/countries.html',
            controller  : 'contentController'
        });
});

scotchApp.controller('mainController', function($scope) {
});

scotchApp.controller('singController', function($scope) {
});

scotchApp.controller('contentController', function($scope) {
});