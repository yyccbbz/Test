package org.yyccbbz.ssm.service;

import java.util.List;

import org.yyccbbz.ssm.pojo.Item;
import org.yyccbbz.ssm.pojo.ItemQueryVO;

public interface ItemService {
    
    
    
    // 根据查询条件查询商品信息
    public List<Item> findItemsByQueryVO(ItemQueryVO vo);
}
