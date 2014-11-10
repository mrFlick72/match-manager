<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <div id="search" class="grid_12">
        <form name="searchMatch" action="searchMatch" method="post">
            <table>
                <tr>
                    <td>
                        Date:
                    </td>
                    <td>
                        <input name="date" type="text" id="datepicker"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Campo:
                    </td>
                    <td>
                        <select name="footballField">
                            <option> ------------------ </option>
                            <c:forEach items="${campi}" var="campo" >
                                <option> ${campo} </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Ora:
                    </td>
                    <td>      
                        <select name="hour">
                            <option> ------------------ </option>
                            <c:forEach items="${hours}" var="hour" >
                                <option> ${hour} </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"> <button type="submit">Search</button> </td>
                </tr>
            </table>
        </form>
    </div>
    <div class="clear"></div>

    <div class="grid_12">
        <hr/>
    </div>
    <div class="clear"></div>

    <form name="joinInMatch" action="palyerJoinInMatch" method="post">
        <!--join div-->
        <c:if test="${not empty match.partitaId}"  >

            <div class="grid_12 logInBoxHeader">
                <img src="img/ball.jpg"/> Match of the <fmt:formatDate value="${match.partitaId.giorno}" pattern="dd/MM/yyyy" /> at ${match.partitaId.ora} in football field ${match.partitaId.campoId}
            </div>
            <div class="clear"></div>

            <div class="grid_12 logInBoxBody">
                <div class="grid_6 alpha">
                        ${match.squadraSfidante.nome} <br/>
                    <table class="teamBox">
                        <thead>
                        <tr>
                            <th> First Name </th>
                            <th> Last Name </th>
                        </tr>
                        </thead>
                        <c:forEach items="${match.squadraSfidante.giocatori}" var="giocatoriSquadraSfidanteAux" >

                            <tbody>
                            <tr>
                                <td> ${giocatoriSquadraSfidanteAux.nome} </td>
                                <td> ${giocatoriSquadraSfidanteAux.cognome} </td>
                            </tr>
                            </tbody>

                        </c:forEach>
                    </table>
                </div>
                <div class="grid_6 omega">
                        ${match.squadraSfidata.nome} <br/>
                    <table class="teamBox">
                        <thead>
                            <tr>
                                <th> First Name </th>
                                <th> Last Name </th>
                            </tr>
                        </thead>
                        <c:forEach items="${match.squadraSfidata.giocatori}" var="giocatoriSquadraSfidataAux" >

                            <tbody>
                                <tr>
                                    <td> ${giocatoriSquadraSfidataAux.nome} </td>
                                    <td> ${giocatoriSquadraSfidataAux.cognome} </td>
                                </tr>
                            </tbody>

                        </c:forEach>
                    </table>

                </div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>

            <div class="grid_12 logInBoxBody">
                <img src="img/ball.jpg"/> <button type="submit" title="Join i match" onclick="palyerJoinInMatch('${match.partitaId.giorno}','${match.partitaId.ora}','${match.partitaId.campoId}')">Join i match</button>
            </div>
            <div class="clear"></div>

        </c:if>
    </form>

</div>