package designpatten.decorator;

/**
 * @ClassName: BufferedInputStream
 * @Description: 装饰器类，对IInputStream的第2次装饰。
 *
 * @Author: xiahaitao
 * @Date: 2024/2/5 13:36
 * @Version: V1.0
 */
public class BufferedInputStream  implements IInputStream {

    private IInputStream inputStream;
    public BufferedInputStream(IInputStream inputStream){
        this.inputStream = inputStream;
    }
    @Override
    public String read() {
        System.out.println("装饰前");
        inputStream.read();
        System.out.println("装饰后");

        return "";
    }

    public static void main(String[] args) {
        IInputStream inputStream1 = new FileInputStream("asd");
        IInputStream inputStream2 = new BufferedInputStream(inputStream1);
        inputStream2.read();
    }
}
