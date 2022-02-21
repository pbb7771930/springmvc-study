package controller;

import pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController//不加载页面资源
public class AjaxController {

    @RequestMapping("/t1")
    public String test1() {

        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param=>" + name);
        if ("huang".equals(name)) {
            response.getWriter().println("true");
        } else {
            response.getWriter().println("false");
        }

    }

    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> userList=new ArrayList<User>();
        User user1=new User("黄",22,"男");
        User user2=new User("杨",22,"男");
        userList.add(user1);
        userList.add(user2);

        System.out.println("userList:"+userList);
        return userList;
    }

    @RequestMapping("/a3")
    public String a3(String name,String pwd){
        String msg="";
        if("admin".equals(name)){
            msg="ok";
        }else {
            msg="输入有误";
        }
        return msg;
    }

}
