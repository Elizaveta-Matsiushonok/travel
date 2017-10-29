var myApp = angular.module('myApp', ['ngRoute']);

myApp.config(function($routeProvider, $locationProvider) {
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

myApp.controller('mainController', function($scope) {
});
myApp.controller('singController', function($scope) {
})
.myApp.controller('contentController', function($scope) {
});
