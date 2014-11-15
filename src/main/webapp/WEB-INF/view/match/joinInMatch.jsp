<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ui-util" tagdir="/WEB-INF/tags/ui-utils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <div class="row">
        <div id="search" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <form name="searchMatch" action="searchMatch" method="post">
                <div class="row">
                    <div class="form-group">
                        <label for="date" class = "col-lg-2 col-md-2 col-sm-2 col-xs-2">Date:</label>
                        <div class = "col-lg-4 col-md-4 col-sm-4 col-xs-4">
                            <input id="date" name="date" type="text" data-date-picker="datePicker" class="form-control" />
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <label for="footballField" class = "col-lg-2 col-md-2 col-sm-2 col-xs-2">Campo:</label>
                        <div class = "col-lg-4 col-md-4 col-sm-4 col-xs-4">
                            <select id="footballField" data-auto-complete="autoComplete"  class="form-control" name="footballField">
                                <c:forEach items="${campi}" var="campo" >
                                    <option> ${campo} </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <label for="hour" class="col-lg-2 col-md-2 col-sm-2 col-xs-2">Hour:</label>
                        <div class = "col-lg-4 col-md-4 col-sm-4 col-xs-4">
                            <select id="hour" data-auto-complete="autoComplete" class="form-control" name="hour">
                                <c:forEach items="${hours}" var="hour" >
                                    <option> ${hour} </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <button class="btn btn-default" type="submit">Search</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <ui-util:separator columnNumber="12" />

    <div class="row">
        <div  class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <form name="joinInMatch" action="palyerJoinInMatch" method="post">
                <!--join div-->
                <c:if test="${not empty match.partitaId}"  >
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 logInBoxHeader">
                            <img src="img/ball.jpg"/> Match of the <fmt:formatDate value="${match.partitaId.giorno}" pattern="dd/MM/yyyy" /> at ${match.partitaId.ora} in football field ${match.partitaId.campoId}
                        </div>
                    </div>

                    <div class="rox">
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><img src="img/ball.jpg"/>${match.squadraSfidante.nome}</h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table">
                                        <thead>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${match.squadraSfidante.giocatori}" var="giocatoriSquadraSfidanteAux" >
                                                <tr>
                                                    <td>${giocatoriSquadraSfidanteAux.nome}</td>
                                                    <td>${giocatoriSquadraSfidanteAux.cognome}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><img src="img/ball.jpg"/> ${match.squadraSfidata.nome}</h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table">
                                        <thead>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${match.squadraSfidata.giocatori}" var="giocatoriSquadraSfidataAux" >
                                            <tr>
                                                <td> ${giocatoriSquadraSfidataAux.nome} </td>
                                                <td> ${giocatoriSquadraSfidataAux.cognome} </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <img src="img/ball.jpg"/> <button type="submit" title="Join i match" onclick="palyerJoinInMatch('${match.partitaId.giorno}','${match.partitaId.ora}','${match.partitaId.campoId}')">Join i match</button>
                    </div>
                </div>
                </c:if>
            </form>
        </div>
    </div>

</div>