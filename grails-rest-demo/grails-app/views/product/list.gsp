<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Productlist</title>
</head>
<body>
    <div id="main" role="main">
        <h1>Productlist</h1>
        <table>
            <thead>
                <tr>
                    <g:sortableColumn property="name" title="Name" />
                    <g:sortableColumn property="price" title="Price" />
                </tr>
            </thead>
            <tbody>
            <g:each var="product" in="${productList}">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</body>
</html>
