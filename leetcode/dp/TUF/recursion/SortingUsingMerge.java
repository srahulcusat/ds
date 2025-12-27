package com.leetcode.dp.TUF.recursion;

public class SortingUsingMerge {

    public static void mergeArray(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;  //as n1 & n2 is length of arr we should not iterate till this index
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        /*
        Another way to copy the array to another array
        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr,mid+1,rightArray,0,n2);
        */
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int i = 0; i < n2; i++) {
            rightArray[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            k++;
            i++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }

    }

    public static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            mergeArray(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {

        //Merge sort is divide and conquer
        int[] arr = {3, 1, 2, 7, 4, 9};
        int n = arr.length;
        mergeSort(arr, 0, n - 1);

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
