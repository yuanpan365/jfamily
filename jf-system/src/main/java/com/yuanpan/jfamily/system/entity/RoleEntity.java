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
 * @Description: 角色管理
 * @date 2018/6/6 15:33
 */
@Data
@TableName("sys_role")
public class RoleEntity extends PageModel {

    private static final long serialVersionUID = 1L;

    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 角色标识
     */
    @TableField("role_sign")
    private String roleSign;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建用户id
     */
    @TableField("create_id")
    private Long createId;

    @TableField("modified_id")
    private Long modifiedId;

    /**
     * 创建时间
     */
    @TableField("gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField("gmt_modified")
    private Date gmtModified;

}
