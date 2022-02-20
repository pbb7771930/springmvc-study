package controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*
第一种：类继承Controller写法;不推荐
 */
public class ControllerTest1 implements Controller {

    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse)
            throws Exception {

        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","ControllerTest1，使用继承Controller方式");
        mv.setViewName("test");

        return mv;
    }
}
