package com.xht.algorithm.sort;

/**
 * @ClassName: MathRandom
 * @Description: 从1-5随机 到1-7随机：f函数用Math来实现1-5随机，然后f1函数只能用f函数来实现1-7随机，不能在用其它的函数或者Math类了。
 * @Author: xiahaitao
 * @Date: 2025/6/16 16:58
 * @Version: V1.0
 */
public class MathRandom {

    public static void main(String[] args) {
        //首先看得到的数是什么范围，然后看概率
        System.out.println(getRandom());
        int[] arr = new int[10];
        int allCallTimes = 100000;
        int specialTimes = 0;
        for (int i = 0; i < allCallTimes; i++) {
            double random = getRandom();
            if (random <= 0.5){
                specialTimes++;
            }
        }
        System.out.println( (double)specialTimes/(double)allCallTimes);


        //测试 调用f2是否是等概率的返回0和1
//        int times = 1000000;
//        int arr[] = new int[2];
//        for (int i = 0; i < times; i++) {
//            int resI = f2();
//            arr[resI]++;
//        }
//        System.out.println("0的个数："+arr[0]);
    }


    public static double getRandom(){
        return Math.random();
    }


    /***
     * @param
     * @return int
     * @Description 生成 1- 5的随机数
     * @Author xiahaitao
     * @Date 2025/6/16 16:59
     */
    public static int f1() {
        return ((int) (Math.random() * 5)) + 1;
    }

    /***
     * @param
     * @return int
     * @Description 返回0、1等概率的值，需要写对数器来验证
     * @Author xiahaitao
     * @Date 2025/6/16 17:29
     */
    public static int f2() {
        int i = -1;
        do {
            i = f1();
        } while (i == 5);

        if (i == 1 || i == 2) {
            return 0;
        } else {
            return 1;
        }

    }
}
