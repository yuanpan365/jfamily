package com.yuanpan.jfamily.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yuanpan.jfamily.system.entity.RoleMenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.system.mapper
 * @Description: 角色与菜单对应关系
 * @date 2018/6/6 15:54
 */
@Mapper
public interface RoleMenuMapper extends BaseMapper<RoleMenuEntity> {

}
