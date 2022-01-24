<#import "common.ftl" as c>

<@c.page>

    <h4>Имя: ${customer.first_name}</h4>
    <h4>Фамилия: ${customer.last_name}</h4>
    <br>
<#--    <form method="post" action="/customer/${customer.id}/update">-->
<#--        <label>-->
<#--            Имя: <input name="first_name" value="${customer.first_name}">-->
<#--        </label>-->
<#--        <br>-->
<#--        <label>-->
<#--           Фамилия: <input name="last_name" value="${customer.last_name}">-->
<#--        </label>-->
<#--        <br>-->
<#--        <input type="submit" value="Редактировать">-->
<#--    </form>-->
<#--    <br>-->
<#--    <form method="post" action="/customer/${customer.id}/delete">-->
<#--        <input type="submit" value="Удалить">-->
<#--    </form>-->
    <form method="post" action="/customer/${customer.id}/update">
        <div class="row">
            <div class="col">
                <label>
                    <input type="text" name="first_name" class="form-control"
                           value="${customer.first_name}">
                </label>
                <label>
                    <input type="text" name="last_name" class="form-control"
                           value="${customer.last_name}">
                </label>
                <button type="submit" class="btn btn-primary">Редактировать</button>
            </div>

        </div>
    </form>
    <div class="row">
    <div class="col">
            <form method="post" action="/customer/${customer.id}/delete">
                 <input type="submit" value="Удалить">
            </form>
        </div>
    </div>

</@c.page>