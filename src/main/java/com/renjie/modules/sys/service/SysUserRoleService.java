package com.renjie.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.renjie.modules.sys.entity.SysUserRole;

import java.util.List;

/**
 * @Author oyg
 * @Date 2018/8/5/21:25
 */
public interface SysUserRoleService extends IService<SysUserRole> {
    List<Long> queryRoleIdList(Long userId);

    int deleteBatch(Long[] roleIds);
}
