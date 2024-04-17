package jvm;

/**
 * @ClassName: Math
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/4/12 13:43
 * @Version: V1.0
 */
public class Math {
    public static final int initData = 666;
//    public static User user = new User();
    private static int age = 1;

    private int age2 = 1;

    static {
        age = 2;
    }
    public int compute() {  //一个方法对应一块栈帧内存区域
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }
    public Math(){
        age2 = 2;
    }
    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
    }

}