package com.example.shiro.web;

import com.example.shiro.utils.Response;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/5/16 14:24
 * @Version V1.0
 **/
@RestController
public class LoginController {

    @RequestMapping("/loginPage")
    public Response loginPage(){
        Response  response = new Response();
        return response.buildFailedResponse("请登录，再继续操作");
    }

    @RequestMapping("/login_success")
    public Response loginSuccess(){
        Response  response = new Response();
        return response.buildFailedResponse("登录成功");
    }

    @RequestMapping("/login_error")
    public Response loginError(){
        Response  response = new Response();
        return response.buildFailedResponse("登录失败");
    }
    @RequestMapping("/test")
    public Response test(){
        Response  response = new Response();
        return response.buildFailedResponse("不需要登录的请求");
    }

    @RequestMapping("/login")
    public Response login(HttpServletRequest request){
        Response  response = new Response();
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("账号不存在：");
                msg = "账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("密码不正确：");
                msg = "密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("验证码错误");
                msg = "验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }else{
            msg="请登录！";
            SecurityUtils.getSubject().logout();
        }
        // 此方法不处理登录成功,由shiro进行处理
        return response.buildFailedResponse(msg);
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return "成功注销！";
    }

    @RequestMapping("/403")
    public Response noAuth(){
        Response response = new Response();
        return response.buildFailedResponse("权限不足");
    }
}
