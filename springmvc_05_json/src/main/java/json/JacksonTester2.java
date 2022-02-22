package json;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/*
Data Binding API用于使用属性访问器或使用注释将JSON转换为POJO（Plain Old Java Object）和从POJO（Plain Old Java Object）转换JSON。
它有两种类型。
Simple Data Binding - 将JSON转换为Java MAP，列表，字符串，数字，布尔值和空对象。
Full Data Binding - 将JSON转换为任何JAVA类型。
 */

public class JacksonTester2 {
    public static void main(String args[]){
        JacksonTester2 tester = new JacksonTester2();
        try {
            ObjectMapper mapper = new ObjectMapper();
            //使用map保存json数据
            Map<String,Object> studentDataMap = new HashMap<String,Object>();
            int[] marks = {1,2,3}; //数组
            Student student = new Student();
            student.setAge(18);
            student.setName("Mahesh");
            // map添加对象
            studentDataMap.put("student", student);
            // map添加字符串
            studentDataMap.put("name", "Mahesh Kumar");
            // map添加bool值
            studentDataMap.put("verified", Boolean.FALSE);
            // map添加List数组
            studentDataMap.put("marks", marks);

            //将studentDataMap 写入到 student.json 文件
            mapper.writeValue(new File("student.json"), studentDataMap);
/*            student.json 文件为：
            {
               "student":{"name":"Mahesh","age":18},
               "marks":[1,2,3],
               "verified":false,
               "name":"Mahesh Kumar"
            }
            */

            //读取json文件内容并输出
            studentDataMap = mapper.readValue(new File("student.json"), Map.class);
            System.out.println(studentDataMap.get("student"));
            System.out.println(studentDataMap.get("name"));
            System.out.println(studentDataMap.get("verified"));
            System.out.println(studentDataMap.get("marks"));
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
