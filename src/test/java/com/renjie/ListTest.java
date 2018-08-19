package com.renjie;

import com.renjie.modules.sys.entity.SysRole;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author oyg
 * @Date 2018/8/19/12:21
 */
public class ListTest {

    @Test
    public void t1(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(5);

        SysRole role = new SysRole();
         SysRole sysRole = role;

        role = null;

        System.err.println(sysRole);
        System.err.println(role);
    }
}
