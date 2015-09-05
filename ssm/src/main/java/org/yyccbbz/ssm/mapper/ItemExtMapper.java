package org.yyccbbz.ssm.mapper;

import java.util.List;

import org.yyccbbz.ssm.pojo.Item;
import org.yyccbbz.ssm.pojo.ItemQueryVO;

public interface ItemExtMapper {
    
    /**
     * 根据查询条件查询商品列表
     * 
     * @return
     */
    public List<Item> findItemsByQueryVO(ItemQueryVO vo);
}
