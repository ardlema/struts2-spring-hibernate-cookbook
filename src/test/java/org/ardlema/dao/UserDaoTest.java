package org.ardlema.dao;

import org.ardlema.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-dao-test.xml"})
public final class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testFindAllUsers() throws Exception {
        List<User> listOfUsers = userDao.findAll();
        assertThat(listOfUsers.size(), is(equalTo(3)));
    }

    @Test
    public void shouldFindUserWhenUserNameAndPasswordExistInDB() throws Exception {
        User user = new User("alberto","12345");
        List<User> listOfUsers = userDao.findUser(user);
        assertThat(listOfUsers.size(), is(equalTo(1)));
    }

    @Test
    public void shouldNotFindUserWhenUserNameDoesNotExistInDB() throws Exception {
        User user = new User("amparo","12345");
        List<User> listOfUsers = userDao.findUser(user);
        assertThat(listOfUsers.size(), is(equalTo(0)));
    }

    @Test
    public void shouldNotFindUserWhenPasswordDoesNotExistInDB() throws Exception {
        User user = new User("alberto","337438");
        List<User> listOfUsers = userDao.findUser(user);
        assertThat(listOfUsers.size(), is(equalTo(0)));
    }
}