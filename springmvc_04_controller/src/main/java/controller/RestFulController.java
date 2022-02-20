package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {

    //原来的访问地址：http://localhost:8080/springmvc_04_controller_war_exploded/add?a=1&b=2
    //RestFul的访问地址 : http://localhost:8080/springmvc_04_controller_war_exploded/add/1/5


    //当@RequestMapping中加了method方法后，限定了为DELETE方式请求后，其他的POST、PUT、GET都无法访问
    //详细见OneNode对应的章节
    //@RequestMapping(value="/add/{a}/{b}",method = RequestMethod.GET) 对应 @GetMapping(name="/add/{a}/{b}")
    //@RequestMapping(value="/add/{a}/{b}",method = RequestMethod.DELETE) 对应 @DeleteMapping(name="/add/{a}/{b}")
    //@RequestMapping(value="/add/{a}/{b}",method = RequestMethod.POST) 对应 @PostMapping(name="/add/{a}/{b}")
    //@RequestMapping(value="/add/{a}/{b}",method = RequestMethod.PUT) 对应 @PutMapping(name="/add/{a}/{b}")
    //@RequestMapping(value="/add/{a}/{b}",method = RequestMethod.HEAD) 对应

    @GetMapping("/add/{a}/{b}")   //这个是上面@RequestMapping的另一种写法
    public String test1(@PathVariable int a , @PathVariable int b , Model model){
        int res = a + b;
        model.addAttribute("msg","结果1为："+res);
        return "test";
    }


    @RequestMapping (value = "/add/{a}/{b}",method = RequestMethod.POST)
    public String test2(@PathVariable String a , @PathVariable String b , Model model){
        String res = a + b;
        model.addAttribute("msg","结果2为：" + res);
        return "test";
    }


}
