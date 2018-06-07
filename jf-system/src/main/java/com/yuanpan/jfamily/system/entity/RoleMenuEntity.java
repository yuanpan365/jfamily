package com.yuanpan.jfamily.system.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.system.entity
 * @Description: 角色与菜单对应关系
 * @date 2018/6/6 15:33
 */
@Data
@TableName("sys_role_menu")
public class RoleMenuEntity extends Model<RoleMenuEntity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 角色ID
     */
    @TableField("role_id")
    private Long roleId;
    /**
     * 菜单ID
     */
    @TableField("menu_id")
    private Long menuId;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}
