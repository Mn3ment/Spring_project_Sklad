<#import "common.ftl" as c>

<@c.page>
    <h2>Добавить покупателя</h2>
    <br>
    <form method="post" action="/customer">
        <div class="form-row">
            <div class="form-group col-md-4">
                <label>Имя:</label>
                <input name="first_name" class="form-control" placeholder="Имя">
            </div>
            <div class="form-group col-md-4">
                <label>Фамилия:</label>
                <input name="last_name" class="form-control" placeholder="Фамилия:">
            </div>

        </div>
        <button type="submit" class="btn btn-outline-success">Добавить</button>
    </form>
    <br>
    <table class="table table-bordered table-hover">
        <tr>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Заказы</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list customer as custom>
            <tr>
                <form method="post" action="/customer/${custom.id}/update" class="form-inline">
                <td>
                    <div>
                        <label class="sr-only">first_name</label>
                        <input name="first_name" type="text" class="form-control-plaintext"
                               value="${custom.first_name}">
                    </div>
                </td>
                <td>

                    <div class="form-group mb-2">
                        <label class="sr-only">last_name</label>
                        <input name="last_name" type="text" class="form-control-plaintext"
                                value="${custom.last_name}">
                    </div>
                </td>
                <td>
                    <button type="submit" class="btn btn-outline-primary">Edit</button>
                </td>
            </form>
                <td>
                    <form method="post" action="/customer/${custom.id}/delete">
                        <button type="submit" class="btn btn-outline-danger">Del</button>
                    </form>
                </td>
                <td>
                    <form method="post" action="/customer/${custom.id}/orders">
                        <button type="submit" class="btn btn-outline-info">Заказы</button>
                    </form>
                </td>
        </tr>
    </#list>
</table>
</@c.page>