package com.renjie.dao;

import com.renjie.domain.bizs.UserBiz;
import com.renjie.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author oyg
 * @since 2018-07-01
 */
public interface UserMapper extends BaseMapper<User> {
    UserBiz selectUserBiz(Long userId);
}
