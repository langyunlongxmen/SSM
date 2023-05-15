package com.example.SSM.test;

import com.example.SSM.mapper.UserMapper;
import com.example.SSM.pojo.User;
import com.example.SSM.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
//    @Test
//    public void testInsert() throws IOException {
//        //获取核心配置文件的输入流
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//        //获取SqlSessionFactoryBuilder对象
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        //获取SqlSessionFactory对象
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
//        //获取sql的会话对象SqlSession, 是MyBatis提供的操作数据库的对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //获取UserMapper的代理实现类对象
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        //调用mapper接口中的方法，实现添加用户信息的功能
//        int result = mapper.insertUser();
//        System.out.println("result: " + result);
//        //提交事务
//        sqlSession.commit();
//        sqlSession.close();
//    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername("admin");
        System.out.println(user);;
        sqlSession.close();
    }

    @Test
    public void testCheckLogIn(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogIn("admin", "12345");
        System.out.println(user);;
        sqlSession.close();
    }

    @Test
    public void testCheckLogInMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username","admin");
        map.put("password","12345");
        User user = mapper.checkLogInMap(map);
        System.out.println(user);;
        sqlSession.close();
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(2,"root","123456",33,"female","123@qq.com");
        mapper.insertUser(user);
        sqlSession.close();
    }

    @Test
    public void testCheckLogInByParam(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogInByParam("admin", "12345");
        System.out.println(user);;
        sqlSession.close();
    }
}
