package com.leetcode.dp;

public class SmallestStringFromDI {


    public static String smallestNumber1(String pattern) {

        int n = pattern.length();
        StringBuilder result = new StringBuilder();
        int[] stack = new int[n + 1];
        int index = 0;

        for (int i = 0; i <= n; i++) {
            stack[index++] = i + 1;
            if (i == n || pattern.charAt(i) == 'I') {
                while (index > 0) {
                    result.append(stack[--index]);
                }
            }
        }

        return result.toString();
    }


    public static String smallestNumber(String pattern) {
        int len = pattern.length();
        String result = "";
        int start = 1;
        int Dcounter = 0;

        for (int i = 0; i < pattern.length() ; i++) {
            String temp = "";
            if (pattern.charAt(i) == 'I') {
                if (Dcounter > 0) {
                    int k = i;
                    temp = start + temp;
                    start = start + 1;
                    while ( k >= 0 && pattern.charAt(--k) == 'D') {
                        temp = start + temp;
                        start++;
                        k--;
                    }
                    Dcounter = 0;
                    result = result + temp;
                } else {
                    result = result + start++;
                }

            }
            if (pattern.charAt(i) == 'D') {
                Dcounter++;
            }

        }

        String temp = "";
        if (Dcounter > 0) {
            int k = len - 1;
            while ( k>=0 && pattern.charAt(k) != 'I') {
                temp = start++ + temp;
                k--;
            }
            temp = start + temp;
        }
        result = result +temp;
        return result;

    }

    public static void main(String[] args) {
        String pattern = "IIIDIDDD";
        String result = smallestNumber(pattern);

        System.out.println(result);

    }
}
