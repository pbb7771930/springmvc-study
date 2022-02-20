package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c3")
public class ControllerTest3 {

    //在类上也加了@RequestMapping后，浏览器访问test1的视图路径为 /c3/t1
    @RequestMapping("/t1")
    public String test1(Model model){
        model.addAttribute("msg","ControllerTest3,类上加@RequestMapping后访问的路径为/c3/t1");
        return "test";
    }
}
