describe('Greeter', function() {

    it('says "Hello World!" if no name is given', function() {
        expect(Greeter.greet()).toBe('Hello World!');
    });

    it('says "Hello $name!" if $name is given', function() {
        var name = 'Stefan';
        expect(Greeter.greet(name)).toBe('Hello ' + name + '!');
    });

});
