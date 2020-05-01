package cn.stormtides.test;

import cn.stormtides.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class jacksonTest {

    @Test
    public void test1() throws Exception {
        Person p=new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");

        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(p);
//        System.out.println(json);

//        mapper.writeValue(new File("f://a.txt"),p);

        mapper.writeValue(new FileWriter("f:b.txt"),p);
    }

    @Test
    public void test2() throws Exception {
        Person p=new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(p);
        System.out.println(s);
    }

    @Test
    public void test3() throws Exception {
        Person p1=new Person();
        p1.setName("张三");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2=new Person();
        p2.setName("李四");
        p2.setAge(25);
        p2.setGender("女");
        p2.setBirthday(new Date());

        Person p3=new Person();
        p3.setName("王五");
        p3.setAge(18);
        p3.setGender("男");
        p3.setBirthday(new Date());

        List<Person> ps=new ArrayList<>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(ps);
        System.out.println(s);
    }

    @Test
    public void test4() throws Exception {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("name","张三");
        map.put("age",23);
        map.put("gender","男");
//        map.put("birthday",new Date());

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(map);
        System.out.println(s);
    }

    @Test
    public void test5() throws Exception {
        String json="{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";

        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
    }

}
