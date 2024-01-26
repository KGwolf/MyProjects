package designpatten.singleton;

import lombok.Data;

/**
 * @ClassName: MySingletonEnum
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/23 13:15
 * @Version: V1.0
 */
public enum MySingletonEnum {
    INSTANCE;
    private String name;
    private int age;
}
