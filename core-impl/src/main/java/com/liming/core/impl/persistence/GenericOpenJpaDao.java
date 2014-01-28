package com.liming.core.impl.persistence;


import com.liming.core.api.exception.SearchException;
import com.liming.core.api.persistence.IGenericDao;
import com.liming.core.api.persistence.IPersistentEntity;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 14-1-16.
 */
public class GenericOpenJpaDao<T extends IPersistentEntity, PK extends Serializable> implements IGenericDao<T, PK> {
    protected final Logger log = Logger.getLogger(getClass());
    private Class<T> persistentClass;
    protected EntityManager entityManager;

    public void setEntityManager(EntityManager em) {
        entityManager = em;
    }

    public GenericOpenJpaDao() {
    }

    /**
     * Constructor that takes in a class to see which type of entity to persist.
     * Use this constructor when subclassing.
     *
     * @param persistentClass the class type you'd like to persist
     */
    public GenericOpenJpaDao(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Override
    public List<T> getAll(String className) {
        final Query query = entityManager.createQuery("select c from " + className + " c ");
        final List<T> resultList = query.getResultList();
        return resultList;
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
        return entityManager.find(persistentClass, id);
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
        Object object = entityManager.find(persistentClass, id);
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
