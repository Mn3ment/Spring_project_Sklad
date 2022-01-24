<#import "common.ftl" as c>
<@c.page>
    <h3>Загрузка файлов</h3>
    <br>
    <form method="post" action="/files/upload" enctype="multipart/form-data">
        <label>Комментарий к файлу:
            <input name="description" placeholder="Введите описание файла">
        </label>
        <input type="file" name="file">
        <button type="submit" class="btn btn-outline-warning">Загрузить</button>
    </form>
    <br>
    <h3>Добавить заказ</h3>
    <form method="post" action="/add_orders">
    <div class="form-row">
        <div class="form-group col-md-4">
            <label>Продукт</label>
            <select name="product_id" class="form-control">
                <option selected>Select</option>
                <#list products as product>
                    <option value=${product.id}>${product.description}</option>
                </#list>
            </select>
        </div>
        <div class="form-group col-md-4">
                    <label>Покупатель</label>
                    <select name="customer_id" class="form-control">
                        <option selected>Select</option>
                    <#list customers as customer>
                    <option value=${customer.id}>${customer.first_name}</option>
                     </#list>
                </select>
        </div>
        <div class="form-group col-md-4">
            <label>Описание файла</label>
            <select name="file_info_id;" class="form-control">
                <option selected>Select</option>
                <#list files as file>
                    <option value=${file.id}>${file.description}</option>
                </#list>
            </select>
        </div>
    </div>

    <div class="form-row">
        <div class="form-group col-md-3">
            <label>Количество</label>
            <input type="text" name="count" class="form-control" placeholder="количество">
        </div>
        <div class="form-group col-md-3">
            <label>Дата заказа</label>
            <input type="date" name="orders_date" class="form-control">
        </div>
    </div>
        <button type="submit" class="btn btn-primary">Добавить</button>
    </form>
</@c.page>