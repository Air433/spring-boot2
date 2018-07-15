package com.renjie.modules.sys.service;

import com.renjie.modules.sys.entity.SysUser;
import com.renjie.modules.sys.entity.SysUserToken;

import java.util.Set;

public interface ShiroService {

    Set<String> getUserPermissions(long userId);

    SysUserToken queryByToken(String token);

    SysUser queryUser(Long userId);
}
