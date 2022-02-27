package config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        //登陆页面放行

        //request.getRequestURI().contains("Login")
        //说明我在提交登录
        if(request.getRequestURI().contains("login")){
            return true;
        }
        if(session.getAttribute("userLoginInfo")!=null){
            return true;
        }

        //判断什么情况下没有登录
        if(session.getAttribute("userLoginInfo")==null){
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
            return false;
        }
        return true;
    }
}
