package com.blog.wtk.Service;

import com.blog.wtk.Model.User_Info;

public interface User_InfoService {
    boolean saveUser_Info(User_Info user_info);
    boolean User_Is_Same(User_Info user_info);
    boolean User_Pass_Is_Same(User_Info user_info);
}
