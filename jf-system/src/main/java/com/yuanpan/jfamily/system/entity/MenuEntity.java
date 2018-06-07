package com.yuanpan.jfamily.system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.yuanpan.jfamily.common.page.PageModel;
import lombok.Data;

import java.util.Date;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.system.entity
 * @Description: 菜单管理
 * @date 2018/6/6 15:33
 */

@Data
@TableName("sys_menu")
public class MenuEntity extends PageModel {

    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;
    /**
     * 父菜单ID，一级菜单为0
     */
    @TableField("parent_id")
    private Long parentId;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单URL
     */
    private String url;
    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String perms;
    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Integer type;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 排序
     */
    @TableField("order_num")
    private Integer orderNum;
    /**
     * 创建时间
     */
    @TableField("crt_date")
    private Date crtDate;
    /**
     * 修改时间
     */
    @TableField("upt_date")
    private Date uptDate;
}
