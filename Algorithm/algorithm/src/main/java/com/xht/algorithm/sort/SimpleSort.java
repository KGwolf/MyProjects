package com.xht.algorithm.sort;

/**
 * @ClassName: ThreeSort
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/6/13 11:37
 * @Version: V1.0
 */
public class SimpleSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4};
        print(arr);
        //选择排序
        //selectSort(arr);

        bubbleSort(arr);
        print(arr);
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
        
        for (int i = arrLength -1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
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
            for (int j = i; j < arrLength; j++) {
                if (arr[j] < arr[j - 1]){
                    swap(arr, j, j-1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
