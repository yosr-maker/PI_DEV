'use strict';
var myApp= angular.module('myApp');

function ThankYouController($scope, Gift, CallbackData) {
    /**
     * We just display the gift they gave along with success data from the server
     * including confirmation number, tax-deductible gift amount, and other info.
     *
     * @class ThankYouController
     */

    $scope.gift = Gift.getGift();
    $scope.callbackData = CallbackData.getResponse();
}
