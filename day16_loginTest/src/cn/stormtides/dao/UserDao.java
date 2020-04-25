package cn.stormtides.dao;

import cn.stormtides.domain.User;
import cn.stormtides.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据表中User表的类
 */
public class UserDao {

    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser
     * @return user
     */
    public User login(User loginUser){
        try{
            //编写sql
            String sql="select * from user where username= ? and password=?";
            //调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }

    }
}
