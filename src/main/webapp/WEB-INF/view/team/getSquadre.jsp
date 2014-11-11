<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <c:forEach items="${squadre}" var="squadra">
        <div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><img src="img/ball.jpg"/> ${squadra.nome}</h3>
                </div>
                <div class="panel-body">
                    <table class = "teamBox">
                        <thead>
                        <tr> <td colspan="4">Referente:</td> </tr>
                        <tr> <td colspan="4"><hr/></td> </tr>
                        <tr>
                            <td class="empty"> </td>
                            <td>First Name</td>
                            <td>Last Name</td>
                            <td>Mail</td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td class="empty"></td>
                            <td>${squadra.referente.nome}</td>
                            <td>{squadra.referente.cognome}</td>
                            <td>${squadra.referente.mail}</td>
                        </tr>

                        <tr> <td colspan="4">Team</td> </tr>
                        <tr> <td colspan="4"><hr/></td> </tr>
                        <c:forEach items="${squadra.giocatori}" var="giocatoreAux">
                            <tr>
                                <td class="empty"> </td>
                                <td>${giocatoreAux.nome}</td>
                                <td>${giocatoreAux.cognome}</td>
                                <td> </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="4"> <hr/> </td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
    </c:forEach>
</div>