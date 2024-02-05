package designpatten.decorator;

/**
 * @ClassName: FIleInputStream
 * @Description: FIleInputStream
 * 这个类只负责从磁盘读取数据。
 * 那后续可能会有其它功能，比如一次性读取文件后，缓存起来。相当于加了一个缓存的功能。
 * 作为被装饰的类
 * 装饰器模式 主要关注的是 对功能的加强！
 * @Author: xiahaitao
 * @Date: 2024/2/5 11:21
 * @Version: V1.0
 */
public class FileInputStream implements IInputStream {
    private String filePath;

    public FileInputStream(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String read() {
       //1.从磁盘读取文件。
        System.out.println("从磁盘读取文件");
        return null;
    }
}
