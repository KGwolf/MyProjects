package designpatten.decorator;

/**
 * @ClassName: ICoffee
 * @Description: 输入流接口
 * 可能从文件里面获取输入流，可能从缓存的字节数据里面获取输入流
 * InputStream 抽象类
 *      ByteArrayInputStream       字节数组输入流，需要传入一个字节数组
 *      PipedInputStream
 *      FilterInputStream          过滤输入流，主要用于子类的重复代码提取
 *          BufferedInputStream         缓存输入流，可以重不同的输入流进行缓存（比如文件，字节数组）
 *          DataInputStream
 *      FileInputStream            文件输入流，需要传入一个文件地址
 *      ObjectInputStream
 * @Author: xiahaitao
 * @Date: 2024/2/4 16:16
 * @Version: V1.0
 */
public interface IInputStream {
    String read();
}
