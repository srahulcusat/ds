package com.leetcode.dp.TUF.recursion;

public class SubsequenceSum {

    public static  void printSubseq(int i,StringBuilder sb,int s ,int sum ,int[] arr,int n){

        if(i==n){
            if( s==sum)
                System.out.println(sb.toString());
            return;
        }
        sb.append(arr[i]);
        s=s+arr[i];
        printSubseq(i+1,sb,s,sum,arr,n);
        s=s-arr[i];
        sb.deleteCharAt(sb.length()-1);
        printSubseq(i+1,sb,s,sum,arr,n);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int n =arr.length;
        int s =0;
        int sum =2;
        StringBuilder sb  = new StringBuilder();
        printSubseq(0,sb,0,sum,arr,n);
    }
}
