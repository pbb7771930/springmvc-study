package controller;

import pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
@RestController注解，相当于@Controller+@ResponseBody两个注解的结合。
@ResponseBody 表示该方法的返回结果直接写入 HTTP response body 中。
在使用 @RequestMapping后，返回值通常解析为跳转路径，但是加上 @ResponseBody 后返回结果不会被解析为跳转路径，
而是直接写入HTTP response body中。
 */
@RestController //不加载页面资源
public class AjaxController {

    @RequestMapping("/t1")
    public String test1() {

        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param=>" + name);
        if ("pbb".equals(name)) {
            response.getWriter().println("true");
        } else {
            response.getWriter().println("false");
        }

    }

    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> userList=new ArrayList<User>();
        User user1=new User("pbb",22,"男");
        User user2=new User("pbb1",23,"男");
        userList.add(user1);
        userList.add(user2);

        System.out.println("userList:"+userList);
        return userList;
    }

    /*
    用户密码验证
     */
    @RequestMapping("/a3")
    public String a3(String name,String pwd){
        String msg="";
        if(name != null){
            //admin用户和密码从数据库中获取,曾加一个mybatis查询
            if("admin".equals(name)){
                msg="ok";
            }else {
                msg="用户名错误";
            }
        }
        if(pwd != null){
            //admin用户和密码从数据库中获取,曾加一个mybatis查询
            if("123456".equals(pwd)){
                msg="ok";
            }else {
                msg="密码错误";
            }
        }
        return msg;
    }

}
