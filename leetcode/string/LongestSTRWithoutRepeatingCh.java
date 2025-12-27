package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSTRWithoutRepeatingCh {

    public static int lengthOfLongestSubstringMethod01(String s) {
        int left = 0, max=0 ;
        Map<Character,Integer> map = new HashMap<>();

        for (int right =0 ; right< s.length();right++){
            char curr = s.charAt(right);
            map.put(curr,map.getOrDefault(curr,0)+1);
            while(map.get(curr)>1){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar)-1);
                left++;
            }
            max = Math.max(max,right-left+1);
        }

        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0, max=0 ;
        Map<Character,Integer> map = new HashMap<>();

        for (int right =0 ; right< s.length();right++){
            char curr = s.charAt(right);
            if(map.containsKey(curr)){
                left = Math.max(left,map.get(curr)+1);
            }

            map.put(curr,right);
            max = Math.max(max,right-left+1);
        }

        return max;
    }
    public static void main(String[] args) {
        /*
            Given a string s, find the length of the longest substring
            without repeating characters.
        */
        String s = "abcabcbb";
        int  result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
