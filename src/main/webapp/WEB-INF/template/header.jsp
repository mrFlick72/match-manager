<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid header sfondo">
    <div class="row">

        <!--header div-->
        <div class = "col-lg-10 col-md-10 col-sm-10 col-xs-10">
            <h1 class="title"> Match Manager </h1>
            <h2 class="title"> the software that help you for create new match of football </h2>
        </div>

        <div class = "col-lg-2 col-md-2 col-sm-2 col-xs-2">
            <div class="logInBoxHeader">
                <img src="img/ball.jpg"/> Login's Panel
            </div>
            <div class="logInBoxBody">
                <c:choose>
                    <c:when test="${referente == null}">
                        <form action="logIn" method="post">
                            <table>
                                <tr>
                                    <td>User Name:</td>
                                    <td>
                                        <input name="userNameIn" type="text" size="6" value="admin"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Password:</td>
                                    <td>
                                        <input name="passwordIn" type="password" size="6"  value="admin"/>
                                    </td>
                                </tr>
                            </table>
                            not registered? ... <a href="registerForm">register now!!!</a>

                            <button type="submit">log-In</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form action="logOut" method="post">
                            Hello! ${referente.nome}
                            <br/>
                            Welcome back
                            <hr/>
                            User data:
                            <table>

                                <tr>
                                    <td>First Name:</td>
                                    <td>
                                            ${referente.nome}
                                    </td>
                                </tr>
                                <tr>
                                    <td>Last Name:</td>
                                    <td>
                                            ${referente.cognome}
                                    </td>
                                </tr>
                                <tr>
                                    <td>User Name:</td>
                                    <td>
                                            ${referente.userName}
                                    </td>
                                </tr>
                                <tr>
                                    <td><button type="submit">log-out</button></td>
                                </tr>
                            </table>
                        </form>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>
