package cn.stormtides.dao.impl;

import cn.stormtides.dao.ProvinceDao;
import cn.stormtides.domain.Province;
import cn.stormtides.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {

    //声明成员变量
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        String sql="select * from province";

        List<Province> list = template.query(sql, new BeanPropertyRowMapper<>(Province.class));

        return list;
    }
}
