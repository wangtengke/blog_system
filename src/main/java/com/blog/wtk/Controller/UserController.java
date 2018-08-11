package com.blog.wtk.Controller;

import com.blog.wtk.Model.Msg;
import com.blog.wtk.Model.Test;
import com.blog.wtk.Service.TestService;
import com.blog.wtk.Service.TestServiceImpI;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RestController注解能够使项目支持Rest
@RestController
@SpringBootApplication
//表示该controller类下所有的方法都公用的一级上下文根
@RequestMapping(value = "/springboot")
public class UserController {
    @Autowired
    TestServiceImpI testService;


    //这里使用@RequestMapping注解表示该方法对应的二级上下文路径
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String Hello(){
        return "Hello " ;
    }

    //添加数据
    /**
    * @Description: 添加数据
    * @Param: [test]
    * @return: com.blog.wtk.Model.Msg
    * @Author: Wtk
    * @Date: 2018/8/3
    */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Msg UserAdd(Test test){
        boolean isAdd=testService.add(test);
        if (isAdd) {
            return Msg.success().add("添加结果","添加成功");
        }
        else{
            return Msg.fail().add("添加结果","添加失败");
        }
    }

    //根据ID查询数据
    /**
    * @Description:  根据ID查询数据
    * @Param: [id]
    * @return: com.blog.wtk.Model.Msg
    * @Author: Wtk
    * @Date: 2018/8/3
    */
    @RequestMapping(value = "select" ,method = RequestMethod.POST)
    public Msg UserSelect(@Param(value = "id") Integer id){


        return Msg.success().add("查询结果",testService.select(id));
    }

    //修改数据
    /**
    * @Description: 修改数据
    * @Param: [test]
    * @return: com.blog.wtk.Model.Msg
    * @Author: Wtk
    * @Date: 2018/8/3
    */
    @RequestMapping(value = "update" ,method = RequestMethod.POST)
    public Msg UserUpdate(Test test){
        Test t=testService.update(test);
        return Msg.success().add("查询结果",t);
    }

    //删除数据
    /**
    * @Description:  删除数据
    * @Param: [id]
    * @return: com.blog.wtk.Model.Msg
    * @Author: Wtk
    * @Date: 2018/8/3
    */
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public Msg UserDelete(@Param(value = "id") Integer id){
        boolean deletemsg=testService.delete(id);
        if (deletemsg) {
            return Msg.success().add("删除结果", "删除成功");
        }
        else {
            return Msg.fail().add("删除结果", "删除失败");
        }
    }
}

