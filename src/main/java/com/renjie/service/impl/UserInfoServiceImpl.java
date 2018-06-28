package com.renjie.service.impl;

//import com.renjie.entity.SysPermission;
import com.renjie.entity.SysRole;
import com.renjie.entity.UserInfo;
import com.renjie.service.IUserInfoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Air on 2018/5/13.
 */
@Transactional
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    public UserInfo findByUsername(String username) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("air");
        userInfo.setPassword("2093ff5efdd13a3156944657d8b4c131");
        List<SysRole> roleList = new ArrayList<SysRole>();
        SysRole sysRole  = new SysRole();
//        sysRole.setRole("admin");
//
//        List<SysPermission> permissions = new ArrayList<SysPermission>();
//        SysPermission sysPermission = new SysPermission();
//        sysPermission.setPermission("user:edit");
//        permissions.add(sysPermission);
//        sysRole.setPermissions(permissions);

        roleList.add(sysRole);
        userInfo.setRoleList(roleList);
        return userInfo;
    }
}
