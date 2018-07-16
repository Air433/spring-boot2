package com.renjie.dao;

import com.renjie.domain.bizs.AuthorityBiz;
import com.renjie.entity.Authority;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author oyg
 * @since 2018-07-01
 */
public interface AuthorityMapper extends BaseMapper<Authority> {

    List<AuthorityBiz> selectByRoleId(String roleKey);
}
