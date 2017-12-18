package com.jigu.loan.interceptor;

import com.jigu.loan.entity.LoanAdmin;
import com.jigu.loan.entity.LoanFollower;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class SecurityInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String url = request.getRequestURI();
        if(url.indexOf("admin") > 0){
            Object admin_user = request.getSession().getAttribute("admin_user");
            if (admin_user == null || !(admin_user instanceof LoanAdmin)) {
                response.sendRedirect(request.getContextPath() + "/admin/user/login");
                return false;
            }
        }
        else if(url.indexOf("client") > 0){
            Object client = request.getSession().getAttribute("client_follower");
            if(client == null || !(client instanceof LoanFollower)){
//                response.sendRedirect(request.getContextPath() + "/client/user/login");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
