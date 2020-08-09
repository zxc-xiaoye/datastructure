package com.company.search;

import java.util.Arrays;

/**
 * @author xiaoye
 * @create 2020-08-09 17:05
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 8, 9, 25, 26, 29, 45, 66, 77};
        int i = fibSearch(arr, 10);
        System.out.println(i);
    }

    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        int mid = 0;
        int[] fib = fib(20);
        // 获取到斐波那契分割数值的下标
        while (high > fib[k] - 1) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr, fib[k]);
        for(int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high) {
            mid = low + fib[k - 1] - 1;
            if(key < temp[mid]) {

                high = mid - 1;
                // k-- ?
                // fib[k] = fib[k-1] + fib[k-2]
                // 前面有fib[k-1] 个元素 fib[k-1] = fib[k-2] + fib[k-3]
                // 下次循环 mid = f[k-1-1] - 1
                k--;
            } else if(key > temp[mid]) {
                // k-=2 ?
                // fib[k] = fib[k-1] + fib[k-2]
                // 后面有fib[k-2] 个元素 fib[k-2] = fib[k-3] + fib[k-4]
                // 下次循环 mid = fib[k-3] - 1 = fib[k - 2 - 1] - 1
                low = mid + 1;
                k -= 2;
            } else {
                if(mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }

    public static int[] fib(int maxSize) {
        if(maxSize < 1) {
            return null;
        }
        int[] arr = new int[maxSize];
        for (int i = 0; i < maxSize; i++){
            arr[i] = fibonacci(i);
        }
        return arr;
    }
    public static int fibonacci(int index) {
        if(index == 0) {
            return 1;
        } else if(index == 1) {
            return 1;
        } else {
            return fibonacci(index - 1) + fibonacci(index - 2);
        }
    }
}
