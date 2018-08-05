package com.renjie.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.renjie.modules.sys.dao.SysUserRoleMapper;
import com.renjie.modules.sys.entity.SysUserRole;
import com.renjie.modules.sys.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author oyg
 * @Date 2018/8/5/21:26
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
    @Override
    public List<Long> queryRoleIdList(Long userId) {
        return baseMapper.queryRoleIdList(userId);
    }
}
