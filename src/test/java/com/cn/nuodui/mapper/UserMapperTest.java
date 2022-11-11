package com.cn.nuodui.mapper;

import com.cn.nuodui.entity.Usertable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

   @Test
    void testMapper(){
       Usertable user = userMapper.selectByUname("test");
       System.out.println(user);
       List<Usertable> list = userMapper.listUser();
       for (Usertable usertable : list) {
           System.out.println(usertable);
       }
   }
}
