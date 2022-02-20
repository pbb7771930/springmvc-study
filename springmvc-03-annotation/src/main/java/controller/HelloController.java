package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller注解会让spring自动装配该类
@Controller
public class HelloController {

    @RequestMapping("/hello") //
    public String hello(Model model){
        //向模型中添加属性msg与值，可以在jsp页面中取出并渲染
        model.addAttribute("msg","hello,springAnnotation");
        return "hello";//会被视图解析器处理,return返回的String就是要访问的一个视图名称；然后加上前缀和后缀。
    }
}
