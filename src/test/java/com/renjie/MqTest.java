package com.renjie;

import com.renjie.modules.sys.service.SysUserRoleService;
import com.renjie.modules.sys.service.SysUserService;
import net.sf.saxon.tree.linked.SystemIdMap;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author oyg
 * @Date 2018/10/4/09:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MqTest {

    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysUserService sysUserService;
    @Before
    public void init(){
        System.out.println("开始测试-----------------");

    }

    @After
    public void after(){
        System.out.println("开始测试-----------------");
    }


    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Test
    public void t1(){
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        //this.rabbitTemplate.convertAndSend("hello", context);
        List list = new ArrayList();
        //list.stream().filter(x-> String::equalsIgnoreCase);
    }

    @Test
    public void t2(){

    }

}
