package com.xht.algorithm.binarysearch;

/**
 * @ClassName: BinarySearchTest
 * @Description: 二分查找 相关测试
 * 查找一个具体的数值 是不是在一个有序的数组里面
 * 对数器如何生成顺序数组  生成随机数组--->调用Arrays.sort排序，调用我们自己的查找方法，比较的时候使用遍历看看真的在里面没有。
 * @Author: xiahaitao
 * @Date: 2025/6/19 11:33
 * @Version: V1.0
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8, 9, 10, 12};
        System.out.println(binarySearchIsExist(arr, 11));
    }

    /***
     * @param arr
     * @param target
     * @return boolean
     * @Description 二分查找 一个数 在不在一个顺序数组中。
     * @Author xiahaitao
     * @Date 2025/6/20 11:18
     */
    public static boolean binarySearchIsExist(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            //这里右移一位相当于就是除2
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == target) {
                return true;
            } else {
                //如果没找到，则缩小范围，处理left 和 right 的值
                if (arr[mid] > target) {
                    //那么就去左边找
                    right = mid - 1;
                } else {
                    //去右边找
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
