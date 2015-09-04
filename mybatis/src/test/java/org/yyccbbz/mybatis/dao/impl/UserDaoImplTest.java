package org.yyccbbz.mybatis.dao.impl;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.yyccbbz.mybatis.dao.UserDao;
import org.yyccbbz.mybatis.pojo.User;

public class UserDaoImplTest {

    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        // 读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 根据配置文件创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 初始化对象
        userDao = new UserDaoImpl(sqlSession);

    }

    @Test
    public void testFindUserById() {
        User user = this.userDao.findUserById(1L);
        System.out.println(user);
    }

    @Test
    public void testFindUserList() {
        List<User> list = this.userDao.findUserList();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setuserName("liudehua");
        user.setSex(1);
        user.setName("刘德华");
        user.setPassword("123");
        
        this.userDao.saveUser(user);
        
        
    }

    @Test
    public void testDeleteUserById() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateUser() {
        fail("Not yet implemented");
    }

}
