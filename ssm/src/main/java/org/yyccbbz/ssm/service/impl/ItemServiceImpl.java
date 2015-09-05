package org.yyccbbz.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yyccbbz.ssm.mapper.ItemExtMapper;
import org.yyccbbz.ssm.pojo.Item;
import org.yyccbbz.ssm.pojo.ItemQueryVO;
import org.yyccbbz.ssm.service.ItemService;


@Service
public class ItemServiceImpl implements ItemService {
    
    @Autowired
    private ItemExtMapper itemExtMapper;

    @Override
    public List<Item> findItemsByQueryVO(ItemQueryVO vo) {
        return itemExtMapper.findItemsByQueryVO(vo);
    }

}
