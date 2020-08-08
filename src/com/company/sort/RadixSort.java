package com.company.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {354, 32, 24, 388, 9854, 5742};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void radixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketEleCounts = new int[10];

        // 求最大数的长度
        int max = arr[0];
        for (int value : arr) {
            if(value > max) {
                max = value;
            }
        }
        int maxLength = (max + "").length();
        int digit;
        for(int i = 0; i < maxLength; i++){
            for (int j = 0; j < arr.length; j++) {
                digit = arr[j] / (int)Math.pow(10, i) % 10;
                bucket[digit][bucketEleCounts[digit]] = arr[j];
                bucketEleCounts[digit]++;
            }
            int index = 0;
            for (int k = 0; k < 10; k++){
                for(int j=0; j < bucketEleCounts[k]; j++){
                    arr[index] = bucket[k][j];
                    index++;
                }
                bucketEleCounts[k] = 0;
            }
        }
    }
}
