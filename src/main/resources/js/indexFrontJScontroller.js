  // funzioni di interesse per l'applicativo
  function InSquadra(codiceFiscale)
  {
      document.giocatoreInsert.method = "post";
      document.giocatoreInsert.action = "joinInTeam?codFiscale="+codiceFiscale;
      document.giocatoreInsert.submit();
  }

  function FuoriSquadra(codiceFiscale)
  {
      document.giocatoreInsert.method = "post";
      document.giocatoreInsert.action = "forkOutTeam?codFiscale="+codiceFiscale;
      document.giocatoreInsert.submit();
  }

  function prenotaPartita(teamName)
  {
//	  var registerMatchTable = $("#registerMatchTable > tbody > tr > td > input[type=checkbox]:checked");
	  var input = $("#registerMatchTable > tbody > tr:has(td > input[type=checkbox]:checked)").children();

      document.registerMatch.method = "post";
      document.registerMatch.action = "reservationMatch?teamName=" + teamName + "&footballField=" + input[2].innerHTML;
      document.registerMatch.submit();
  }

  function palyerJoinInMatch(date,hour,footBallField)
  {
      document.joinInMatch.method = "post";
      document.joinInMatch.action = "palyerJoinInMatch?date="+date+"&hour="+hour+"&footBallField="+footBallField;
      document.joinInMatch.submit();
  }

