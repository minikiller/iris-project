package com.liming.platform.admin.persist.openjpa;

import com.liming.platform.admin.api.dao.SearchException;
import org.apache.log4j.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 14-1-16.
 */
public class GenericDao<T, PK extends Serializable> implements com.liming.platform.admin.api.dao.GenericDao<T, PK> {
    protected final Logger log = Logger.getLogger(getClass());
    private Class<T> persistentClass;
    private EntityManager entityManager;

    public void setEntityManager (EntityManager em) {
        entityManager = em;
    }

    public GenericDao(){}
    /**
     * Constructor that takes in a class to see which type of entity to persist.
     * Use this constructor when subclassing.
     *
     * @param persistentClass the class type you'd like to persist
     */
    public GenericDao(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(persistentClass);
        Root<T> rootEntry = cq.from(persistentClass);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
   }

    @Override
    public List<T> getAllDistinct() {
        return null;
    }

    @Override
    public List<T> search(String searchTerm) throws SearchException {
        return null;
    }

    @Override
    public T get(PK id) {
        return entityManager.find(persistentClass,id);
    }

    @Override
    public boolean exists(PK id) {
        return false;
    }

    @Override
    public T save(T object) {
        entityManager.persist(object);
        entityManager.flush();
        return object;
    }

    @Override
    public void remove(T object) {
        entityManager.remove(object);
        entityManager.flush();
    }

    @Override
    public void remove(PK id) {
        Object object=entityManager.find(persistentClass,id);
        entityManager.remove(object);
        entityManager.flush();
    }

    @Override
    public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
        return null;
    }

    @Override
    public void reindex() {

    }

    @Override
    public void reindexAll(boolean async) {

    }
}
