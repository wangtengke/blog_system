package com.blog.wtk.Controller;


import com.blog.wtk.Model.Article;
import com.blog.wtk.Model.Msg;
import com.blog.wtk.Model.Test;
import com.blog.wtk.Model.User_Info;
import com.blog.wtk.Service.ArticleServiceImpl;
import com.blog.wtk.Service.User_InfoService;
import com.blog.wtk.Service.User_InfoServiceImpl;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SpringBootApplication
public class LoginController {
    @Autowired
    User_InfoServiceImpl user_infoService;

    @Autowired
    ArticleServiceImpl articleService;
    @RequestMapping("/")
    public String index(Model model){
        List<Article> articles=articleService.getAll();
        model.addAttribute("articles",articles);
        return "index";
    }

    @RequestMapping("/Login")
    public String login(HttpServletRequest request,HttpSession session){
        User_Info user_info = (User_Info) request.getSession().getAttribute("User_Info");
        if(user_info != null) {
            System.out.println("session有数据,自动登录成功");
            return "index";
        }
        else {
            return "login";
        }
    }
    @RequestMapping(value = "/Index",method = {RequestMethod.POST,RequestMethod.GET})
    public String Index(User_Info user_info,HttpServletRequest request,HttpSession session){
        boolean is_same=user_infoService.User_Pass_Is_Same(user_info);
        if(is_same) {
            session.setAttribute("User_Info",user_info);
            System.out.println("登录成功");
            return "index";
        }
        else {
            System.out.println("登录失败");
            return "login";
        }
    }

    @RequestMapping(value = "/registered",method =  {RequestMethod.POST,RequestMethod.GET})
    public String registered(){
        return "registered";
    }

    @RequestMapping(value = "/do_registered",method =  {RequestMethod.POST,RequestMethod.GET})
    public String do_registered(User_Info user_info){
        boolean is_not_same =user_infoService.User_Is_Same(user_info);
        if(is_not_same){
            if(user_info.getRole()==null){
                user_info.setRole("user");
            }
            user_infoService.saveUser_Info(user_info);
            System.out.println("注册成功");
            return "index";
        }
        else {
            System.out.println("注册失败");
            return "registered";
        }
    }

}
