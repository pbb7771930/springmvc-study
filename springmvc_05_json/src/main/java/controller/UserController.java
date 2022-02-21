package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import pojo.User;
import utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@RestController//不会走视图解析器
@Controller//会走视图解析器
public class UserController {

    /*
    @responseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，
    写入到response对象的body区，通常用来返回JSON数据或者是XML数据。
    注意：在使用此注解之后不会再走视图处理器，而是直接将数据写入到输入流中，他的效果等同于通过response对象
    输出指定格式的数据。
     */
    @RequestMapping(value = "/j1")//produces = "application/json;charset=utf-8"//设置编码
    @ResponseBody//不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {
        //创建一个对象
        User user = new User("佳", 22, "男");
        //jackson ObjectMapper
        ObjectMapper mapper=new ObjectMapper();

        String str=mapper.writeValueAsString(user);

        return str;
    }

    @RequestMapping(value = "/j2")//produces = "application/json;charset=utf-8"//设置编码
    @ResponseBody//不会走视图解析器，会直接返回一个字符串
    public String json2() throws JsonProcessingException {
        //创建一个对象
        User user = new User("佳", 22, "男");
        User user2 = new User("佳", 22, "男");
        User user3 = new User("佳", 22, "男");
        User user4 = new User("佳", 22, "男");

        List<User> users=new ArrayList<User>();
        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        //jackson ObjectMapper
        ObjectMapper mapper=new ObjectMapper();

        String str=mapper.writeValueAsString(users);

        //return str;
        return JsonUtils.getJson(users);
    }

    @RequestMapping(value = "/j3")//produces = "application/json;charset=utf-8"//设置编码
    @ResponseBody//不会走视图解析器，会直接返回一个字符串
    public String json3() throws JsonProcessingException {
        //创建一个对象
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH-mm:ss");
        //jackson ObjectMapper
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        mapper.setDateFormat(sdf);
        String str=mapper.writeValueAsString(date);
        return str;
    }

    @RequestMapping(value = "/j4")//produces = "application/json;charset=utf-8"//设置编码
    @ResponseBody//不会走视图解析器，会直接返回一个字符串
    public String json4() throws JsonProcessingException {
        //创建一个对象
        Date date=new Date();
        User user=new User("黄",22,"男");
        return JsonUtils.getJson(user);
    }
}
