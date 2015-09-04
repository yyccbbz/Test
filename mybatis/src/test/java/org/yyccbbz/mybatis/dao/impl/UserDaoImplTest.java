package org.yyccbbz.mybatis.dao.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoImplTest {
    
    //spring 上下文对象
    private ApplicationContext ac;
    
    @Before
    public void setUp() throws Exception {
        // 读取spring配置文件,生成上下文对象
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void test() {
        fail("Not yet implemented");
    }

}
