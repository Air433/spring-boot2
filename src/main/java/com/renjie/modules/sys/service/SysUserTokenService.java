package com.renjie.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.renjie.modules.sys.entity.SysUserToken;
import com.renjie.response.AirResult;

/**
 * @Author oyg
 * @Date 2018/7/21/16:46
 */
public interface SysUserTokenService extends IService<SysUserToken> {

    AirResult createToekn(long userId);

    void logout(Long userId);
}
