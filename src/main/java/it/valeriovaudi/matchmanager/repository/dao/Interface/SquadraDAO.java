package it.valeriovaudi.matchmanager.repository.dao.Interface;


import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.model.Squadra;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Valerio
 * Date: 26/01/13
 * Time: 18.44
 * To change this template use File | Settings | File Templates.
 */
public interface SquadraDAO extends GenericDAO<Squadra> {

     Squadra findByName(String name);
     List<Squadra> findByReferente(Giocatore referente);

}
