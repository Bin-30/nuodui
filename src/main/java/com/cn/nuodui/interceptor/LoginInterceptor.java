package com.cn.nuodui.interceptor;

import com.cn.nuodui.entity.Usertable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getRequestURI().contains("login")){
            return true;
        }
        HttpSession session = request.getSession();
        Usertable user = (Usertable) session.getAttribute("user");
        if (user==null){
            log.debug("未登录");
            response.sendRedirect("/loginx");
            return false;
        }
        log.debug("登录状态");
        return true;
    }
}
