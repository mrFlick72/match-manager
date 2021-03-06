<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid header sfondo">
    <div class="row">

        <!--header div-->
        <div class = "col-lg-9 col-md-9 col-sm-9 col-xs-9">
            <h1 class="title"> Match Manager </h1>
            <h2 class="title"> the software that help you for create new match of football </h2>
        </div>

        <div class = "col-lg-3 col-md-3 col-sm-3 col-xs-3">
            <div class="panel panel-default sfondo">
                <div class="panel-heading"><div class="label"><img src="img/ball.jpg"/></div>Login's Panel</div>

                <div class="panel-body">
                    <c:choose>
                        <c:when test="${referente == null}">
                            <form action="logIn" method="post" class="form-horizontal">
                                <div class="row">
                                    <div class="form-group">
                                        <span class="control-label col-lg-4 col-md-4 col-sm-4 col-xs-4">User Name:</span>
                                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                            <input name="userNameIn" type="text" placeholder="admin" class="form-control"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="form-group">
                                        <span class="control-label col-lg-4 col-md-4 col-sm-4 col-xs-4">Password:</span>
                                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                            <input name="passwordIn" type="password" placeholder="admin" class="form-control"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <span class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        not registered? ... <a href="registerForm">register now!!!</a>
                                    </span>
                                </div>

                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <button type="submit" class="btn btn-default">log-In</button>
                                    </div>
                                </div>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <form action="logOut" method="post" class="form-horizontal">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        Hello! ${referente.nome}
                                        <br/>
                                        Welcome back
                                        <hr/>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <button class="btn btn-default" type="submit">log-out</button>
                                    </div>
                                </div>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</div>
