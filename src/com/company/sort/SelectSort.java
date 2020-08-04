package com.company.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, -1, 0, -3};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        if(arr == null || arr.length < 2){
            return;
        }
        int minIndex;
        int min;
        for (int i = 0; i < arr.length - 1; i++){
            minIndex = i;
            min = arr[i];
            for(int j = i+1; j < arr.length; j++){
                if(min > arr[j]){
                    minIndex = j;
                    min = arr[j];
                }
            }
            if(minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
