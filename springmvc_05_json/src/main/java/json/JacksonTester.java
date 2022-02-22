package json;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
Jackson使用测试
 */
public class JacksonTester {
    public static void main(String args[]){
        //第1步:创建ObjectMapper对象，它是一个可重用的对象
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";
        //map json to student
        try{
            //第2步:将JSON DeSerialize为Object，使用readValue（）方法从JSON获取Object。 将json字符串/源json字符串和对象类型作为参数传递。
            Student student = mapper.readValue(jsonString, Student.class);
            System.out.println(student);
            //第3步:将对象序列化为JSON，使用writeValueAsString（）方法获取对象的JSON字符串表示形式。
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
            System.out.println(jsonString);
        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }
}

/*
输出：
Student(name=Mahesh, age=21)
{
  "name" : "Mahesh",
  "age" : 21
}
 */