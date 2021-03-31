package com.dandanpili.arithmetic.search;

/**
 * @author shaoruilin
 * @create 2021-03-31-16:28
 */

//二分查找算法，注意点：会存在找不到的情况，找不到的情况就在循环外面返回 -1
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int result = binarySearch(arr, 5);
        System.out.println(result);
    }

    public static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < value) {
                left = mid + 1;
            } else if (arr[mid] > value) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
