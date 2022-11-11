package com.cn.nuodui.controller;

import com.cn.nuodui.entity.Usertable;
import com.cn.nuodui.entity.dto.UserDTO;
import com.cn.nuodui.ex.ServiceException;
import com.cn.nuodui.service.IUserService;
import com.cn.nuodui.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public JsonResult<Usertable> login(@RequestBody UserDTO userDTO, HttpSession session) {
        Usertable user = userService.login(userDTO);
        session.setAttribute("user", user);
        return JsonResult.ok(user);
    }

    @GetMapping("/list")
    public JsonResult<List<Usertable>> list(HttpSession session) {
        List<Usertable> list = userService.list();
        return JsonResult.ok(list);
    }

    @GetMapping("/current")
    public JsonResult<Usertable> getCurrentUser(HttpSession session) {
        Usertable user = (Usertable) session.getAttribute("user");
        return JsonResult.ok(user);
    }

    //提交修改
    @PostMapping("/update")
    public JsonResult<Void> update(@RequestBody Usertable record,HttpSession session) {
        Usertable user = (Usertable) session.getAttribute("user");
        //防止有用户通过技术手段，修改他人信息，必须是管理员或者是本人账号才能修改
        if (user.getUtype()==1||user.getUcode() == record.getUcode()){
            userService.updateByCode(record);
            return JsonResult.ok();
        }
        throw new ServiceException("不允许修改！",401);
    }

    //获取用户信息
    @GetMapping("/get/{ucode}")
    public JsonResult<Usertable> getByCode(@PathVariable Integer ucode) {
        Usertable user = userService.selectByCode(ucode);
        return JsonResult.ok(user);
    }


    @PostMapping("/delete/{ucode}")
    public JsonResult deleteByCode(@PathVariable Integer ucode,HttpSession session){
        Usertable user = (Usertable) session.getAttribute("user");
        if (user.getUtype()!=1){
            throw new ServiceException("没有权限",401);
        }
        userService.deleteByCode(ucode);
        return JsonResult.ok();
    }


    @PostMapping("/add")
    public JsonResult add(@RequestBody @Validated Usertable record, HttpSession session){
        Usertable user = (Usertable) session.getAttribute("user");
        if (user.getUtype()!=1){
            throw new ServiceException("没有权限",401);
        }
        userService.insert(record);
        return JsonResult.ok();
    }

}
