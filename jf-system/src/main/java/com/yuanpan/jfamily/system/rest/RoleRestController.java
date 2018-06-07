package com.yuanpan.jfamily.system.rest;

import com.yuanpan.jfamily.common.page.PageModel;
import com.yuanpan.jfamily.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.system.rest
 * @Description: 角色前端控制器
 * @date 2018/6/6 15:27
 */
@RestController
@RequestMapping("/role")
public class RoleRestController  {
	
	private String prefix="system/role/";
	@Autowired
	private RoleService roleService;



}
