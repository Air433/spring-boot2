package com.renjie.modules.sys.dao;

import com.renjie.modules.sys.entity.SysMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 菜单管理 Mapper 接口
 * </p>
 *
 * @author oyg
 * @since 2018-07-15
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> queryListParentId(Long parentId);

    List<SysMenu> queryNotButtonList();

}
