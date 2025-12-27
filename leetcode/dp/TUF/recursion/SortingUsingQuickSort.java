package com.leetcode.dp.TUF.recursion;

public class SortingUsingQuickSort {


    public static void main(String[] args) {
        //Quick sort : time complexity is similar to merge sort but here not with any extra space


        /*
           A. Pick the pivot and place it to correct place to its sorted array;
            1.first element of array
            2.last element of array
            3.median of the array
            4.random element of array
           B.Smaller on the left and large on the right
        */
        int[] arr = {3, 1, 2, 7, 4, 9};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        for(int m:arr){
            System.out.print(m+" ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {

        if (left < right) {
            int partitionKey = quickSortArray(arr, left, right);
            quickSort(arr, left, partitionKey - 1);
            quickSort(arr, partitionKey + 1, right);
        }
    }

    public static int quickSortArray(int[] arr, int left, int right) {
        int i = left;
        int j = right;

        int pivot = arr[left];
        while (i < j) {
            while (arr[i] <= pivot && i <= right) {
                i++;
            }
            while (arr[j] > pivot && j > left) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[left] = arr[j];
        arr[j] = pivot;
        return j;
    }
}
