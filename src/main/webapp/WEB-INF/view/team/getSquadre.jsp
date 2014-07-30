<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="grid_12">

        <%--for all team--%>
        <c:forEach items="${squadre}" var="squadra">

            <div style="width: 40%">
                <div class="logInBoxHeader">
                    <img src="img/ball.jpg"/> ${squadra.nome}

                </div>
                <div class="logInBoxBody">

                    <table class = "teamBox">
                        <thead>
                        <tr>
                            <td colspan="4">Referente:</td>
                        </tr>
                        <tr>
                            <td colspan="4"><hr/></td>
                        </tr>
                        <tr>
                            <td class="empty"> </td>
                            <td>
                                First Name
                            </td>
                            <td>
                                Last Name
                            </td>
                            <td>
                                Mail
                            </td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td class="empty"></td>
                            <td>
                                    ${squadra.referente.nome}
                            </td>
                            <td>
                                    ${squadra.referente.cognome}
                            </td>
                            <td>
                                    ${squadra.referente.mail}
                            </td>
                        </tr>

                        <tr>
                            <td colspan="4">Team</td>
                        </tr>
                        <tr>
                            <td colspan="4"><hr/></td>
                        </tr>
                        <c:forEach items="${squadra.giocatori}" var="giocatoreAux">
                            <tr>
                                <td class="empty"> </td>
                                <td>
                                        ${giocatoreAux.nome}
                                </td>
                                <td>
                                        ${giocatoreAux.cognome}
                                </td>
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

        </c:forEach>

    </div>
    <div class="clear"></div>