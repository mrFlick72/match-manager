<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div>
        <!--body div-->

            <script>

                $(document).ready(function() {
                    var searchAvaibleMatch = $('#searchAvaibleMatch');
                    var searchAvaibleMatchForm = searchAvaibleMatch.children('form').filter('form');

                    searchAvaibleMatch.dialog({
                        resizable:false,
                        buttons: {"OK": function() {searchAvaibleMatchForm.submit(); $( this ).dialog( "close" );}}
                    });

                } );

                $(document).ready(function() {
                    $('#teamCompleteDialog').dialog({autoOpen:false,
                        resizable:false,
                        buttons: {"OK": function() {$( this ).dialog( "close" );}}
                    });

                    $('#giocatoriDisponibiliTable').dataTable();

                    $('#giocatoriInSquadraTable').dataTable();

                    var length = $('#giocatoriInSquadraTable>tbody').children().length;

                    if(length >= 5)
                        $('#teamCompleteDialog').dialog("open");

                } );

            </script>

                <div id="teamCompleteDialog" title="Information!">
                    the team is complete.
                </div>

                <form name="giocatoreInsert" action="teamRegister" method="post">
                    <div class="grid_12 sfondo">

                        <table>
                            <tr>
                                <td>Team Name:</td>
                                <td><input name="teamNameIn" size="15" type="text"></td>
                            </tr>
                        </table>
                     </div>
                    <div class="clear"></div>

                    <div class="grid_12 alpha omega">
                        <hr/>
                    </div>
                    <div class="clear"></div>

                    <div class="grid_6 alpha sfondo">
                        <h1 class="title">Giocatori disponibili</h1>
                        <hr/>
                        <table id="giocatoriDisponibiliTable">
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

                    <div class="grid_6 omega sfondo">
                        <h1 class="title">Giocatori in squadra</h1>
                        <hr/>
                        <table id="giocatoriInSquadraTable">
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

                    <div class="clear"></div>

                    <div class="grid_12">
                        <hr/>
                        <input type="submit" value="submit">
                    </div>
                </form>
                    <div class="clear"></div>

        </div>