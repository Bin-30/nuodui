package com.cn.nuodui.mapper;

import com.cn.nuodui.entity.Usertable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer ucode);

    int insert(Usertable record);

    int insertSelective(Usertable record);

    Usertable selectByPrimaryKey(Integer ucode);

    int updateByPrimaryKeySelective(Usertable record);

    int updateByPrimaryKey(Usertable record);


    Usertable selectByUname(String uname);

    List<Usertable> listUser();
}