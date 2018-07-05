package com.renjie.dao;

import com.renjie.domain.bizs.RoleBiz;
import com.renjie.domain.bizs.UserBiz;
import com.renjie.entity.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author oyg
 * @since 2018-07-01
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<RoleBiz> selectByUserId(String userId);


}
