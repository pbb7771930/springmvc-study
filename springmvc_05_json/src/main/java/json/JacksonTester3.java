package json;

import java.io.IOException;
import java.util.Iterator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
Json遍历树模型
 */
public class JacksonTester3 {
    public static void main(String args[]){
        try {
            //创建ObjectMapper对象
            ObjectMapper mapper = new ObjectMapper();
            //创建一个String树模型
            String jsonString = "{\"name\":\"Mahesh Kumar\",  \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";

            //生成树节点
            JsonNode rootNode = mapper.readTree(jsonString);

            //读取name节点
            JsonNode nameNode = rootNode.path("name");
            System.out.println("Name: "+ nameNode.textValue());

            //获取age节点
            JsonNode ageNode = rootNode.path("age");
            System.out.println("Age: " + ageNode.intValue());

            JsonNode verifiedNode = rootNode.path("verified");
            System.out.println("Verified: " + (verifiedNode.booleanValue() ? "Yes":"No"));

            //读取marks数组节点并遍历
            JsonNode marksNode = rootNode.path("marks");
            Iterator<JsonNode> iterator = marksNode.elements();
            System.out.print("Marks: [ ");
            while (iterator.hasNext()) {
                JsonNode marks = iterator.next();
                System.out.print(marks.intValue() + " ");
            }
            System.out.println("]");
        }
        catch (JsonParseException e) { e.printStackTrace(); }
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }
}