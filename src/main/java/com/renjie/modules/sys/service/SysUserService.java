package com.renjie.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.renjie.modules.sys.entity.SysUser;

import java.util.List;

/**
 * @
 */
public interface SysUserService extends IService<SysUser> {

    SysUser queryByUserName(String username);

    /**
     * 查询用户的所有菜单ID
     * @param userId
     * @return
     */
    List<Long> queryAllMenuId(Long userId);
}
