package com.renjie.modules.sys.service.impl;

import com.renjie.common.utils.Constant;
import com.renjie.modules.sys.dao.SysMenuMapper;
import com.renjie.modules.sys.dao.SysUserMapper;
import com.renjie.modules.sys.dao.SysUserTokenMapper;
import com.renjie.modules.sys.entity.SysMenu;
import com.renjie.modules.sys.entity.SysUser;
import com.renjie.modules.sys.entity.SysUserToken;
import com.renjie.modules.sys.service.ShiroService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ShiroServiceImpl implements ShiroService {

    @Resource
    private SysMenuMapper sysMenuMapper;
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysUserTokenMapper sysUserTokenMapper;

    @Override
    public Set<String> getUserPermissions(long userId) {

        List<String> permsList;

        if (userId == Constant.SUPER_ADMIN){
            List<SysMenu> menuList = sysMenuMapper.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            menuList.forEach(x-> permsList.add(x.getPerms()));
        }else {
            permsList = sysUserMapper.queryAllPerms(userId);
        }

        Set<String> permsSet = new HashSet<>();

        //List<String> perms = permsList.stream().filter(x -> StringUtils.isNotBlank(x)).collect(Collectors.toList());
        for (String perms : permsList) {
            if (StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }

        return permsSet;
    }

    @Override
    public SysUserToken queryByToken(String token) {
        return sysUserTokenMapper.queryByToken(token);
    }

    @Override
    public SysUser queryUser(Long userId) {
        return sysUserMapper.selectById(userId);
    }
}
