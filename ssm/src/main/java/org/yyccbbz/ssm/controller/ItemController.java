package org.yyccbbz.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yyccbbz.ssm.pojo.Item;
import org.yyccbbz.ssm.pojo.ItemQueryVO;
import org.yyccbbz.ssm.service.ItemService;


@Controller
public class ItemController {
    
    // 注入service
    @Autowired
    private ItemService itemService;
    
    
    /**
     * 根据条件查询商品信息
     * 
     * @return
     */
    @RequestMapping("/queryItems")
    public String queryItems(Model model){
        
        ItemQueryVO vo = null;
        List<Item> list = itemService.findItemsByQueryVO(vo );
        model.addAttribute("list", list);
        
        return "items/itemsList.jsp";
    }
    
}