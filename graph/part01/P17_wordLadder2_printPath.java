package com.graph.part01;

import java.util.*;

public class P17_wordLadder2_printPath {

    /*
        Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find all shortest transformation sequence(s) from startWord to targetWord. You can return them in any order possible.
        Keep the following conditions in mind:

        A word can only consist of lowercase characters.
        Only one letter can be changed in each transformation.
        Each transformed word must exist in the wordList including the targetWord.
        startWord may or may not be part of the wordList.
        Return an empty list if there is no such transformation sequence.
    */
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {

        Set<String> st = new HashSet<>(Arrays.asList(wordList));

        Queue<ArrayList<String>> queue = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add(startWord);
        queue.add(list);

        int level = 0;
        ArrayList<String> usedLevel = new ArrayList<>();
        usedLevel.add(startWord);

        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        while (!queue.isEmpty()){
            ArrayList<String> qList = queue.poll();

            //erase all the work that has been use in previous transform
            if(qList.size()>level){
                level++;
                for(String at : usedLevel){
                    st.remove(at);

                }
                usedLevel.clear();
            }

            String word = qList.get(qList.size()-1);

            if(Objects.equals(word, targetWord)){
                if(ans.isEmpty())
                    ans.add(qList);
                else if(ans.get(0).size() == qList.size()){
                    ans.add(qList);
                }
            }
            char[] arr = word.toCharArray();
            for(int i =0;i<word.length();i++){
                char original = arr[i];
                for(char ch='a';ch<='z';ch++){
                    if(ch==original) continue;
                    arr[i] = ch;
                    String replacedWord = new String(arr);
                    if(st.contains(replacedWord)){
                        qList.add(replacedWord);

                        ArrayList<String> temp = new ArrayList<>(qList);
                        queue.add(temp);
                        usedLevel.add(replacedWord);
                        qList.remove(replacedWord);
                    }
                }
                arr[i] = original;
            }
        }

        return ans ;
    }



    /*
     Input:
        startWord = "der", targetWord = "dfs",
        wordList = {"des","der","dfr","dgt","dfs"}
    Output:
        der dfr dfs
        der des dfs
    Explanation:
        The length of the smallest transformation is 3.
        And the following are the only two ways to get
        to targetWord:-
        "der" -> "des" -> "dfs".
        "der" -> "dfr" -> "dfs".
    * */
}
