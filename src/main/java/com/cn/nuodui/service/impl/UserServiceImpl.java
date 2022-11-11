package com.cn.nuodui.service.impl;

import com.cn.nuodui.entity.Usertable;
import com.cn.nuodui.entity.dto.UserDTO;
import com.cn.nuodui.ex.ServiceException;
import com.cn.nuodui.mapper.UserMapper;
import com.cn.nuodui.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.server.ServerCloneException;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(Usertable record) {
        Usertable user = userMapper.selectByUname(record.getUname());
        if (user!=null){
            throw new ServiceException("用户名已存在",404);
        }
        if (record.getUtype()==null){
            record.setUtype(0);
        }
        int i = userMapper.insert(record);
        if (i!=1){
            throw new ServiceException("系统繁忙",500);
        }
    }

    @Override
    public Usertable login(UserDTO UserDTO) {
        Usertable user = userMapper.selectByUname(UserDTO.getUname());
        if (user!=null){
            if (user.getUpwd().equals(UserDTO.getUpwd())){
                log.info("登录成功");
                return user;
            }
            throw new ServiceException("密码错误",401);
        }
        throw new ServiceException("用户不存在",404);
    }

    @Override
    public List<Usertable> list() {
        List<Usertable> list = userMapper.listUser();
        return list;
    }

    @Override
    public void updateByCode(Usertable record) {
        int i = userMapper.updateByPrimaryKey(record);
        if (i!=1){
            throw new ServiceException("系统繁忙",500);
        }

    }

    @Override
    public Usertable selectByCode(Integer ucode) {
        Usertable user = userMapper.selectByPrimaryKey(ucode);
        if (user==null){
            throw new ServiceException("不存在该用户",404);
        }
        return user;
    }

    @Override
    public void deleteByCode(Integer ucode) {
        Usertable user = selectByCode(ucode);//通过上面的方法查询是否有该编号用户，不存在不允许删除
        //管理员不允许删除，防止某些技术手段之间删除管理员
        if (user.getUtype()==1){
            throw new ServiceException("不允许删除管理员",401);
        }
        int i = userMapper.deleteByPrimaryKey(ucode);
        if (i!=1){
            throw new ServiceException("系统繁忙",500);
        }
    }


}
