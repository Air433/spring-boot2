package com.renjie.modules.sys.dao;

import com.renjie.modules.sys.entity.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author oyg
 * @since 2018-07-15
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<String> queryAllPerms(Long userId);
}
