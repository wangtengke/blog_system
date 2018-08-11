package com.blog.wtk.Service;

import com.blog.wtk.Model.Test;
import org.springframework.stereotype.Service;

@Service
public interface TestService {
    //添加
     Boolean add(Test test);

    Test select(Integer id);

    Test update(Test test);

    boolean delete(Integer id);
//     //修改
//     void update(Test test);
//     //查询
//     Test select(Test test);
//     //删除
//     String Delete(Test test);

}
