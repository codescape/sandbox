package pages

import geb.Page

class ProductListPage extends Page {

    static url = "product/list"

    static content = {
        heading { $("h1") }
    }

}
