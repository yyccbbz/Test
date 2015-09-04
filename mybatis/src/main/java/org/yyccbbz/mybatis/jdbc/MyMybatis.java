package org.yyccbbz.mybatis.jdbc;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyMybatis {

    public static void main(String[] args) throws Exception {
        // 读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 根据配置文件创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // sqlSession执行statement ,并返回结果映射
        sqlSession.selectOne("abc.findUserById", 1L);

    }

}
