<#import "common.ftl" as c>
<@c.page>
    <table class="table">
    <tr>
        <th>Товар</th>
        <th>Количесво</th>
        <th>Дата</th>
    </tr>

    <#list orders as order>

        <tr>
            <td>${order.product.description}</td>
            <td>${order.count}</td>
            <td>${order.orders_date}</td>
        </tr>

    </#list>
</table>
</@c.page>