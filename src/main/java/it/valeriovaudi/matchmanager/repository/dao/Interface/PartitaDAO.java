package it.valeriovaudi.matchmanager.repository.dao.Interface;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.model.Partita;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Valerio
 * Date: 26/01/13
 * Time: 18.41
 * To change this template use File | Settings | File Templates.
 */
public interface PartitaDAO extends GenericDAO<Partita> {

     Partita findById(String footballField,String hour, Date date);
     List<Partita> find(String campo, String ora, Date giorno);
     Partita find(String campo, String ora, Date giorno,Giocatore principal);
     List<String> findAvaibleMatch(Date giorno,String ora);
     List<Partita> findAllAvaiableMatch(Giocatore principal,Date date);
     List<Partita> findAllMatchReserved(Giocatore principal,Date date);
}
