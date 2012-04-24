package grails.rest.demo

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Product)
class ProductSpec extends Specification {

    @Unroll({"Product with price $price will be rejected"})
    def "Product must have a non-negative price"() {
        given:
        mockForConstraintsTests Product
        def product = new Product(price: price)

        expect:
        !product.validate()
        product.errors['price'] == 'min'

        where:
        price << [0.00, -10.00]
    }

}
