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

    @TestAspect
    @Override
    public void testAspect() {
        System.err.println("------------"+this.getClass().getName()+"---------");
    }
}
