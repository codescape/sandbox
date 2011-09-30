package grails.rest.demo

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin
import spock.lang.Specification

@TestFor(ProductController)
@TestMixin(DomainClassUnitTestMixin)
class ProductControllerSpec extends Specification {

    def "Product list is returned in JSON format when requested"() {
        given:
        mockDomain Product, [new Product(name: "Teddy", price: 9.00)]
        response.format = 'json'

        when:
        controller.list()

        then:
        response.json[0].name == "Teddy"
        response.json[0].price == 9.00
    }

    def "Product list is returned in XML format when requested"() {
        given:
        mockDomain Product, [new Product(name: "Teddy", price: 9.00)]
        response.format = 'xml'

        when:
        controller.list()

        then:
        response.xml.product[0].name.text() == "Teddy"
        response.xml.product[0].price.text() == "9.00"
    }

}
