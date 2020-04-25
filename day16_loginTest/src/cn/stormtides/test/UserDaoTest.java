package cn.stormtides.test;

import cn.stormtides.dao.UserDao;
import cn.stormtides.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin(){
        User loginuser=new User();
        loginuser.setUsername("superBaby");
        loginuser.setPassword("123");

        UserDao dao=new UserDao();
        User user=dao.login(loginuser);
        System.out.println(user);
    }
}
