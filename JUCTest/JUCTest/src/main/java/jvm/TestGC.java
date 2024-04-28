package jvm;

/**
 * @ClassName: TestGC
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/4/28 15:54
 * @Version: V1.0
 */
public class TestGC {
    public static void main(String[] args) {
        TestGC gc = new TestGC();
      while (true){
          gc.m1();
      }
    }

    public void m1(){
        int a = 1;
        a++;
    }
}
