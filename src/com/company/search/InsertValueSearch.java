package com.company.search;

/**
 * @author xiaoye
 * @create 2020-08-09 16:39
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9, 11, 15, 20, 25};

        int index = insertValueSearch(arr, 0, arr.length - 1, 3);
        System.out.println(index);
    }

    public static int insertValueSearch(int[] arr, int left, int right, int key) {
        if(left > right || key < arr[left] || key > arr[right]) {
            return -1;
        }
        if(arr[right] == arr[left]) {
            if(key == arr[left]) {
                return left;
            } else {
                return -1;
            }
        }
        // important!!!
        int mid = left + (right - left) * (key - arr[left])/(arr[right] - arr[left]);
        int midVal = arr[mid];
        if(key < midVal) {
            // forward left
            return insertValueSearch(arr, left, mid - 1, key);
        } else if(key > midVal) {
            // forward right
            return insertValueSearch(arr, mid +1, right, key);
        } else {
            return mid;
        }
    }
}
