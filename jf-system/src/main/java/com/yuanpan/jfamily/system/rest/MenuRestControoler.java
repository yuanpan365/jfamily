package com.yuanpan.jfamily.system.rest;

import com.yuanpan.jfamily.common.page.Query;
import com.yuanpan.jfamily.system.entity.MenuEntity;
import com.yuanpan.jfamily.system.service.MenuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.system.rest
 * @Description: 菜单管理 前端控制器
 * @date 2018/6/6 15:27
 */
@RestController
@RequestMapping("/menu")
public class MenuRestControoler {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuEntity> list() {

        Query<MenuEntity> menuEntityQuery = new Query<>();

        return menuService.selectList(menuEntityQuery.getEntityWrapper());
    }



}
