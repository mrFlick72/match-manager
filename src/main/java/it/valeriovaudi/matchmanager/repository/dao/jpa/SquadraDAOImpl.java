package it.valeriovaudi.matchmanager.repository.dao.jpa;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.model.Squadra;
import it.valeriovaudi.matchmanager.repository.dao.Interface.SquadraDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Valerio
 * Date: 26/01/13
 * Time: 18.44
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Transactional
public class SquadraDAOImpl extends AbstractDAO<Squadra> implements SquadraDAO {

    public SquadraDAOImpl(){
        super("Squadra.findAll");
    }

    
    @Transactional(readOnly = true)
    public Squadra findByName(String name) {
    	
    	List<Squadra>  results = getEntityManager().createNamedQuery("Squadra.findByName").setParameter("nome", name).getResultList();

    	return !results.isEmpty() ? results.get(0) : null;
    }

    @Transactional(readOnly = true)
    public List<Squadra> findByReferente(Giocatore referente) {
        return   getEntityManager().createNamedQuery("Squadra.findByReferente").setParameter("referente", referente).getResultList();
    }
}
