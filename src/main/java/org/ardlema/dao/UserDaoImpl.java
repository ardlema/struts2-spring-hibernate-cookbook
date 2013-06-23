package org.ardlema.dao;

import org.ardlema.model.User;

import java.util.List;

public class UserDaoImpl
        extends BaseHibernateDaoImpl<User>
        implements UserDao {


    public List<User> findAll(){
        return super.findAll();
    }

}
