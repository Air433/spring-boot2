package com.renjie.modules.sys.controller;

import com.renjie.modules.sys.entity.SysMenu;
import com.renjie.modules.sys.service.ShiroService;
import com.renjie.modules.sys.service.SysMenuService;
import com.renjie.response.AirResult;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author oyg
 * @Date 2018/7/21/19:33
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends AbstractController{

    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private ShiroService shiroService;

    /**
     * 导航菜单
     * @return
     */
    @GetMapping("/nav")
    public AirResult nav(){
        List<SysMenu> menuList = sysMenuService.getUserMenuList(getUserId());
        Set<String> permissions = shiroService.getUserPermissions(getUserId());
        Map<String, Object> map = new HashMap<>();
        map.put("menuList", menuList);
        map.put("permissions", permissions);
        return AirResult.success(map);
    }
    /**
     * 菜单列表
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:menu:list")
    public List<SysMenu> list(){
        List<SysMenu> menuList = sysMenuService.selectList(null);
        menuList.forEach(x-> {
            SysMenu parentMenu = sysMenuService.selectById(x.getParentId());
            if (parentMenu != null){
                x.setParentName(parentMenu.getName());
            }
        });
        return menuList;
    }

    @GetMapping("/exception")
    public void ex(){
        if (1==1){
            throw new LockedAccountException("测试异常");
        }
    }
}
