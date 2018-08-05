package com.renjie.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.renjie.common.utils.Constant;
import com.renjie.common.utils.PageUtils;
import com.renjie.common.utils.Query;
import com.renjie.modules.sys.dao.SysUserMapper;
import com.renjie.modules.sys.entity.SysUser;
import com.renjie.modules.sys.service.SysLogService;
import com.renjie.modules.sys.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author oyg
 * @Date 2018/7/21/16:26
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysLogService sysLogService;

    @Override
    public SysUser queryByUserName(String username) {
        return baseMapper.queryByUserName(username);
    }

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return null;
    }

    @Override
    public void testAspect(ProceedingJoinPoint point) throws Throwable {
        System.err.println("-------------进入a的方法里---------------");
        point.proceed();

    }

    @Override
    public void testBspect(ProceedingJoinPoint point) throws Throwable {
        System.err.println("-------------进入b的方法里---------------");
        point.proceed();
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String username = (String) params.get("username");
        Long createUserId = (Long) params.get("createUserId");

        Page<SysUser> page = this.selectPage(
                new Query<SysUser>(params).getPage(),
                new EntityWrapper<SysUser>()
                        .like(StringUtils.isNotBlank(username), "username", username)
                        .eq(createUserId != null, "create_user_id", createUserId)
        );

        return new PageUtils(page);
    }

    @Override
    public boolean updatePassword(Long userId, String password, String newPassword) {
        SysUser sysUser = new SysUser();
        sysUser.setPassword(newPassword);
        return this.update(sysUser,
                new EntityWrapper<SysUser>().eq("user_id", userId).eq("password", password));
    }

    @Override
    @Transactional
    public void update(SysUser user) {
        if (StringUtils.isBlank(user.getPassword())){
            user.setPassword(null);
        }else {
            user.setPassword(new Sha256Hash(user.getPassword(), user.getSalt()).toHex());
        }
        this.updateById(user);

        //检查角色是否越权

    }

    private void checkRole(SysUser user){
        if (user.getRoleIdList() == null || user.getRoleIdList().size() == 0){
            return;
        }
        //如果不是超级管理员，则需要判断用户的角色是否自己创建
        if (user.getCreateUserId() == Constant.SUPER_ADMIN){
            return;
        }

    }
}
