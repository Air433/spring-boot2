package com.renjie.modules.sys.controller;

import com.renjie.common.annotation.SysLogAn;
import com.renjie.common.annotation.SysLogNotUser;
import com.renjie.common.validator.ValidatorUtils;
import com.renjie.common.validator.group.AddGroup;
import com.renjie.modules.sys.entity.SysUser;
import com.renjie.modules.sys.form.RegiserUserReq;
import com.renjie.modules.sys.request.SysLoginRequest;
import com.renjie.modules.sys.service.SysUserService;
import com.renjie.modules.sys.service.SysUserTokenService;
import com.renjie.response.AirResult;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author oyg
 * @Date 2018/7/21/12:52
 */
@RestController
public class SysLoginController extends AbstractController{

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserTokenService sysUserTokenService;

    @PostMapping("/sys/login")
    public AirResult login(@RequestBody SysLoginRequest request){
        if (request == null){
            return AirResult.error("请求信息为空，请检查");
        }

        if (request.getUsername() == null || request.getUsername().trim().equals("")){
            return AirResult.error("用户名不能为空");
        }
        SysUser user = sysUserService.queryByUserName(request.getUsername());

        if (user == null || !user.getPassword().equals(new Sha256Hash(request.getPassword(), user.getSalt()).toHex())){
            return AirResult.error("账号或密码不正确");
        }

        if (user.getStatus() == 0){
            return AirResult.error("账号已被锁定，请联系管理员");
        }

        AirResult result = sysUserTokenService.createToekn(user.getUserId());

        return result;
    }

    @PostMapping("/sys/logout")
    public AirResult logout(){
        sysUserTokenService.logout(getUserId());
        return AirResult.success("退出成功");
    }


    @SysLogNotUser("注册用户")
    @PostMapping("/sys/regier")
    public AirResult regiser(@RequestBody RegiserUserReq userReq){
        ValidatorUtils.validateEntity(userReq);

        sysUserService.save(userReq);

        return AirResult.success();
    }
}
