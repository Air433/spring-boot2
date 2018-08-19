package com.renjie.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.renjie.common.utils.PageUtils;
import com.renjie.modules.sys.entity.SysRole;

import java.util.Map;

/**
 * @Author oyg
 * @Date 2018/8/18/18:18
 */
public interface SysRoleService extends IService<SysRole> {
    PageUtils queryPage(Map<String, Object> params);

    void save(SysRole role);

    void deleteBatch(Long[] roleIds);
}
