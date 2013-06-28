package org.ardlema.dao;

import org.ardlema.model.User;
import org.hibernate.Query;

import java.util.List;

public class UserDaoImpl
        extends BaseHibernateDaoImpl<User>
        implements UserDao {


    public List<User> findAll(){
        return super.findAll();
    }

    public List<User> findUser(User user){
        String hql = "FROM User u WHERE u.userName = :userName AND u.password = :password";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("userName",user.getUserName());
        query.setParameter("password",user.getPassword());
        List results = query.list();
        return results;
    }

}
