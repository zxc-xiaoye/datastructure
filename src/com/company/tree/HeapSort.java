package com.company.tree;

import java.util.Arrays;

/**
 * 堆排序
 * @author xiaoye
 * @create 2020-08-17 20:41
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 6, 5, -1, 9, 3, 11, -2, 55, 44};
        heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        // 1. 将arr调整为大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--){
            adjustHeap(arr, i, arr.length);
        }

        // 2. 将arr[0] 与 arr[j] 交换， 再调整
        int temp;
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j-1);
        }
    }


    /**
     *
     * @param arr 待调整的数组
     * @param i 表示非叶子结点在数组中的索引
     * @param length 表示对多少个元素调整
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        // k = i * 2 + 1  k为i的左结点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 判断左右结点大小
            if(arr[k] < arr[k+1]) {
                k++;
            }
            // 判断父子结点大小
            if(temp < arr[k]) {
                arr[i] = arr[k];
                i = k;
            }
        }
        arr[i] = temp;
    }
}
