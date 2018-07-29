package com.renjie.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.renjie.common.utils.PageUtils;
import com.renjie.modules.sys.dao.SysUserMapper;
import com.renjie.modules.sys.entity.SysUser;
import com.renjie.modules.sys.service.SysLogService;
import com.renjie.modules.sys.service.SysUserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        System.err.println("-------------进入"+this.getClass().getName()+"---------------");
        point.proceed();

    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String username = (String) params.get("username");

        return null;
    }
}
