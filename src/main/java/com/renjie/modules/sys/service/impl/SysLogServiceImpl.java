package com.renjie.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.renjie.common.annotation.TestAspect;
import com.renjie.modules.sys.dao.SysLogMapper;
import com.renjie.modules.sys.entity.SysLog;
import com.renjie.modules.sys.service.SysLogService;
import org.springframework.stereotype.Service;

/**
 * @Author oyg
 * @Date 2018/7/29/18:06
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @TestAspect("a")
    @Override
    public void m1() {
        System.err.println("------------我是m1方法，我a切面后执行---------");
    }

    @TestAspect("b")
    @Override
    public void m2() {
        System.err.println("------------我是m2方法，我b切面后执行---------");
    }

    @Override
    public void m3() {
        System.err.println("------------我是m3方法，无需要切面---------");
    }

    @TestAspect
    @Override
    public void m5() throws Exception {
        System.err.println("-----执行M5");
        if (1==1){
            throw new Exception("111111111111111111111");
        }
    }
}
