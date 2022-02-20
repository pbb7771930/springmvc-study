package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
第二种：使用@Controller 注解方式
 */
//代表这个类会被spring接管，@Controller注解的类中所有的方法，如果返回值是String，并且有具体页面可以跳转，那么就会被解析
@Controller
public class ControllerTest2 {

    @RequestMapping("/t2")   // /t2表示浏览器访问的路径为：http://localhost:8080/xxxx/t2
    public String test1(Model model){
        model.addAttribute("msg","ControllerTest2,使用注解方式");
        return "test"; //寻找以下页面：/WEB-INF/jsp/test.jsp
    }
}
