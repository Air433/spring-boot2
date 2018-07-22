package com.renjie.modules.sys.controller;

import com.renjie.modules.sys.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author oyg
 * @Date 2018/7/21/12:53
 */
public abstract class AbstractController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected SysUser getUser(){
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected Long getUserId(){
        return getUser().getUserId();
    }
}
