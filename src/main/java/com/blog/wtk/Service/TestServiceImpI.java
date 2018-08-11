package com.blog.wtk.Service;

import com.blog.wtk.Mapper.TestMapper;
import com.blog.wtk.Model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TestService")
public class TestServiceImpI implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public Boolean add(Test test){
        int addmsg=testMapper.insertSelective(test);
        System.out.println(addmsg);
       return addmsg == 1;

    }

    @Override
    public Test select(Integer id) {
        return testMapper.selectByPrimaryKey(id);
    }

    @Override
    public Test update(Test test) {

        testMapper.updateByPrimaryKeySelective(test);

        return testMapper.selectByPrimaryKey(test.getId());
    }

    @Override
    public boolean delete(Integer id) {
        int deletemsg= testMapper.deleteByPrimaryKey(id);
        System.out.println(deletemsg);
        return deletemsg == 1;
    }
}
