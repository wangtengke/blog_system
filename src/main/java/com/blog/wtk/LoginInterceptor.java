package com.blog.wtk;

import com.blog.wtk.Model.User_Info;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: wtk
 * @description: 登录拦截器，判断是否登录以及用户权限
 * @author: Mr.Wang
 * @create: 2018-08-04
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        User_Info user_info = (User_Info) request.getSession().getAttribute("User_Info");
        if(user_info != null) {
            System.out.println("session有数据");
            return true;
        }
        System.out.println("session没数据");
        request.setAttribute("msg","你还没登录");
       return true;

    }
}
