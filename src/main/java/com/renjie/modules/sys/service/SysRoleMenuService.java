package com.renjie.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.renjie.modules.sys.entity.SysRoleMenu;

import java.util.List;

/**
 * @Author oyg
 * @Date 2018/7/29/21:02
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {


    List<Long> queryMenuIdList(Long roleId);

    void saveOrUpdate(Long roleId, List<Long> menuIdList);

    int deleteBatch(Long[] roleIds);
}
