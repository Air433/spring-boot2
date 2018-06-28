package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色菜单表
 * </p>
 *
 * @author oyg
 * @since 2018-06-28
 */
@TableName("sys_role_authority")
public class SysRoleAuthority extends Model<SysRoleAuthority> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号自增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 菜单编码
     */
    @TableField("menu_code")
    private String menuCode;
    /**
     * 角色编码
     */
    @TableField("role_key")
    private String roleKey;
    /**
     * 菜单类型 1 导航 2 按钮
     */
    @TableField("menu_type")
    private Integer menuType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysRoleAuthority{" +
        "id=" + id +
        ", menuCode=" + menuCode +
        ", roleKey=" + roleKey +
        ", menuType=" + menuType +
        "}";
    }
}
