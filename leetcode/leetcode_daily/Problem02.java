package com.leetcode.leetcode_daily;

public class Problem02 {

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        int n1= nums1.length;
        int n2 = nums2.length;
        int i=0,j=0,k=0;

        int[][] result = new int[n1+n2][2];
        while(i<n1 && j <n2){

            if(nums1[i][0] == nums2[j][0]){
                result[k][0] = nums1[i][0];
                result[k][1] = nums1[i][1]+nums2[j][1];
                k++;
                i++;
                j++;
            }
            else if(nums1[i][0] > nums2[j][0]) {
                result[k][0] = nums2[j][0];
                result[k][1] = nums2[j][1];
                j++;
                k++;
            }else{
                result[k][0] = nums1[i][0];
                result[k][1] = nums1[i][1];
                i++;
                k++;
            }
        }

        while (i<n1){
            result[k][0] = nums1[i][0];
            result[k][1] = nums1[i][1];
            i++;
            k++;
        }

        while (j<n2){
            result[k][0] = nums2[j][0];
            result[k][1] = nums2[j][1];
            j++;
            k++;
        }

        int[][] arr = new int[k][2];

        for(int l =0;l<k;l++){
            arr[l][0] = result[l][0];
            arr[l][1] = result[l][1];
        }

        return arr;
    }

    public static void main(String[] args) {
       int[][] nums1 = {{1,2},{2,3},{4,5}};
       int[][] nums2 ={{1,4},{3,2},{4,1}};

       int[][] result = mergeArrays(nums1,nums2);
        for(int l =0;l<result.length;l++){
            System.out.println(result[l][0]+":"+result[l][1]);
        }
    }
}
