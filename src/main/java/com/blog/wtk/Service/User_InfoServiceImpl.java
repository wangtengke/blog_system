package com.blog.wtk.Service;

import com.blog.wtk.Mapper.User_InfoMapper;
import com.blog.wtk.Model.User_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: wtk
 * @description: 保存用户注册的信息
 * @author: Mr.Wang
 * @create: 2018-08-03
 **/
@Service("User_InfoService")
public class User_InfoServiceImpl implements User_InfoService {
    @Autowired
    User_InfoMapper user_infoMapper;
    @Override
    public boolean saveUser_Info(User_Info user_info) {

        int userinfomsg=user_infoMapper.insertSelective(user_info);
        return userinfomsg == 1;
    }

    @Override
    public boolean User_Is_Same(User_Info user_info) {
        int count=user_infoMapper.selectAll(user_info);
        System.out.println(count);
        return count == 0;
    }

    public boolean User_Pass_Is_Same(User_Info user_info){
        int count = user_infoMapper.Username_Password_Is_Same(user_info);
        System.out.println(count);
        return count > 0 ;
    }
}
