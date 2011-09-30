package grails.rest.demo

class Product {

    String name
    BigDecimal price

    static constraints = {
        name(blank: false)
        price(min: 0.01)
    }

}
