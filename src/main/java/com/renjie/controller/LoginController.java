package com.renjie.controller;

import com.alibaba.fastjson.JSONObject;
import com.renjie.entity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Air on 2018/5/20.
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login")
    public String login(HttpEntity<UserInfo> httpEntity){
        UserInfo userInfo = httpEntity.getBody();
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword());

        try {
            subject.login(token);
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("msg", "登陆成功");
        }catch (IncorrectCredentialsException e){
            jsonObject.put("msg", "密码错误");
        }catch (LockedAccountException e){
            jsonObject.put("msg", "登陆失败，该用户已被冻结");
        }catch (AuthenticationException e){
            jsonObject.put("msg", "该用户不存在");
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject.toJSONString();
    }
}
