<#import "common.ftl" as c>

<@c.page>

<h2>Добавить товар</h2>
<br>
<form method="post" action="/products">
    <div class="form-row">
        <div class="form-group col-md-4">
            <label>Товар:</label>
            <input name="description" class="form-control" placeholder="Товар">
        </div>
        <div class="form-group col-md-4">
            <label>Цена:</label>
            <input name="price" class="form-control" placeholder="Цена">
        </div>
        <div class="form-group col-md-4">
            <label>Количество:</label>
            <input name="count" class="form-control" placeholder="Количество">
        </div>
        <button type="submit" class="btn btn-outline-success">Добавить</button>
    </div>


</form>
    <br>
<table class="table table-bordered table-hover">
    <tr>
        <th>Название Товара</th>
        <th>Цена</th>
        <th>Количество</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <#list products as product>
        <tr>
            <form method="post" action="/products/${product.id}/update" class="form-inline">
                <td>
                    <div>
                        <label class="sr-only">Description</label>
                        <input name="description" type="text" class="form-control-plaintext"
                               value="${product.description}">
                    </div>
                </td>
                <td>

                    <div class="form-group mb-2">
                        <label for="staticEmail2" class="sr-only">Price</label>
                        <input name="price" type="text" class="form-control-plaintext"
                                value="${product.price}">
                    </div>
                </td>
                <td>
                    <div class="form-group mb-2">
                        <label for="staticEmail2" class="sr-only">Name</label>
                        <input name="count" type="text" class="form-control-plaintext"
                                value="${product.count}">
                    </div>
                </td>
                <td>
                    <button type="submit" class="btn btn-outline-primary">Edit</button>
                </td>
            </form>
                <td>
                    <form method="post" action="/products/${product.id}/delete">
                        <button type="submit" class="btn btn-outline-danger">Del</button>
                    </form>
                </td>
        </tr>
    </#list>
</table>

</@c.page>