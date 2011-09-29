import geb.spock.GebReportingSpec
import spock.lang.*
import pages.*

@Stepwise
class ProductListSpec extends GebReportingSpec {

    def "Product list shows all expected entries"() {
        when:
        to ProductListPage
    
        then:
        heading.text() == "Productlist"
    }

}
