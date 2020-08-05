package com.company.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {0, 8, 11, 0, -4, -5, 0};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        // pivot 中轴值
        int pivot = arr[(left+right) / 2];

        int temp;

        // 比pivot 小的放左边 大的放右边
        while (l < r) {
            // 从左边找到一个大于等于pivot的值
            while (arr[l] < pivot){
                l++;
            }

            // 从右边找到一个小于等于pivot的值
            while (arr[r] > pivot) {
                r--;
            }

            // pivot左边全是小于等于pivot 右边全是大于等于pivot
            if(l >= r) {
                break;
            }
            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if(arr[l] == pivot) {
                r--;
            }
            if(arr[r] == pivot) {
                l++;
            }
        }
        if(l == r) {
            l++;
            r--;
        }

        if(left < r) {
            quickSort(arr, left, r);
        }
        if(right > l) {
            quickSort(arr, l, right);
        }
    }
}
