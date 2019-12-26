package com.doing.web.controller.system;

import com.doing.common.core.controller.BaseController;
import com.doing.system.bean.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Effect
 * @Author doing
 * @Date 2019/12/26 15:53
 * @Version 0.0.1
 **/
@Controller
public class SysIndexController extends BaseController
{
//    @Autowired
//    private ISysMenuService menuService;

    @Value("${doing.version}")
    private String version;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap modelMap)
    {
        // 取身份信息
//        SysUser user = ShiroUtils.getSysUser();
//        // 根据用户id取出菜单
//        List<SysMenu> menus = menuService.selectMenusByUser(user);
//        mmap.put("menus", menus);
//        mmap.put("user", user);
//        mmap.put("copyrightYear", Global.getCopyrightYear());
//        mmap.put("demoEnabled", Global.isDemoEnabled());
       // modelMap.put("version", version);
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
//        mmap.put("version", Global.getVersion());
//        return "main";
        return "main_v2";
    }
}
