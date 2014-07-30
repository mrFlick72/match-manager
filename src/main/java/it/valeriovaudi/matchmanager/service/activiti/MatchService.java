package it.valeriovaudi.matchmanager.service.activiti;


import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.model.Partita;

import java.util.List;

public interface MatchService {

  	 Partita find(String campo, String ora, String giorno, Giocatore principal);
     Partita joinInMatch(String footballField,String hour,String date,Giocatore principal);
     List<String> findReservedFootBallField(String hour, String date);
     Partita reservationMatch(String teamName,String date,String footballField,String hour);
}
