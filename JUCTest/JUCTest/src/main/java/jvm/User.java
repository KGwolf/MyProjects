package jvm;

import lombok.Data;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/4/17 17:00
 * @Version: V1.0
 */
@Data
public class User {
    private int id;

    private String name;
    public User() {
    }

    public User(int i, String toString) {
        id = i;
        name = toString;
    }
}
