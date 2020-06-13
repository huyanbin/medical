package com.gxuwz.medical.controller;


import com.gxuwz.medical.domain.SysMenu;
import com.gxuwz.medical.domain.SysUser;
import com.gxuwz.medical.domain.VO.AjaxResult;
import com.gxuwz.medical.service.ISysMenuService;
import com.gxuwz.medical.service.ISysUserService;
import com.gxuwz.medical.utils.ServletUtils;
import com.gxuwz.medical.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * 登录验证
 * 
 * @author 麦奇
 */
@Controller
public class SysLoginController extends BaseController
{

    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response)
    {
        // 如果是Ajax请求，返回Json字符串。
        if (redisUtil.hasKey("sysUser"))
        {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }

        return "login";
    }

    @PostMapping("/login")
    public String ajaxLogin(String username, String password, ModelMap modelMap)
    {

        SysUser sysUser = iSysUserService.selectUserByLoginName(username);

        if (sysUser.getPassword().equals(password)) {

            //默认缓存30分钟
            redisUtil.set("sysName", sysUser.getUserName(), new Long(60*30));
            redisUtil.set("userId", sysUser.getUserId(), new Long(60*30));
            redisUtil.set("loginName", sysUser.getLoginName(), new Long(60*30));
            redisUtil.set("userName", sysUser.getUserName());
            // 根据用户id取出菜单
            List<SysMenu> menus = menuService.selectMenusByUser(sysUser);
            modelMap.put("menus", menus);

            return "/index";

        } else {
            return "/login";
        }

    }

    @GetMapping
    public String login() {
        return "/login";
    }

    @GetMapping("/unauth")
    public String unauth()
    {
        return "error/unauth";
    }


    @GetMapping("/main")
    public String main() {
        return "/main_v1";
    }


    @GetMapping("/theme")
    public String theme() {
        return "/skin";
    }

    @GetMapping("/monitor/operlog")
    public String operlog() {
        return "system/monitor/operlog/operlog";
    }
    @GetMapping("/monitor/logininfor")
    public String logininfor() {
        return "system/monitor/logininfor/logininfor";
    }
    @GetMapping("/loginOut")
    public String loginOut() {

        redisUtil.del("sysUser","userId");
        return "/login";
    }
}
