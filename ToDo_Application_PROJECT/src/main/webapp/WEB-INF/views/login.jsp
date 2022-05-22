<%--
  Created by IntelliJ IDEA.
  User: Jakhongir
  Date: 21-02-2019
  Time: 20:51

--%>

<%@include file="../common/header.jspf"%>
<%@include file="../common/navbar.jspf"%>


<div class="container">
    <h1 style="text-align: center;">What to do next ? </h1>
    <form action="/login" method="POST" class="form-group d-inline">
        <input type="text" name="name" placeholder="Username : " class="form-control">
        <br>
        <input type="password" name="pw" placeholder="Password : " class="form-control">
        <%--<input style="margin-top: 25px;margin-left: 25px " class="btn btn-default" type="submit" value="Log In "><i class="fas fa-user-check"></i>--%>
        <button type="submit" style="margin-top: 25px;margin-left: 25px " class="btn btn-secondary btn-lg">LogIn &nbsp;<i class="fas fa-user-plus"></i></button>
    </form>
    <a href="/signup"><button style="margin-top: 25px; margin-left: 25px" class="btn btn-secondary btn-lg" type="submit">Sign Up &nbsp;<i class="fas fa-user-check"></i></button></a>


    <p>${Error}</p>

</div>


<%@include file="../common/footer.jspf"%>

