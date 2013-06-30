package org.ardlema.dao;

import java.util.List;

public interface BaseHibernateDao<T> {

    public void setClazz(final Class<T> clazzToSet);

    //public T getById(final Long id);

    public List<T> findAll();

    //public List<T> findAll(int start, int resultSize);

    public void save(final T entity) throws Exception;

    //public void update(final T entity);

    //public void delete(final T entity);

    //public void deleteById(final Long entityId);

}
