package designpatten.decorator.filebio;

/**
 * @ClassName: MyInputStream
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/26 11:03
 * @Version: V1.0
 */
public abstract class MyInputStream {
    public void read() {
        System.out.println("从磁盘中读取文件");
    }
}
