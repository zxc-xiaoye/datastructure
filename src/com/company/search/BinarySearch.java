package com.company.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-1, -2, 1, 3, 5, 7, 9, 18, 25};
        int index = binarySearch(arr, 9, 0, arr.length - 1);
        System.out.println(index);

        int[] arr2 = {-1, -2, 3, 5, 10, 10, 10, 10, 15, 99, 198};
        List<Integer> indexs = binarySearch2(arr2, 10, 0, arr2.length - 1);
        System.out.println(indexs.toString());
    }

    /**
     * Find one and return
     */
    public static int binarySearch(int[] arr, int key, int left, int right) {
        if(left <= right) {
            int mid = (left + right) / 2;

            if(key < arr[mid]) {
                return binarySearch(arr, key, left, mid-1);
            } else if(key > arr[mid]) {
                return binarySearch(arr, key, mid+1, right);
            } else {
                return mid;
            }
        } else {
            System.out.println("Not Found");
            return -1;

        }

    }

    /**
     * Find all and return
     */
    public static List<Integer> binarySearch2(int[] arr, int key, int left, int right) {
        if(left <= right) {
            int mid = (left + right) / 2;

            if(key < arr[mid]) {
                return binarySearch2(arr, key, left, mid-1);
            } else if(key > arr[mid]) {
                return binarySearch2(arr, key, mid+1, right);
            } else {
                List<Integer> result = new ArrayList<>();
                result.add(mid);

                // forward left
                int temp = mid - 1;
                while (temp >= 0 && arr[temp] == key) {
                    result.add(temp);
                    temp--;
                }

                // forward right
                temp = mid + 1;
                while (temp < arr.length && arr[temp] == key) {
                    result.add(temp);
                    temp++;
                }

                return result;
            }
        } else {
            System.out.println("Not Found");
            return new ArrayList<>();

        }
    }
}
