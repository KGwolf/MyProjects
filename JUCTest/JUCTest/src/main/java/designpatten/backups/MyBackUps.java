package designpatten.backups;

/**
 * @ClassName: MyBackUps
 * @Description: 这是需要保存快照的类
 * @Author: xiahaitao
 * @Date: 2024/2/2 11:27
 * @Version: V1.0
 */
public class MyBackUps {
    private String name;
    private int age;

    public MyBackUps getKuaiZhao(){
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
