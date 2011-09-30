package pages

import geb.Page

class ProductListPage extends Page {

    static url = "product/list"

    static content = {
        heading { $("h1") }
        productTable { $("div.list table", 0) }
		productRows(required: false) { productTable.find("tbody").find("tr") }
    }

}
