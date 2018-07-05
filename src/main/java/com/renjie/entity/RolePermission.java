package com.renjie.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色按钮权限表
 * </p>
 *
 * @author oyg
 * @since 2018-07-01
 */
@TableName("sys_role_permission")
public class RolePermission extends Model<RolePermission> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色主键编号
     */
    @TableField("role_id")
    private Integer roleId;
    /**
     * 按钮权限
     */
    private String permissions;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
        "roleId=" + roleId +
        ", permissions=" + permissions +
        "}";
    }
}
