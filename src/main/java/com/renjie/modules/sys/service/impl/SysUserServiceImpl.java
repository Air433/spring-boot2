package com.renjie.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.renjie.modules.sys.dao.SysUserMapper;
import com.renjie.modules.sys.entity.SysUser;
import com.renjie.modules.sys.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author oyg
 * @Date 2018/7/21/16:26
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public SysUser queryByUserName(String username) {
        return baseMapper.queryByUserName(username);
    }

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return null;
    }
}
