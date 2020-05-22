package cn.stormtides.jedis.test;

import cn.stormtides.jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {

    @Test
    public void test1(){
        Jedis jedis=new Jedis("localhost",6379);
        jedis.set("username","zhangsan");

        jedis.close();
    }

    @Test
    public void test2(){
        Jedis jedis=new Jedis();
        jedis.set("username","zhangsan");
        String username = jedis.get("username");
        System.out.println(username);

        //可以使用setex()方法存储指定过期时间的key value
        jedis.setex("activeCode",20,"hhe");

        jedis.close();
    }

    @Test
    public void test3(){
        Jedis jedis=new Jedis();
        jedis.hset("user","name","lisi");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","male");

//        String name = jedis.hget("user", "name");
//        System.out.println(name);

        Map<String, String> user = jedis.hgetAll("user");
        System.out.println(user);

        Set<String> keyset = user.keySet();
        for (String key:keyset){
            String value = user.get(key);
            System.out.println(key+":"+value);
        }


        jedis.close();
    }

    @Test
    public void test4(){
        Jedis jedis=new Jedis();
        jedis.lpush("mylist","a1","b1","c1");
        jedis.rpush("mylist","a2","b2","c2");

        List<String> mylist1 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist1);

        String element1 = jedis.lpop("mylist");
        System.out.println(element1);

        String element2 = jedis.lpop("mylist");
        System.out.println(element2);

        List<String> mylist2 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist2);

        jedis.close();
    }

    @Test
    public void test5(){
        Jedis jedis=new Jedis();
        jedis.sadd("myset","java","php","c++");

        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);

        jedis.close();
    }

    @Test
    public void test6(){
        Jedis jedis=new Jedis();
        jedis.zadd("mysortedset",3,"亚瑟");
        jedis.zadd("mysortedset",1,"关羽");
        jedis.zadd("mysortedset",2,"后裔");

        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
        System.out.println(mysortedset);

        jedis.close();
    }

    @Test
    public void test7(){

        //建立配置文件
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);

        JedisPool jedisPool=new JedisPool(config,"localhost",6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("heheh","haha");
        jedis.close();
    }

    @Test
    public void test8(){

        Jedis jedis=JedisPoolUtils.getJedis();
        jedis.set("hello","world");
        jedis.close();
    }
}
