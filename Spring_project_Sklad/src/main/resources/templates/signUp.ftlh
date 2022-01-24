<#import "common.ftl" as c>
<@c.page>
    <form method="post" action="/signUp">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Email</label>
                <input type="email" name="email" class="form-control" placeholder="Email">
            </div>
            <div class="form-group col-md-6">
                <label>Password</label>
                <input type="password" name="hashPassword" class="form-control" placeholder="Password">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Name</label>
                <input type="text" name="first_name" class="form-control" placeholder="Введите имя">
            </div>
            <div class="form-group col-md-6">
                <label>Last Name</label>
                <input type="text" name="last_name" class="form-control" placeholder="Введите фамилию">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Sign up</button>
    </form>
</@c.page>