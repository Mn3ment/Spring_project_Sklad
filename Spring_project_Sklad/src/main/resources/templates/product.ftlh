<#import "common.ftl" as c>

<@c.page>

<h4>Товар: ${products.description}</h4>
<h4>Цена: ${products.price}</h4>
<h4>Количество: ${products.count}</h4>
<br>
<form method="post" action="/products/${products.id}/update">
    <label>
        Название товара: <input name="description" value="${products.description}">
    </label>
    <br>
    <label>
        Цена: <input name="price" value="${products.price}">
    </label>
    <br>
    <label>
        Количество: <input name="count" value="${products.count}">
    </label>
    <br>
    <input type="submit" value="Редактировать">
    <form method="post" action="/products/${products.id}/delete">
        <input type="submit" value="Удалить">
    </form>
</form>

</@c.page>