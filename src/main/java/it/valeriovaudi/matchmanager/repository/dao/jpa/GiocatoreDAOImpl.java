package it.valeriovaudi.matchmanager.repository.dao.jpa;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.model.Squadra;
import it.valeriovaudi.matchmanager.repository.dao.Interface.GiocatoreDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Valerio
 * Date: 26/01/13
 * Time: 18.43
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Transactional
public class GiocatoreDAOImpl extends AbstractDAO<Giocatore> implements GiocatoreDAO {

    public GiocatoreDAOImpl() {
        super("Giocatore.findAll");
    }

    @Transactional(readOnly = true)
    public List<Squadra> squadreReferenziate(String codiceFiscale) {
        return  getEntityManager().createNamedQuery("Giocatore.findSquadreReferenziate").setParameter("codiceFiscale",codiceFiscale).getResultList();
    }

    @Transactional(readOnly = true)
    public Giocatore findByCodiceFiscale(String codiceFiscale) {
    	List<Giocatore>  results = getEntityManager().createNamedQuery("Giocatore.fingByCodiceFiscale").setParameter("codiceFiscale", codiceFiscale).getResultList();
       
    	return !results.isEmpty() ? results.get(0) : null;
    }
    @Transactional(readOnly = true)
    public Giocatore findByUserName(String userName) {
    	List<Giocatore>  results = getEntityManager().createNamedQuery("Giocatore.findByUserName").setParameter("userName", userName).getResultList();

    	return !results.isEmpty() ? results.get(0) : null;
    }
}
