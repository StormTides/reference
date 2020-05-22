package cn.stormtides.service.impl;

import cn.stormtides.dao.ProvinceDao;
import cn.stormtides.dao.impl.ProvinceDaoImpl;
import cn.stormtides.domain.Province;
import cn.stormtides.jedis.util.JedisPoolUtils;
import cn.stormtides.service.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    //声明dao
    private ProvinceDao dao=new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    /**
     * 使用redis缓存
     * @return
     */
    @Override
    public String findAllJson() {
        Jedis jedis= JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");

        if (province_json==null || province_json.length()==0){
            System.out.println("redis没数据，查询数据库");
            List<Province> ps=dao.findAll();
            ObjectMapper mapper=new ObjectMapper();
            try {
                province_json=mapper.writeValueAsString(ps);
            } catch (Exception e) {
                e.printStackTrace();
            }
            jedis.set("province",province_json);
            jedis.close();
        }else {
            System.out.println("redis中有数据");
        }

        return province_json;
    }
}
