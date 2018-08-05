package com.renjie.modules.sys.controller;

import com.renjie.common.annotation.SysLogAn;
import com.renjie.common.utils.Constant;
import com.renjie.common.utils.PageUtils;
import com.renjie.common.validator.Assert;
import com.renjie.common.validator.ValidatorUtils;
import com.renjie.common.validator.group.UpdateGroup;
import com.renjie.modules.sys.entity.SysUser;
import com.renjie.modules.sys.form.PasswordForm;
import com.renjie.modules.sys.service.SysUserRoleService;
import com.renjie.modules.sys.service.SysUserService;
import com.renjie.response.AirResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @GetMapping("/list")
    @RequiresPermissions("sys:user:list")
    public AirResult list(@RequestParam Map<String, Object> params){
        //只有超级管理员可以查询所有管理员列表
        if (getUserId() != Constant.SUPER_ADMIN){
            params.put("createdUserId", getUser());
        }
        PageUtils page = sysUserService.queryPage(params);
        Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        return AirResult.success(map);
    }

    @GetMapping("/info")
    public AirResult info(){
        Map<String,Object> map = new HashMap<>();
        map.put("user", getUser());
        return AirResult.success(map);
    }

    @SysLogAn("修改密码")
    @PostMapping("/password")
    public AirResult password(@RequestBody PasswordForm form){

        Assert.isBlank(form.getNewPassword(), "新密码不能为空");

        String password = new Sha256Hash(form.getPassword(), getUser().getSalt()).toHex();

        String newPassword = new Sha256Hash(form.getNewPassword(), getUser().getSalt()).toHex();

        boolean flag = sysUserService.updatePassword(getUserId(), password, newPassword);
        if (!flag){
            return AirResult.error("原密码不正确");
        }
        return AirResult.success();
    }

    @GetMapping("/info/{userId}")
    @RequiresPermissions("sys:user:info")
    public AirResult info(@PathVariable("userId") Long userId){
        SysUser user = sysUserService.selectById(userId);

        List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
        user.setRoleIdList(roleIdList);

        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        return AirResult.success(map);
    }

    @SysLogAn("修改用户")
    @PostMapping("/save")
    @RequiresPermissions("sys:user:save")
    public AirResult save(@RequestBody SysUser sysUser){
        ValidatorUtils.validateEntity(sysUser, UpdateGroup.class);

        sysUser.setCreateUserId(getUserId());
        sysUserService.update(sysUser);
    }
}
