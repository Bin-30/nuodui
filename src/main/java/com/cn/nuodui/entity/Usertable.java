package com.cn.nuodui.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NonNull;

/**
 * usertable
 * @author 
 */
@Data
public class Usertable implements Serializable {
    /**
     * 编号
     */
    private Integer ucode;

    /**
     * 名词
     */
    @NonNull
    private String uname;

    /**
     * 密码
     */
    @NonNull
    private String upwd;

    /**
     * 类型，0=普通，1=管理员
     */
    private Integer utype;

    /**
     * 备注
     */
    private String umemo;

    private static final long serialVersionUID = 1L;
}