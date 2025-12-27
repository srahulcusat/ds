package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        //ABCACDA k=2
        int left = 0, right=0 , result=0,maxF=0;
        Map<Character,Integer> map = new HashMap<>();
        int len = s.length();
        while(right < len){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxF = Math.max(maxF,map.get(ch));

            if((right-left+1)-maxF > k){
                char leftChar = s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                if(map.get(leftChar)==0)
                    map.remove(leftChar);
                left++;
            }

            result = Math.max(result,right-left+1);
            right++;
        }
        return result;
    }
    public static void main(String[] args) {

        /*
        You are given a string s and an integer k.
        You can choose any character of the string and change it to any other uppercase English character.
        You can perform this operation at most k times.
        Return the length of the longest substring containing the same letter you can get after performing the above operations.
        */
        String s = "ABAB";
        int k = 2;

        int result = characterReplacement(s,k);
    }
}
