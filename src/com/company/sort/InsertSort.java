package com.company.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, -1, 0, -3};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        if(arr == null || arr.length < 2){
            return;
        }
        // 待插入的值
        int insertVal;
        int insertIndex;

        for(int i = 1; i < arr.length; i++){
            insertVal = arr[i];
            insertIndex = i - 1;
            while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
                // 往后移
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex != i -1) {
                arr[insertIndex+1] = insertVal;
            }
        }

    }
}
