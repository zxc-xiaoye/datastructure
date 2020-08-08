package com.company.sort;


import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9, 1, 1, 5, 2, -1, -1, 8, -4};
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }

    }
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int tempIndex = 0;
        while (l <= mid && r <= right) {
            if(arr[l] < arr[r]) {
                temp[tempIndex] = arr[l];
                l++;
                tempIndex++;
            } else {
                temp[tempIndex] = arr[r];
                r++;
                tempIndex++;
            }
        }
        // 左边有剩余
        if(l <= mid) {
            while (l <= mid) {
                temp[tempIndex] = arr[l];
                l++;
                tempIndex++;
            }
        }
        // 右边剩余
        if(r <= right) {
            while (r <= right) {
                temp[tempIndex] = arr[r];
                r++;
                tempIndex++;
            }
        }

        // 拷贝回原数组
        tempIndex = 0;
        for(int i = left; i <= right; i++){
            arr[i] = temp[tempIndex];
            tempIndex++;
        }
    }
}
