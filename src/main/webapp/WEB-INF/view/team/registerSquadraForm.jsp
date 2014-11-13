<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui-util" tagdir="/WEB-INF/tags/ui-utils" %>

<div class="sfondo">
    <!--body div-->
        <script>
/*            $(document).ready(function() {
                var searchAvaibleMatch = $('#searchAvaibleMatch');
                var searchAvaibleMatchForm = searchAvaibleMatch.children('form').filter('form');

                searchAvaibleMatch.dialog({
                    resizable:false,
                    buttons: {"OK": function() {searchAvaibleMatchForm.submit(); $( this ).dialog( "close" );}}
                });

            } );*/

            $(document).ready(function() {
                $('#teamCompleteDialog').dialog({autoOpen:false,
                    resizable:false,
                    buttons: {"OK": function() {$( this ).dialog( "close" );}}
                });

                var length = $('#giocatoriInSquadraTable>tbody').children().length;

                if(length >= 5)
                    $('#teamCompleteDialog').dialog("open");

            });
        </script>

        <div id="teamCompleteDialog" title="Information!">
            the team is complete.
        </div>

        <form name="giocatoreInsert" action="teamRegister" method="post">
            <fieldset>
                <div class="row">
                    <div class="form-group">
                    <span class = "col-lg-2 col-md-2 col-sm-2 col-xs-2">
                        Team Name:
                    </span>
                        <div class = "col-lg-2 col-md-2 col-sm-2 col-xs-2">
                            <input  class="form-control" name="teamNameIn" type="text">
                        </div>
                    </div>
                </div>

                <ui-util:separator columnNumber="12"/>

                <div class="row">
                    <div class = "col-lg-6 col-md-6 col-sm-6 col-xs-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Giocatori disponibili</h3>
                            </div>
                            <div class="panel-body">
                                <table class="dataTableMarker">
                                    <thead>
                                    <tr>
                                        <td>First Name</td>
                                        <td>Last Name</td>
                                        <td>Join to team</td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${giocatoriDisponibili}" var="giocatore">
                                        <tr onclick="InSquadra('${giocatore.codiceFiscale}')">
                                            <td>${giocatore.nome}</td>
                                            <td>${giocatore.cognome}</td>
                                            <td style="text-align: center"> <button type="submit"> <img src="img/si.jpg"/>  </button> </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div class = "col-lg-6 col-md-6 col-sm-6 col-xs-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Giocatori in squadra</h3>
                            </div>
                            <div class="panel-body">
                                <table id="giocatoriInSquadraTable" class="dataTableMarker">
                                    <thead>
                                    <tr>
                                        <td>First Name</td>
                                        <td>Last Name</td>
                                        <td>Leaves the team</td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${giocatoriInSquadra}" var="giocatore">
                                        <tr onclick="FuoriSquadra('${giocatore.codiceFiscale}')">
                                            <td>${giocatore.nome}</td>
                                            <td>${giocatore.cognome}</td>
                                            <td style="text-align: center"> <button type="submit"> <img src="img/no.jpg"/> </button> </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class = "col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <hr/>
                        <input type="submit" value="submit" class="btn btn-default">
                    </div>
                </div>
            </fieldset>
        </form>
    </div>