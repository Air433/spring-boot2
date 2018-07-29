package com.renjie;

import com.renjie.modules.sys.entity.SysMenu;
import com.renjie.modules.sys.entity.SysUser;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @Author oyg
 * @Date 2018/7/25/22:04
 */
public class Test {

    @org.junit.Test



    public void t1(){
        Integer i = 1;
        System.err.println(i);
        con(i);
        System.err.println(i);
    }

    private void con(Integer i) {
        i = 3;
        System.err.println(i);
    }

    @org.junit.Test
    public void t2(){
        Integer i = 3;
        Consumer<Integer> consumer = x-> x = 5;
        consumer.accept(i);
        System.err.println(i);
    }

    @org.junit.Test
    public void t3(){
        SysUser userUser= new SysUser();
        userUser.setUsername("abc");
        Consumer<SysUser> consumer = x-> x.setUsername("苏杉杉");
        consumer.accept(userUser);
        System.err.println(userUser.getUsername());


    }

    @org.junit.Test
    public void t5() throws IllegalAccessException, InstantiationException {
        SysMenu sysMenu = SysMenu.class.newInstance();
    }
}
