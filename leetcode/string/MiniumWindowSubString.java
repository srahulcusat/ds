package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class MiniumWindowSubString {

    public static String minWindow(String s, String t) {
        if(s.length()<t.length())
            return "";

        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int left=0;
        int result = Integer.MAX_VALUE;

        for(int i=0 ;i<t.length();i++){
            window.put(t.charAt(i),0);
            target.put(t.charAt(i),target.getOrDefault(t.charAt(i),0)+1);
        }
        int need = t.length();
        int have = 0;
        int[] index = new int[2];
        index[0] =-1;
        index[1] =-1;

        for(int right = 0;right<s.length();right++){
            char ch = s.charAt(right);
            window.put(ch,window.getOrDefault(ch,0)+1);
            if(target.containsKey(ch) &&  window.get(ch) <= target.get(ch))
                have++;
            while(have==need){

                if((right-left+1) < result){
                    result = right-left +1;
                    index[0] = left;
                    index[1] = right;
                }
                char ch1 = s.charAt(left);
                window.put(ch1,window.getOrDefault(ch1,0)-1);
                if(target.containsKey(ch1) && window.get(ch1) < target.get(ch1))
                    have--;

                left++;
            }

        }

        if(index[0] >= 0 && index[1] >=0)
            return s.substring(index[0],index[1]+1);
        else{
            return "";
        }

    }
    public static void main(String[] args) {

        /*
        Given two strings s and t of lengths m and n respectively, return the minimum window
        substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
        The testcases will be generated such that the answer is unique.
        */
        String s = "ADOBECODEBANC";
        String t ="ABC";

        String result = minWindow(s,t);
        System.out.println(result);
    }
}
