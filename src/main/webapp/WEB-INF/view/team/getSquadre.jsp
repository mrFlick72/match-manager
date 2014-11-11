<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <c:forEach items="${squadre}" var="squadra">
        <div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><img src="img/ball.jpg"/> ${squadra.nome}</h3>
                </div>
                <div class="panel-body">
                    <h1>Leader:</h1>
                    <table class = "table">
                        <thead>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Mail</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${squadra.referente.nome}</td>
                                <td>${squadra.referente.cognome}</td>
                                <td>${squadra.referente.mail}</td>
                            </tr>

                            <tr><td colspan="3"><h1>Team:</h1></td></tr>

                            <c:forEach items="${squadra.giocatori}" var="giocatoreAux">
                                <tr>
                                    <td>${giocatoreAux.nome}</td>
                                    <td>${giocatoreAux.cognome}</td>
                                    <td/>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </c:forEach>
</div>