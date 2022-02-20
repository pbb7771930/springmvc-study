package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.User;

@Controller
@RequestMapping("/user")
public class UserController {

    //http://localhost:8080/springmvc_04_controller_war_exploded/user/t1
    //@RequestParam("username")  其中 name为提交的域的名称，前端请求必须带上参数username
    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){
        //1、接收前端参数
        System.out.println("接收到前端的参数为" + name);
        //2、将返回的结果传递给前端
        model.addAttribute("msg" , name);
        //3、视图跳转到test
        return "test";
    }

    //前端接收的是一个对象：id name age
    /*
    1、接收前端用户传递的参数，判断参数的名字，假设名字直接在方法上，可以直接使用
    2、假设传递的是一个对象User，匹配User对象中的字段名；如果名字一致则OK，否则匹配不到
     */
    //http://localhost:8080/springmvc_04_controller_war_exploded/user/t2?name=huang&id=1&sex=男
    @GetMapping("/t2")
    public String test2(User user){
        System.out.println("接收到的对象参数：" + user);
        return "test";
    }


}
