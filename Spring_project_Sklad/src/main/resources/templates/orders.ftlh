<#import "common.ftl" as c>

<@c.page>

    <h2>Заказы</h2>
    <br>
    <table class="table table-bordered table-hover">
        <tr>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Товар</th>
            <th>Адрес доставки</th>
            <th>Количество</th>
            <th>Дата</th>
            <th>Фото</th>
        </tr>
        <#list orders as order>
            <tr>
                <td>${order.customer.first_name}</td>
                <td>${order.customer.last_name}</td>
                <td>${order.product.description}</td>
                <td>${order.customer.address}</td>
                <td>${order.count}</td>
                <td>${order.orders_date}</td>
                <td>
                    <a href="files/${order.filesInfo.getStorageName()}">
                        ${order.filesInfo.originalName}</a>
                </td>
            </tr>
        </#list>
    </table>
    <form method="post" action="/add_order">
        <button type="submit" class="btn btn-outline-success">Добавить</button>
    </form>

</@c.page>