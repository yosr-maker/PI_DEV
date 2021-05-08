'use strict';
var myApp= angular.module('myApp');

function FormGiftController($scope, $window, Gift, Designations, GiftDesignations, FormDefaults) {
    /**
     * Form Gift Controller is for the first page of the form and the view "step1.html"
     * Here the user enters information about the gift including what program they would like the gift to support,
     * if the gift is recurring and over what period,
     * if this is an Honor or Memorial gift, who for and who to notify,
     * and if this is a payment for a pledge that was made earlier.
     *
     * @class FormGiftController
     */

    var debug = false;  // when true will output debug info to the console.

    (function() {
        /* Get the Designation types and include them in $scope
         This is an asynchronous call that will automatically populate in the view when the data is ready.
         */
        var promise = Designations.getDesignations();
        promise.then( function(payload) {
            $scope.designations = payload;
        })
    })();

    // now check to see if there are any gifts that the user has already entered if he is returning to this page
    $scope.myGift = Gift.getGift();

    // todo: fix this properly
    $scope.myGift.installmentFrequency = $scope.myGift.installmentFrequency || "monthly";
    $scope.myGift.tributeType = $scope.myGift.tributeType || "tribute";
    if(debug) console.log('* * * my gift:');
    if(debug) console.dir($scope.myGift);
    $scope.myDesignations = $scope.myGift.designations;

    $scope.newDesignation = {};
    $scope.newDesignation.customDesignation = false;
    $scope.newDesignation.giftAmount = 0;
    $scope.givingLevels = FormDefaults.get('GivingLevels');


    // ---------------------------------------------------------------------- Designation functions
    $scope.designationChosen = function () {
        /**
         * Each list of programs is associated with a deignation type and loaded from that.
         * clear the list of programs when a new designation type is used.
         *
         * @method designationChosen
         */
        $scope.newDesignation.chosenProgram = null;
    };

    // ---- Custom Designations
    $scope.cancelCustomDesignation = function() {
        /**
         * clear old data when the user decides to use a designation from the list.
         *
         * @method cancelCustomDesignation
         */
        $scope.newDesignation.customDesignation = false;
        $scope.newDesignation.chosenDesignation = null;
        $scope.newDesignation.chosenProgram = null;
    };

    $scope.addCustomDesignation = function() {
        /**
         * Called when you click the Custom Designation button on the form.
         * Simply watches the input fields and adds the data to the scope.
         *
         * @method addCustomDesignation
         */
        $scope.newDesignation.customDesignation = true;
        $scope.$watch('newDesignation.customDesignationName', function(newValue, oldValue) {
                if(debug) console.log('newDesignation watching customDesignatino name was: ' + oldValue + ", is now: " + newValue);
                $scope.newDesignation.chosenProgram = { name : newValue };
            }
        );
        $scope.newDesignation.chosenDesignation = { name : "custom" };
    };

    // ---- Add / Remove
    $scope.addAnotherDesignation = function() {
        /**
         * this is used to add a designation to the gift.
         *  First we see if the validation is invalid, if so return false and exit.
         *  If there is a valid new designation, then we trim the data, and add it, returning true.
         *
         * @method addAnotherDesignation
         */
        if(debug) console.log('$scope.addAnotherDesignation');
        if(validateNewDesignation()) {
            // remove children or the object will be HUGE!
            delete $scope.newDesignation.chosenDesignation.children;

            GiftDesignations.add($scope.newDesignation);
            $scope.myDesignations = GiftDesignations.getDesignations();

            // reset choices
            $scope.newDesignation = {};
            // reset the form to "Pristine" condition
            $scope.giftform.$setPristine();
            jQuery('input, select').removeClass('submitted');
            $('.show-on-submit').removeClass('submitted');
            $('.gift-amounts .btn').removeClass('active');

            return true;
        } else {
            return false;
        }
        // todo: un-select the amount checked
    };

    $scope.removeDesignation = function(index) {
        /**
         * Called from the list of designations in the form.
         * Simply removes that entry from the scope.
         *
         * @method removeDesignation
         */
        GiftDesignations.remove(index);
        $scope.myDesignations = GiftDesignations.getDesignations();
    };

    // ---- Designation Dollar Amounts
    $scope.changeGiftAmount = function(item, index) {
        /**
         * While there is a list of pre-set amounts on the form, the backend only 'reads' the amount
         * from the 'Other Amount' field, so we need to update that when a choice is made.
         *
         * @method changeGiftAmount
         */
        $scope.selected = item;
        if(item.amount === "other") {
            $scope.chooseOtherAmount = true;
            $scope.newDesignation.giftAmount = $scope.otherAmount;
        } else {
            $scope.chooseOtherAmount = false;
            $scope.newDesignation.giftAmount = item.amount;
        }
        $scope.selected = index;
    };

    // ------------------------------------------------------------------- Validate and Payment
    $scope.proceedToPayment = function() {
        /**
         * Validation is done with Angular on the html view.
         * If that validation is sucessful, we make sure the gift is stored and move the user to the payment page
         * otherwise, we display errors and keep them here.
         *
         * @method proceedToPayment
         */
        if(debug) console.log('proceedToPayment ' + $scope.giftform.$valid);
        if($scope.validateGift()) {
            if(debug) console.log('gift validated, adding to gift service');
            $scope.myGift.designations = $scope.myDesignations;
            Gift.make($scope.myGift);
            // and go to step 2:
            $window.location.href = "index.html#/step2";
        } else {
            if(debug) console.log('gift not validated');
            $scope.errors = true;
            jQuery('input, select').addClass('submitted');
            $('.show-on-submit').addClass('submitted');
        }
    };

    var validateNewDesignation = function() {
        /**
         * A short data validation method to make sure the designation is good.
         *
         * @method validateNewDesignation
         */
        if(debug) console.dir($scope.newDesignation);
        var validated = false;
        if($scope.newDesignation.customDesignation) {
            if(debug) console.log('validate custom Designation');
            // validate custom designation
            if(($scope.newDesignation.chosenProgram !== undefined && $scope.newDesignation.chosenProgram !== null) &&
                ($scope.newDesignation.chosenProgram.name !== undefined && $scope.newDesignation.chosenProgram.name !== null) &&
                ($scope.newDesignation.customDesignationContact !== undefined && $scope.newDesignation.customDesignationContact !== null)) {
                if($scope.newDesignation.giftAmount >= 5) {
                    validated = true;
                    if(debug) console.log('custom program has been validated');
                }
            }
        } else {
            // validate standard designation
            if(debug) console.log('validate standard Designation');
            if(($scope.newDesignation !== undefined && $scope.newDesignation !== null && $scope.newDesignation.chosenProgram !== undefined) &&
                $scope.newDesignation.chosenProgram !== null) {
                if($scope.newDesignation.chosenProgram.id !== undefined && $scope.newDesignation.chosenProgram.id !== null) {
                    if($scope.newDesignation.giftAmount >= 5) {
                        validated = true;
                        if(debug) console.log('standard program has been validated');
                    }
                }
            }
        }
        return validated;
    };

    $scope.validateGift = function() {
        /**
         * Angular is set up to validate the data right in the View.
         * Here we check to see if there are errors and show error fields where necessary,
         * or return True to allow the user to proceed to the payment page.
         *
         * @method validateGift
         */
        if(debug) console.log('$scope.validateGift * * * VALIDATING * * * ');
        var validated = false;

        if(validateNewDesignation()) {
            // check to see if there's a new designation not added yet that is valid
            $scope.addAnotherDesignation();
            validated = true;
        } else {
            // otherwise, if there is a saved designation then we're good also.
            if($scope.myDesignations && $scope.myDesignations.length > 0) {
                if(debug) console.log('$scope.validateGift mydesignations exists');
                if(debug) console.dir($scope.myDesignations);
                validated = true;
            }
        }
        // display errors
        $scope.errors = true;
        if($scope.newDesignation.customDesignation) {
            if(debug) console.log('$scope.validateGift custom designation');
        } else {
            if(debug) console.log('$scope.validateGift stock designation');
        }

        return validated;
    };
}
