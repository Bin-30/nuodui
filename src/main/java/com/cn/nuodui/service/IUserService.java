package com.cn.nuodui.service;

import com.cn.nuodui.entity.Usertable;
import com.cn.nuodui.entity.dto.UserDTO;

import java.util.List;

public interface IUserService {

    void insert(Usertable record);

    Usertable login(UserDTO UserDTO);

    List<Usertable> list();

    void updateByCode(Usertable record);

    Usertable selectByCode(Integer ucode);

    void deleteByCode(Integer ucode);


}
