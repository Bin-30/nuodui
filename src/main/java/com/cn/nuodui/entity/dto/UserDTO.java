package com.cn.nuodui.entity.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserDTO implements Serializable {
    /**
     * 名词
     */
    private String uname;

    /**
     * 密码
     */
    private String upwd;
}
