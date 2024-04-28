package jvm;

/**
 * @ClassName: HighCpu
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/4/28 16:50
 * @Version: V1.0
 */
public class HighCpu {
    public static final int initData = 666;
    public static User user = new User();

    public int compute() {  //一个方法对应一块栈帧内存区域
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        while (true){
            math.compute();
        }
    }
}
