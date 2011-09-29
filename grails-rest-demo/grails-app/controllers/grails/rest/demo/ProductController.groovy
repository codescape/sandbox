package grails.rest.demo

import grails.converters.*

class ProductController {

    def list = {
        def products = Product.list(sort: params.sort, order: params.order)
        withFormat {
            html { [productList: products] }
            xml { render products as XML }
            json { render products as JSON }
        }
    }

}
