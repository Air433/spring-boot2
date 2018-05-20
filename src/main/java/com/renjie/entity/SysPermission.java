package com.renjie.entity;

import java.io.Serializable;

/**
 * Created by Air on 2018/5/16.
 */
public class SysPermission  implements Serializable {
    private String permission;

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
