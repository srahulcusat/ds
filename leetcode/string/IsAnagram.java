package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {


    public static boolean isAnagramOptimalSol(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] freq=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        for(char c:t.toCharArray()){
            if(freq[c-'a']-- <= 0)
                    return false;
        }
        return true;
    }

    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;
        char[] s1 = s.toCharArray();
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();


        for(int i =0 ;i<s.length();i++){
            sMap.put(s.charAt(i),sMap.getOrDefault(s.charAt(i),0)+1);
        }
        int need = t.length();
        int have =0;

        for(int i =0 ;i<t.length();i++){
            char ch = t.charAt(i);
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
            if( sMap.containsKey(ch) && tMap.get(ch) <= sMap.get(ch))
                have++;

        }

        if(have == need)
            return true;
        return false;

    }

    public static void main(String[] args) {
        String s = "anagram" ;
        String t = "nagaram" ;

        boolean result = isAnagramOptimalSol(s,t);

        System.out.println(result);
    }
}
