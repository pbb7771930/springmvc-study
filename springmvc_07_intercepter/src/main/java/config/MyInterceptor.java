package config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器继承HandlerInterceptor接口
public class MyInterceptor implements HandlerInterceptor {

    //return true执行下一个拦截器，放行
    //return false不执行下一个拦截器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("+++++++++++拦截器处理前+++++++++");
        return true;
        //return false;   //执行完该拦截后，下面实际的业务逻辑就不再执行下去。
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("+++++++++++拦截器处理后+++++++++");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("+++++++++++拦截器清理+++++++++");
    }
}
