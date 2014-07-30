package it.valeriovaudi.matchmanager.repository.dao.Interface;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.model.Squadra;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Valerio
 * Date: 26/01/13
 * Time: 18.43
 * To change this template use File | Settings | File Templates.
 */
public interface GiocatoreDAO extends GenericDAO<Giocatore> {

     List<Squadra> squadreReferenziate(String codiceFiscale);
     Giocatore findByCodiceFiscale(String codiceFiscale);
     Giocatore findByUserName(String userName);

}
