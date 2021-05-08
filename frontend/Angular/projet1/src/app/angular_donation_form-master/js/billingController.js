'use strict';
var myApp= angular.module('myApp');

function FormBillingController($scope, $window, Gift, FormDefaults, CallbackData) {
    /**
     * Form Billing Controller is used on the second page of the form, where the billiing information is entered.
     * This script is responsible for making sure there is valid data, displaying errors, as well as
     * making the api call and building the api query string.
     *
     * @class FormBillingController
     */
    $scope.gift = Gift.getGift();
    var gift = $scope.gift;

    var formId = FormDefaults.get('FormId');
    var givingLevelId = FormDefaults.get('GivingLevelId');
    var apiKey = FormDefaults.get('ApiKey');
    var path = FormDefaults.get('Path');
    var donor;

    // ------------------------------------------------------------------- Go Back to Gift
    $scope.backToGift = function() {
        /**
         * There's a back button and a page 1 button.
         * The user clicks either and we control where they go here.
         *
         * @method backToGift
         */
        $window.location.href = "#/step1";
    };

    // ------------------------------------------------------------------- Donate Now
    $scope.donateNow = function () {
        /**
         * Donate Now! It's finally happening! They pulled the trigger!
         * First we make sure the form is valid, then we build the api query string, then we make the call, then we process the callback,
         * then we (hopefully) send the user to the Thank You Page, otherwise we tell them what went wrong.
         *
         * @type {document.donor}
         */
        donor = $scope.donor;
        console.log('donateNow ' + $scope.donor.$valid);
        if(!$scope.donor.$valid) {
            // form is not valid. send them back.
            jQuery('input, select').addClass('submitted');
            $scope.errors = true;
            return false;
        }

        // form is valid! Make the API call.
        var myDataString = prepareQueryString();

        // make sure the error message is hidden
        jQuery('.donation-errors').css('display','none');

        // show the wait message
        jQuery('.donation-progress').css('display','block');

        // use the luminateExtend library to make the api call
        luminateExtend({
            apiKey: apiKey,
            path: path
        });

        // submit the form
        luminateExtend.api({
            api: 'donation',
            callback: donateCallback,
            data: myDataString,
            useHTTPS: true,
            requestType: 'POST'
        });

        function donateCallback (data) {
            console.log('in donate callback');
            console.dir(data);
            if(data.donationResponse) {
                if(data.donationResponse.errors) {
                    jQuery('.donation-progress').css('display','none');
                    jQuery('.donation-error').css('display','block').html(data.donationResponse.errors.declineUserMessage);
                }
                if(data.donationResponse.donation) {
                    jQuery('.donation-progress').css('display','block');
                    CallbackData.putResponse(data.donationResponse);
                    $window.location.href = "index.html#/thankyou";
                }
            }
        }
        return true;
    };

    // ------------------------------------------------------------------- Create the API call
    var prepareQueryString = function() {
        /**
         * Prepare Query String makes sure the donor information is put together properly for a successful api call.
         * There are several possible ways things could go. There are branches for:
         * Monthly or one-time donation
         * Honor or Memorial Gift ('tribute' gifts)
         * Custom or 'stock' designation
         * Each designation must be assigned an integer to keep the info straight.
         *
         * @method prepareQueryString
         */
        var dataString = 'method=donate' +
            '&form_id=' + formId +
            '&level_id=' + givingLevelId ;    // always 'other amount' gotten from FormDefaults service

        // if donor name and address information is filled out, use it, but only billing info is required
        if(donor.nameFirst) dataString += '&donor.name.first=' + donor.nameFirst;
        if(donor.nameLast) dataString += '&donor.name.last=' + donor.nameLast;
        if(donor.addressCity) dataString += '&donor.address.city=' + donor.addressCity;
        if(donor.addressState) dataString += '&donor.address.state=' + donor.addressState;
        if(donor.addressStreet1) dataString +=     '&donor.address.street1=' + donor.addressStreet1;
        if(donor.addressStreet2) dataString += '&donor.address.street2=' + donor.addressStreet2;
        if(donor.addressStreet3) dataString += '&donor.address.street3=' + donor.addressStreet3;

        if(donor.pledgePayment) dataString += '&existing_pledge_payment=' + donor.pledgePayment;
        if(donor.addressCountry) dataString += '&donor.address.country=';
        if(donor.addressZip) dataString += '&donor.address.zip=' + donor.addressZip;
        if(donor.emailOptIn) dataString += '&donor.email_opt_in=' + donor.emailOptIn;
        if(donor.employer) dataString += '&donor.employer=' + donor.employer;
        if(donor.nameMiddle) dataString += '&donor.name.middle=' + donor.nameMiddle;
        if(donor.phone) dataString += '&donor.phone=' + donor.phone;

        dataString  += '&donor.email=' + donor.donorEmail;
        dataString += '&billing.address.city=' + donor.billingAddressCity;
        dataString += '&billing.address.state=' + donor.billingAddressState;
        dataString += '&billing.address.zip=' + donor.billingAddressZip;
        dataString += '&billing.name.first=' + donor.billingNameFirst;
        dataString += '&billing.name.last=' + donor.billingNameLast;
        if(donor.billingAddressCountry) dataString += '&billing.address.country=' + donor.billingAddressCountry;
        dataString += '&billing.address.street1=' + donor.billingAddressStreet1;
        if(donor.billingAddressStreet2) dataString += '&billing.address.street2=' + donor.billingAddressStreet2;
        if(donor.billingAddressStreet3) dataString += '&billing.address.street3=' + donor.billingAddressStreet3;
        if(donor.billingNameMiddle) dataString += '&billing.name.middle=' + donor.billingNameMiddle;

        // add designations
        var designationDataString = '';

        for(var i=0; i<gift.designations.length; i++) {
            // is it custom?
            if(gift.designations[i].chosenDesignation.name === "custom") {
                // custom designation entered by user
                designationDataString += '&designated_write_in.' + i + '.amount=' + gift.designations[i].giftAmount + '&designated_write_in.' + i + '.contact=' + gift.designations[i].customDesignationContact + '&designated_write_in.' + i + '.name=' + gift.designations[i].chosenProgram.name;
            } else {
                // standard designation
                designationDataString += '&designated.' + i + '.amount=' + gift.designations[i].giftAmount + '&designated.' + i + '.id=' + gift.designations[i].chosenProgram.id;
            }
        }
        dataString += designationDataString;


        if(gift.recurring === 'true') {
            dataString +=
                // zero = forever
                '&sustaining.duration=0' +
                    '&sustaining.frequency=' + gift.installmentFrequency;
        } else {
            dataString += '&sustaining.frequency=one-time';
        }

        if(gift.tribute === 'true') {
    //            if(gift.billingNameMiddle) dataString += '&tribute.honoree.deceased=' +
            if(gift.tributeHonoreeNameFirst) dataString += '&tribute.honoree.name.first=' + gift.tributeHonoreeNameFirst;
            if(gift.tributeHonoreeNameLast) dataString += '&tribute.honoree.name.last=' + gift.tributeHonoreeNameLast;
            if(gift.tributeMessageBody) dataString += '&tribute.message.body=value' + gift.tributeMessageBody;
            if(gift.tributeNotifyAddressCity) dataString += '&tribute.notify.address.city=' + gift.tributeNotifyAddressCity;
            if(gift.tributeNotifyAddressCountry) dataString += '&tribute.notify.address.country=' + gift.tributeNotifyAddressCountry;
            if(gift.tributeNotifyAddressState) dataString += '&tribute.notify.address.state=' + gift.tributeNotifyAddressState;
            if(gift.tributeNotifyAddressStreet1) dataString += '&tribute.notify.address.street1=' + gift.tributeNotifyAddressStreet1;
            if(gift.tributeNotifyAddressStreet2) dataString += '&tribute.notify.address.street2=' + gift.tributeNotifyAddressStreet2;
            if(gift.tributeNotifyAddressZip) dataString += '&tribute.notify.address.zip=' + gift.tributeNotifyAddressZip;
            if(gift.tributeNotifyNameFull) dataString += '&tribute.notify.name.full=' + gift.tributeNotifyNameFull;
            if(gift.tributeType) dataString += '&tribute.type=' + gift.tributeType;
        }

        // todo: payment type is always credit card. Add paypal and ach.
    //        if(payment.paymentType === 'cc') {
        dataString += '&card_cvv=' + donor.cardCvv +
            '&card_exp_date_month=' + donor.cardExpMonth +
            '&card_exp_date_year=' + donor.cardExpYear +
            '&card_number='+ donor.cardNumber;
    //        }

    //        if(payment.paymentType === 'ach') {
    //            dataString += '&ach_account=' +
    //                '&ach_account_type=CHECKING | SAVINGS' +
    //                '&ach_bank=' +
    //                '&ach_routing=' +
    //                '&ach_transit='  ;
    //        }

        return dataString;
    };
}