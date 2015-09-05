package org.yyccbbz.ssm.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yyccbbz.ssm.pojo.ItemQueryVO;

//spring整合junit
@RunWith(SpringJUnit4ClassRunner.class)
// spring 核心文件
@ContextConfiguration(locations = "classpath:applicationContext-service.xml")
public class ItemServiceImplTest {
    
    // 注入需要测试的对象
    @Autowired
    private ItemServiceImpl itemServiceImpl;
    
    @Test
    public void testFindItemsByQueryVO() {
        
        ItemQueryVO vo = null;
        itemServiceImpl.findItemsByQueryVO(vo);
    }

}
