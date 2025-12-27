package com.leetcode.dp.TUF.recursion;

public class Subsequence {

    public static  void printSubseq(int i,StringBuilder subseq,int[]arr,int n){

        if(i == n){
            System.out.println(subseq.toString());
            return ;
        }
        subseq.append(arr[i]);
        printSubseq(i+1,subseq,arr,n);
        subseq.deleteCharAt(subseq.length() - 1);
        printSubseq(i+1,subseq,arr,n);
    }

    public static void main(String[] args) {
       int[] arr = {3,2,1};
       int n =arr.length;
       StringBuilder str  = new StringBuilder();
       printSubseq(0,str,arr,n);
    }
    /*
                                                             0,"",{3,2,1},3
                                        1,"3",{3,2,1},3                                                  1,"",{3,2,1},3
                    2,"32",{3,2,1},3                 2,"3",{3,2,1},3                         2,"2",{3,2,1},3              2,"",{3,2,1},3
                                                                                3,"21",{3,2,1},3    3,"2",{3,2,1},3      3,"1",{3,2,1},3  3,"",{3,2,1},3
          3,"321",{3,2,1},3     3,"32",{3,2,1},3    3,"31",{3,2,1},3   3,"3",{3,2,1},3
     */




}
