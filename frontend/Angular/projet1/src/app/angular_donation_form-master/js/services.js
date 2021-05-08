'use strict';
var myApp= angular.module('myApp');

myApp.service('FormDefaults', function() {
    /**
     * Here we have a simple model to hold onto and return presets across the form.
     * As a closure, the information is more secure.
     *
     * @method FormDefaults
     */
    var Defaults = {
        GivingLevels : [{
            'amount' : '25',
            'label' : '$25'
        },{
            'amount' : '50',
            'label' : '$50'
        },{
            'amount' : '150',
            'label' : '$150'
        },{
            'amount' : '300',
            'label' : '$300'
        },{
            'amount' : 'other',
            'label' : 'Other Amount'
        }],
        FormId : '1234',
        GivingLevelId : '1234',
        ApiKey : 'abc123',
        Path : {
            nonsecure: 'http://example.com/',
            secure: 'https://example.com/'
        }
    };

    this.get = function(name) {
        return Defaults[name];
    };
});

myApp.service('Gift', function() {
    /**
     * Gift simply stores information about the user entered gifts, already validated,
     * preserving them as the user navigates from page to page.
     *
     * @method Gift
     */
    var gift = {};
    this.make = function(newGift) {
        gift = newGift;
    };
    this.getGift = function() {
        return gift;
    };
});

myApp.service('CallbackData', function() {
    /**
     * CallbackData holds onto confirmation information from the server after a successfull donation api call.
     * When the user is redirected to the ThankYou page on success, CallbackData will supply confirmation numbers,
     * non-taxable donation amounts and other information associated with the donation as confirmed by the server.
     *
     * @method CallbackData
     */
    var response = {};
    this.getResponse = function() {
        return response;
    };
    this.putResponse = function(r) {
        response = r;
    };
});

myApp.service('Designations', function($http, $q, FormDefaults) {
    /**
     * Designations calls the 'ghost form' setup on the backend to gather the designations listed.
     * This gives us the flexibility to use this Service across different forms, even across organizations served.
     * getDesignations is an asynchronous call that uses promises (and $q) to pass the data when it is ready.
     *
     * @method Designations
    */
    return {
        getDesignations: function() {
            var apiKey = FormDefaults.get('ApiKey');
            var path = FormDefaults.get('Path');
            var formId = FormDefaults.get('FormId');
            var queryString = 'method=getDesignees&form_id=' + formId + '&api_key=' + apiKey + '&response_format=json&v=1.0';
            var uri = path.secure + 'CRDonationAPI?' + queryString;
            var deferred = $q.defer();

            $http.get(uri).
            success(function(data, status, headers, config) {
                console.log('getDesignations success function');
                console.dir(data);
                var sortedData = sortDesignations(data);
                deferred.resolve(sortedData);
            }).error(function(msg, code) {
                deferred.reject(msg);
                $log.error(msg, code);
            });

            function sortDesignations (data) {
                var sortedDesignations = [];
                if(data.getDesigneesResponse && data.getDesigneesResponse.designee){
                    var designations = luminateExtend.utils.ensureArray(data.getDesigneesResponse.designee);
                    _.forEach(designations, function(o) {
                        var typeId = o.typeId;
                        var child = {
                            'name' : o.name,
                            'id' : o.id
                        };
                        if(_.find(sortedDesignations, { 'typeId' : typeId })) {
                            _.find(sortedDesignations, { 'typeId' : typeId }).children.push(child);
                        } else {
                            // Now we need to cheat to add the name of the designation
                            // todo: find the name of the designation from the form
                            var designationName = '';
                            switch (typeId){
                                case "1001":
                                    designationName = 'College/School/Program';
                                    break;
                                case "1021":
                                    designationName = 'Diversity';
                                    break;
                                case "1022":
                                    designationName = 'Greatest Need';
                                    break;
                                case "1023":
                                    designationName = 'Regional Campuses';
                                    break;
                                case "1024":
                                    designationName = 'Special Interest';
                                    break;
                                case "1025":
                                    designationName = 'Student Support';
                                    break;
                                default:
                                    designationName = 'error_unknown';
                                    break;
                            }

                            // create the key, then add the object
                            var newObject = {
                                'name' : designationName,
                                'typeId' : typeId,
                                'children' : [
                                    child
                                ]
                            };
                            sortedDesignations.push(newObject);
                        }
                    });
                }
                return sortedDesignations
            }   // end sortDesignations function

            return deferred.promise;

        }   // end getDesignations function
    }; // end return statement
});

myApp.service('GiftDesignations', function() {
    /**
     * Gifts keeps track of the Gifts the Donor adds and removes.
     * Gifts are preserved while the user can navigate between pages and between controllers.
     *
     * Gifts = {
     *    designations = [     {
     *        name   : string,  // name of designation or of custom designation
     *        id     : int,     // -1 for custom
     *        amount : number   // dollar amount of gift     }     ]     }
     *
     * @method GiftDesignations
     */
    var designations = [];

    this.add = function(newDesignation) {
        designations.push(newDesignation);
        console.dir(designations);
    };

    this.remove = function(index) {
        designations.splice(index, 1);
    };
    this.getDesignations = function() {
        console.log('Designations service returning all designations');
        return designations;
    };
});

