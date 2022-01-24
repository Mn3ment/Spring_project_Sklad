<#import "common.ftl" as c>

<@c.page>

    <h1>Загрузка Файлов</h1>
    <br>
    <form method="post" action="/files/upload" enctype="multipart/form-data">
        <label>Комментарий к файлу:
            <input name="description" placeholder="Введите описание файла">
        </label>
        <input type="file" name="file">
        <input type="submit" value="Загрузить">
    </form>

</@c.page>