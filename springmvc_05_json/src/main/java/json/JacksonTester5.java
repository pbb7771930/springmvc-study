package json;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonMappingException;


public class JacksonTester5 {
    public static void main(String args[]){
        JacksonTester5 tester = new JacksonTester5();
        try {
            //JsonGenerator生成Json对象
            JsonFactory jsonFactory = new JsonFactory();
            JsonGenerator jsonGenerator = jsonFactory.createGenerator(new File("student.json"), JsonEncoding.UTF8);
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("name", "Mahesh Kumar");
            jsonGenerator.writeNumberField("age", 21);
            jsonGenerator.writeBooleanField("verified", false);
            jsonGenerator.writeFieldName("marks");
            jsonGenerator.writeStartArray(); // [
            jsonGenerator.writeNumber(100);
            jsonGenerator.writeNumber(90);
            jsonGenerator.writeNumber(85);
            jsonGenerator.writeEndArray();
            jsonGenerator.writeEndObject();
            jsonGenerator.close();
            /* student.json 对象如下：
            {
               "name":"Mahesh Kumar",
               "age":21,
               "verified":false,
               "marks":[100,90,85]
            }*/


            //使用JsonParser读取JSON
            JsonParser jsonParser = jsonFactory.createParser(new File("student.json"));
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                //get the current token
                String fieldname = jsonParser.getCurrentName();
                if ("name".equals(fieldname)) {
                    //move to next token
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getText()); //输出：Mahesh Kumar
                }
                if("age".equals(fieldname)){
                    //move to next token
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getNumberValue()); //输出：21
                }
                if("verified".equals(fieldname)){
                    //move to next token
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getBooleanValue()); //输出：false
                }
                if("marks".equals(fieldname)){
                    //move to [
                    jsonParser.nextToken();
                    // loop till token equal to "]"
                    while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                        System.out.println(jsonParser.getNumberValue()); //输出：100 90 85
                    }
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}