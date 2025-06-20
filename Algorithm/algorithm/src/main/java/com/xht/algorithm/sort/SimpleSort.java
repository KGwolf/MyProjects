package com.xht.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName: ThreeSort
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/6/13 11:37
 * @Version: V1.0
 */
public class SimpleSort {
    public static void main(String[] args) {
//        int[] arr = {3, 2, 1, 5, 4};
//        print(arr);
        //选择排序
        //selectSort(arr);

        //bubbleSort(arr);

        //insertSort(arr);
        //使用对数器进行测试功能：
        //1.生成随机长度随机大小的数组。 2.深拷贝这个数组 3.使用自己的算法进行数组排序 4.使用系统自带的排序算法进行排序
        //5.判断2个数组是否相等（长度，每一位上面的数值）
        for (int i = 0; i < 10000; i++) {
            int[] ints = generateRandomArray(30, 200);
            int[] ints1 = deepCopyArray(ints);
            bubbleSort(ints);
            systemSort(ints1);
            if (!compareArray(ints, ints1)) {
                System.out.println("出错了");
                print(ints);
            }
        }
        System.out.println("验证通过");

//        print(ints);
    }

    /***
     * @param arr
     * @return void
     * @Description 选择排序
     * @Author xiahaitao
     * @Date 2025/6/13 11:41
     */
    public static void selectSort(int[] arr) {
        //边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        int arrLength = arr.length;

        for (int i = 0; i < arrLength; i++) {
            //变量来记录索引值
            int minValue = i;
            for (int j = i + 1; j < arrLength; j++) {
                if (arr[j] < arr[minValue]) {
                    minValue = j;
                }
            }
            //内层for循环结束之后，minValue就是最小值的索引值
            //这是一轮完了之后，需要交换最小值的位置的值  和  首个位置 的值
            swap(arr, i, minValue);
        }
    }

    /***
     * @param arr
     * @return void
     * @Description 冒泡排序
     * @Author xiahaitao
     * @Date 2025/6/13 13:48
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int arrLength = arr.length;

        for (int i = arrLength - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /***
     * @param arr
     * @return void
     * @Description 插入排序
     * @Author xiahaitao
     * @Date 2025/6/13 13:49
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int arrLength = arr.length;
        for (int i = 1; i < arrLength; i++) {
            //从后往前遍历交换
            for (int j = arrLength - 1; j >= i; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    /***
     * @param arr
     * @param i
     * @param j
     * @return void
     * @Description 交换数组中2个位置的元素
     * @Author xiahaitao
     * @Date 2025/6/19 10:47
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /***
     * @param arr
     * @return void
     * @Description 打印数组
     * @Author xiahaitao
     * @Date 2025/6/19 10:48
     */
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    /***
     * @param maxSize  数组的随机最大长度
     * @param maxValue 数组的随机最大值
     * @return int[]
     * @Description 对数器---生成一个随机数组
     * @Author xiahaitao
     * @Date 2025/6/17 10:04
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];

        for (int i = 0; i < arr.length; i++) {
            //生成包含负数的随机数
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /***
     * @param arr
     * @return int[]
     * @Description 深拷贝数组
     * @Author xiahaitao
     * @Date 2025/6/19 10:41
     */
    public static int[] deepCopyArray(int[] arr) {
        if (arr == null) {
            return new int[0];
        }
        int[] arrCopy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrCopy[i] = arr[i];
        }
        return arrCopy;
    }

    /***
     * @param arr
     * @return void
     * @Description 调用Arrays.sort 进行系统排序
     * @Author xiahaitao
     * @Date 2025/6/19 10:43
     */
    public static void systemSort(int[] arr) {
        Arrays.sort(arr);
    }

    /***
     * @param arr1
     * @param arr2
     * @return boolean
     * @Description 我们手动验证2个数组是否相等
     * @Author xiahaitao
     * @Date 2025/6/19 10:46
     */
    public static boolean compareArray(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}
