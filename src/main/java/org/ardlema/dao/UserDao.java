package org.ardlema.dao;


import org.ardlema.model.User;

import java.util.List;

public interface UserDao extends BaseHibernateDao<User> {

    public List<User> findAll();

    public List<User> findUser(User user);
}
