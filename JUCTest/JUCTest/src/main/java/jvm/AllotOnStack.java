package jvm;

/**
 * @ClassName: AllotOnStack
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/4/17 17:00
 * @Version: V1.0
 */
public class AllotOnStack {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void alloc() {
        User user = new User();
        user.setId(1);
        user.setName("zhuge");
    }
}
