package cn.eamon.enterprise.controller;

import cn.eamon.enterprise.domain.Permission;
import cn.eamon.enterprise.domain.Role;
import cn.eamon.enterprise.service.PermissionService;
import cn.eamon.enterprise.service.RoleService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/29 14:26
 */
@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 查看所有角色
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        List<Role> roleList = roleService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList", roleList);
        mv.setViewName("role-list");
        return mv;
    }

    /**
     * 保存所有角色
     */
    @RequestMapping("/save.do")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    /**
     * 根据用户ID查看其角色及权限
     */
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam("id") Integer roleId) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(roleId);
        List<Permission> permissionList = permissionService.findOtherPermission(roleId);
        mv.addObject("permissionList", permissionList);
        mv.addObject("role", role);
        mv.setViewName("role-permission-add");
        return mv;
    }

    /**
     * 为角色添加权限
     */
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId") Integer roleId,
                                      @RequestParam(name = "ids") int[] permissionIds) {
        roleService.addPermissionToRole(roleId, permissionIds);
        return "redirect:findAll.do";
    }

}
