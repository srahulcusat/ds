package com.graph.part01;

import com.graph.common.Pair;

import java.util.*;

public class P16_wordLadder {

    /*
        Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find the length of the shortest transformation sequence from startWord to targetWord.
        Keep the following conditions in mind:

        A word can only consist of lowercase characters.
        Only one letter can be changed in each transformation.
        Each transformed word must exist in the wordList including the targetWord.
        startWord may 2t'
         or may not be part of the wordList

     */
    public int wordLadderLength(String startWord, String targetWord,
                                String[] wordList) {
        // Code here
        Set<String> words = new HashSet<>(Arrays.asList(wordList));
        if (!words.contains(targetWord))
            return 0;

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(startWord, 1));
        words.remove(startWord);

        while(!queue.isEmpty()){

            Pair<String, Integer> curr = queue.poll();
            String word = curr.first;
            int step = curr.second;

            if (word.equals(targetWord)) return step;

            char[] arr = word.toCharArray();
            for(int i =0;i<word.length();i++){
                char original = arr[i];
                for(char ch = 'a';ch<='z';ch++){
                    if (ch == original) continue;
                    arr[i] = ch;
                    String next = new String(arr);
                    if (words.contains(next)) {
                        words.remove(next);
                        queue.offer(new Pair<>(next, step + 1));
                    }
                }
                arr[i] = original;
            }
        }
        return 0;
    }
}
