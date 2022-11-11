package com.cn.nuodui;

import com.cn.nuodui.entity.Usertable;
import com.cn.nuodui.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class NuoduiApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() throws SQLException {
        dataSource.getConnection();
        System.out.println("数据库连接成功");
    }

    @Test
    void testMapper(){
        userMapper.deleteByPrimaryKey(5);
        System.out.println("99999");
    }

}
