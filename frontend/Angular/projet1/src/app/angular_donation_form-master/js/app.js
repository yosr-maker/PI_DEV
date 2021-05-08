'use strict';
angular.module('myApp', ['myApp.directives', 'ngRoute', 'lodash']).
    config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/', {
            controller:FormGiftController,
            templateUrl:'/step1.html'
        }).when('/step1', {
            controller:FormGiftController,
            templateUrl:'/step1.html'
        }).when('/step2', {
            controller:FormBillingController,
            templateUrl:'/step2.html'
        }).when('/thankyou', {
            controller:ThankYouController,
            templateUrl:'/thankyou.html'
        }).otherwise({redirectTo:'/'});
}]);

// todo: find a better way of loading this
var lodash = angular.module('lodash', []);
lodash.factory('_', function() {
    return window._; // assumes lodash has already been loaded on the page
});