
goog.provide("parse_names.vendor_test");
goog.require("parse_names.vendor");

parse_names.vendor_test.names = [
    {
	name: "John Doe",
	result: {
	    "salutation": "",
	    "firstName": "John",
	    "initials": "",
	    "lastName": "Doe",
	    "suffix": ""
	}
    }, {
	name: "Mr Anthony R Von Fange III",
	result: {
	    "salutation": "Mr.",
	    "firstName": "Anthony",
	    "initials": "R",
	    "lastName": "Von Fange",
	    "suffix": "III"
	}
    }, {
	name: "Sara Ann Fraser",
	result: {
	    "salutation": "",
	    "firstName": "Sara Ann",
	    "initials": "",
	    "lastName": "Fraser",
	    "suffix": ""
	}
    }, {
	name: "Adam",
	result: {
	    "salutation": "",
	    "firstName": "Adam",
	    "initials": "",
	    "lastName": "",
	    "suffix": ""
	}
    }, {
	name: "Jonathan Smith",
	result: {
	    "salutation": "",
	    "firstName": "Jonathan",
	    "initials": "",
	    "lastName": "Smith",
	    "suffix": ""
	}
    }, {
	name: "Anthony Von Fange III",
	result: {
	    "salutation": "",
	    "firstName": "Anthony",
	    "initials": "",
	    "lastName": "Von Fange",
	    "suffix": "III"
	}
    }, {
	name: "Mr John Doe",
	result: {
	    "salutation": "Mr.",
	    "firstName": "John",
	    "initials": "",
	    "lastName": "Doe",
	    "suffix": ""
	}
    }, {
	name: "Smarty Pants Phd",
	result: {
	    "salutation": "",
	    "firstName": "Smarty",
	    "initials": "",
	    "lastName": "Pants",
	    "suffix": "PhD"
	}
    }, {
	name: "Mark P Williams",
	result: {
	    "salutation": "",
	    "firstName": "Mark",
	    "initials": "P",
	    "lastName": "Williams",
	    "suffix": ""
	}
    }];

parse_names.vendor_test.basic_asserts = function() {
    parse_names.vendor_test.names.forEach(function(testCase){
        var parsed = parse_names.vendor.parse(testCase.name);
        if (JSON.stringify(parsed) !== JSON.stringify(testCase.result)) {
            console.log("Name:     ", testCase.name);
            console.log("Expected: ", testCase.result);
            console.log("Found:    ", parsed);
            throw "Test failed";
        }
        console.log("All tests passed");
    });
};
