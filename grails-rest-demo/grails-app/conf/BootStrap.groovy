import grails.rest.demo.Product

class BootStrap {

    def init = { servletContext ->
        new Product(name: 'USB Stick 16 GB', price: 12.99).save()
        new Product(name: 'Teddy Bear', price: 19.99).save()
    }

    def destroy = {
    }

}
