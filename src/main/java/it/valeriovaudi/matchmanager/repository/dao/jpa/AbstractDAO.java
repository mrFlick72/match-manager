package it.valeriovaudi.matchmanager.repository.dao.jpa;

import it.valeriovaudi.matchmanager.repository.dao.Interface.GenericDAO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Valerio
 * Date: 22/11/12
 * Time: 15.00
 * To change this template use File | Settings | File Templates.
 */

@Transactional
@Repository
public abstract class AbstractDAO<T>  implements GenericDAO<T> {

    @PersistenceContext
    private EntityManager entityManager;

    private String findAllQuery;

    private static Logger log = Logger.getLogger(AbstractDAO.class);
    
    public AbstractDAO(String findAllQuery) {
        this.findAllQuery = findAllQuery;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public static Logger getLog() {
        return log;
    }

    @Transactional(readOnly = true)
    public List<T> findALL() {
        return entityManager.createNamedQuery(findAllQuery).getResultList();
    }

    public final void update(T obj) {
        entityManager.merge(obj);
    }

    public final void remove(T obj) {
        entityManager.remove(obj);
    }

    public final void insert(T obj) {
        entityManager.persist(obj);
    }

    public void setFindAllQuery(String findAllQuery) {
        this.findAllQuery = findAllQuery;
    }
}
