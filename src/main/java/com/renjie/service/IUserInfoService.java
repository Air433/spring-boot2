package com.renjie.service;

import com.renjie.entity.UserInfo;

/**
 * Created by Air on 2018/5/13.
 */
public interface IUserInfoService {
    UserInfo findByUsername(String username);
}
