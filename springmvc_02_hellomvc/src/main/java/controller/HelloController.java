package controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//继承Controller接口
public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        //ModelAndView 模型和视图
        ModelAndView mv=new ModelAndView();

        //业务代码
        String result="HelloSpringMVC";

        //封装对象，放在ModelAndView中
        mv.addObject("msg",result);

        //封装要跳转的视图，放在ModelAndView中。指向：/WEB-INF/jsp/hello.jsp
        mv.setViewName("hello");

        return mv;
    }
}
