import geb.spock.GebReportingSpec
import pages.ProductListPage

class ProductListSpec extends GebReportingSpec {

    def "Product list page shows all currently known products"() {
        when:
        to ProductListPage

        then:
        heading.text() == "Productlist"
        productRows.size() == 2
    }

}
