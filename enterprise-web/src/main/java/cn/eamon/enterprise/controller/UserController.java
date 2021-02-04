package cn.eamon.enterprise.controller;

import cn.eamon.enterprise.domain.Role;
import cn.eamon.enterprise.domain.UserInfo;
import cn.eamon.enterprise.service.RoleService;
import cn.eamon.enterprise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/28 20:28
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    /**
     * 查看所有用户
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        List<UserInfo> users = userService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList", users);
        mv.setViewName("user-list");
        return mv;
    }

    /**
     * 新增用户
     */
    @RequestMapping("/save.do")
    public String save(UserInfo user) {
        userService.save(user);
        return "redirect:findAll.do";
    }

    /**
     * 查看用户详情
     * @param id 必传 用户ID
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(value = "id") Integer id) throws Exception {
        UserInfo user =  userService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("user-show");
        return mv;
    }

    /**
     * 查看用户信息及角色信息
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(Integer id) throws Exception {
        UserInfo user = userService.findById(id);
        List<Role> roleList = roleService.findOtherRole(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.addObject("roleList", roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam("userId")Integer userId,
                                @RequestParam(name = "ids")int[] ids) {
        userService.addRoleToUser(userId, ids);
        return "redirect:findAll.do";
    }
}
