package com.xht.algorithm.sort;

public class PreSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

       int sumInt = preSum(arr,1,5);
        System.out.println(sumInt);
    }

    //前缀树，找数组的i 到 j 的和
    public static int preSum(int[] arr, int i, int j) {
        //边边脚脚的条件没写
        int[] arrPre = new int[arr.length];
        int sumPre = 0;
        for (int k = 0; k < arr.length; k++) {
            arrPre[k] = sumPre + arr[k];

            sumPre = arrPre[k];
        }

        return arrPre[j] - arrPre[i-1];
    }
}
