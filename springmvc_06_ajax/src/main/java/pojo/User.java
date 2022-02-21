package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//关系到控制层返回list集合时能否正确显示
//@NoArgsConstructor
//@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String sex;

    public User() {
    }

    public User(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
