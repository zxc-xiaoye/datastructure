package com.company.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 5, 7, 1, 9, 8, 0, 4, -1};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 移位法（插入）
     * @param arr
     */
    public static void shellSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        int insertVal;
        int insertIndex;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                insertIndex = i;
                insertVal = arr[i];
                while (insertIndex - gap >= 0 && insertVal < arr[insertIndex - gap]){
                    arr[insertIndex] = arr[insertIndex-gap];
                    insertIndex -= gap;
                }
                if(insertIndex != i){
                    arr[insertIndex] = insertVal;
                }
            }
        }
    }


    /**
     * 交换法 性能较低(冒泡)
     * @param arr
     */
    public static void shellSort2(int[] arr) {
        if(arr == null || arr.length < 2){
            return;
        }
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中的所有元素 步长为gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    if(arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }
}
