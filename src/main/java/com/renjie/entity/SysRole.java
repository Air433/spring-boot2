package com.renjie.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Air on 2018/5/13.
 */
public class SysRole implements Serializable {

    private String role;

    private List<SysPermission> permissions;

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
