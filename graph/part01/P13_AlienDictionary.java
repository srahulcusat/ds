package com.graph.part01;

import java.util.*;

public class P13_AlienDictionary {

    public String findOrder(String[] words) {

        int k =26;
        boolean[] present = new boolean[k];

        for(int i =0;i<words.length;i++){
            for(char ch:words[i].toCharArray()){
                present[ch-'a'] = true;
            }
        }
        int count =0;
        for(int i=0;i<k;i++){
            if(present[i])
                count++;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }


        //Constructed the adjacency list

        for (int i = 0; i < words.length - 1; i++) {

            String str1 = words[i];
            String str2 = words[i + 1];

            int len = Math.min(str1.length(), str2.length());
            if (str1.length() > str2.length() && str1.startsWith(str2)) {
                return "";
            }
            for (int j = 0; j < len; j++) {
                if (str1.charAt(j) != str2.charAt(j)) {
                    adj.get(str1.charAt(j) - 'a').add(str2.charAt(j) - 'a');
                    break;
                }
            }

        }

        //Find the topological order , if its equal to len ,it valid dictionary

        List<Integer> topoSort = topoSort(adj,present);
        StringBuilder result = new StringBuilder();
        for (int i : topoSort) {
            result.append((char)('a' + i));
        }
        if(result.length()!=count)
            return "";
        return result.toString();
    }

    private List<Integer> topoSort(ArrayList<ArrayList<Integer>> adj, boolean[] present) {
        //in-degree array ;
        int[] in_degree = new int[26];
        Arrays.fill(in_degree, 0);
        for (int i = 0; i < 26; i++) {
            for (int ad : adj.get(i)) {
                in_degree[ad]++;
            }
        }


        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            if (present[i] && in_degree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int ad : adj.get(node)) {
                in_degree[ad]--;
                if (in_degree[ad] == 0) {
                    q.add(ad);
                }
            }
        }
        return topo;
    }



}
