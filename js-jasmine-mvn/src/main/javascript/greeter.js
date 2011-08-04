var Greeter = {

    greet: function(name) {
        name = typeof(name) != 'undefined' ? name : "World";
        return "Hello " + name + "!";
    }

};