<#import "common.ftl" as c>
<@c.page>
    <h3>Добро пожаловать на наш Sklad</h3>
    <br>
    <form method="post" action="/signIn">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Email</label>
                <input type="email" name="email" class="form-control" placeholder="Email">
            </div>
            <div class="form-group col-md-6">
                <label>Password</label>
                <input type="password" name="password" class="form-control" placeholder="Password">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Sign In</button>
        <a href="signUp">Sign Up</a>
    </form>
</@c.page>