package com.renjie.modules.sys.controller;

import com.renjie.common.utils.Constant;
import com.renjie.common.utils.PageUtils;
import com.renjie.modules.sys.service.SysUserService;
import com.renjie.response.AirResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author oyg
 * @Date 2018/7/29/21:17
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController{

    @Autowired
    private SysUserService sysUserService;

    public AirResult list(@RequestParam Map<String, Object> params){
        //只有超级管理员可以查询所有管理员列表
        if (getUserId() != Constant.SUPER_ADMIN){
            params.put("createdUserId", getUser());
        }
        PageUtils page = sysUserService.queryPage(params);
        return null;
    }

}
