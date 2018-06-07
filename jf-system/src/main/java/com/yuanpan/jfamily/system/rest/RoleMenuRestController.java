package com.yuanpan.jfamily.system.rest;


import com.yuanpan.jfamily.system.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.system.rest
 * @Description: 角色与菜单对应关系 前端控制器
 * @date 2018/6/6 15:27
 */
@RestController
@RequestMapping("/role/roleMenu")
public class RoleMenuRestController {

	@Autowired
	private RoleMenuService roleMenuService;
	
	

	
}
