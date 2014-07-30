package it.valeriovaudi.matchmanager.repository.dao.jpa;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.model.Partita;
import it.valeriovaudi.matchmanager.repository.dao.Interface.PartitaDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class PartitaDAOImpl extends AbstractDAO<Partita> implements PartitaDAO {

    public static final int FOOTBALL_FIELD_POSITION = 0;
    public static final int HOUR_POSITION = 1;

    public PartitaDAOImpl() {
        super("Partita.findAll");
    }

    @Override
    @Transactional(readOnly = true)
    public Partita findById(String footballField,String hour, Date date) {
    	
    	List<Partita> results = getEntityManager().createNamedQuery("Partita.findById")
                                                   .setParameter("giorno", date)
                                                   .setParameter("ora", hour)
                                                   .setParameter("campoId", footballField)
                                                   .getResultList();

    	return !results.isEmpty() ? results.get(0) : null;
     }

    @Override
    @Transactional(readOnly = true)
    public List<Partita> find(String campo, String ora, Date giorno) {

        return  getEntityManager().createNamedQuery("Partita.find")
				 .setParameter("campo",campo)
				 .setParameter("ora",ora)
				 .setParameter("giorno",giorno)
				 .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Partita find(String campo, String ora, Date giorno,Giocatore principal) {

        List<Partita> resultList = getEntityManager().createNamedQuery("Partita.findWithoutPrincipal")
                                                    .setParameter("campo", campo)
                                                    .setParameter("ora", ora)
                                                    .setParameter("giorno", giorno)
                                                    .setParameter("principal", principal)
                                                    .getResultList();

        return  !resultList.isEmpty() ? resultList.get(0) : null;
	}

    @Override
    @Transactional(readOnly = true)
    public List<String> findAvaibleMatch(Date giorno,String ora) {
        return  getEntityManager().createNamedQuery("Partita.findAvaibleMatch")
                .setParameter("giorno",giorno)
                .setParameter("ora",ora)
                .getResultList();
    }


    @Override
    @Transactional(readOnly = true)
    public List<Partita> findAllAvaiableMatch(Giocatore principal, Date date) {
        return  getEntityManager().createNamedQuery("Partita.findAllAvaiableMatch")
                .setParameter("date",date)
                .setParameter("principal", principal)
                .getResultList();
    }

    @Override
    public List<Partita> findAllMatchReserved(Giocatore principal, Date date) {
        return  getEntityManager().createNamedQuery("Partita.findAllMatchReserved")
                .setParameter("date",date)
                .setParameter("principal", principal)
                .getResultList();
    }

}
