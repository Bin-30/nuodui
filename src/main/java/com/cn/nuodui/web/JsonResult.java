package com.cn.nuodui.web;

import com.cn.nuodui.ex.ServiceException;
import lombok.Data;

import java.io.Serializable;
@Data
public class JsonResult<T> implements Serializable {
    private Integer state;
    private T data;
    private String message;

    public static JsonResult ok(){
        return ok(null);
    }

    public static <T> JsonResult<T> ok(T data){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(data);
        jsonResult.setState(200);
        return jsonResult;
    }

    public static JsonResult fail(ServiceException e){
        return JsonResult.fail(e.getMessage(),e.getState());
    }
    public static JsonResult fail(String message, Integer state){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setState(state);
        jsonResult.setMessage(message);
        return jsonResult;
    }
}
