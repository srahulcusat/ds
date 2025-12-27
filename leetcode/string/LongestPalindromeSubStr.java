package com.leetcode.string;

public class LongestPalindromeSubStr {

    public static String longestPalindrome(String s) {

        int resultLen = Integer.MIN_VALUE;
        String result = null;
        int count =0;
        for(int i =0;i<s.length();i++){

            //odd length palindrome
            int left = i ;
            int right = i;
            while (left>=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
                count++;
                if((right-left+1)> resultLen){
                    resultLen = right-left+1;
                    result = s.substring(left,right+1);
                }
                left-=1;
                right+=1;
            }

            //even length palindrome
            left  = i ;
            right = i+1;
            while (left>=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
                count++;
                if((right-left+1)> resultLen){
                    resultLen = right-left+1;
                    result = s.substring(left,right+1);
                }
                left-=1;
                right+=1;
            }
        }
        System.out.println(count);
        return result;
    }

    public static void main(String[] args) {

        /*
        Given a string s, return the longest palindromic substring in s.
        */
        String s = "babad";
        String result =  longestPalindrome(s);
        System.out.println(result);
    }
}
