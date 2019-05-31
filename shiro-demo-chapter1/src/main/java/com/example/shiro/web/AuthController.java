package com.example.shiro.web;

import com.example.shiro.utils.Response;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/5/16 16:50
 * @Version V1.0
 **/
@RestController
public class AuthController {
    @RequestMapping("/admin/get")
//    @RequiresRoles({"admin"})
//    @RequiresPermissions(value = {"admin:get"})
    public Response adminGet(){
        Response response = new Response();
        return response.buildSuccessResponse("admin有权限访问");
    }
    @RequestMapping("/vip/get")
//    @RequiresRoles(value = {"vip", "admin"}, logical = Logical.OR)
//    @RequiresPermissions(value = {"admin:get", "vip:get"}, logical = Logical.OR)
    public Response vipGet(){
        Response response = new Response();
        return response.buildSuccessResponse("vip优先权访问");
    }
    @RequestMapping("/user/get")
//    @RequiresRoles(value = {"user", "admin", "vip"}, logical = Logical.OR)
//    @RequiresPermissions(value = {"admin:get", "vip:get", "user:get"}, logical = Logical.OR)
    public Response userGet(){
        Response response = new Response();
        return response.buildSuccessResponse("普通用户,admin,vip有权限访问");
    }
}
