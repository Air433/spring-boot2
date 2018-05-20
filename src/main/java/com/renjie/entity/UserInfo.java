package com.renjie.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Air on 2018/5/13.
 */
public class UserInfo  implements Serializable {
    private List<SysRole> roleList;
    private int state;

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public int getState() {
        return state;
    }
}
