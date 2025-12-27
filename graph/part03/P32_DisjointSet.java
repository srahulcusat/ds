package com.graph.part03;


import java.util.ArrayList;
import java.util.List;

/*
    Disjoint Set / Union-Find Data Structure
    A Disjoint Set Data Structure, also called Union-Find, is a data structure that keeps track of a
    set of elements that are partitioned into multiple non-overlapping (disjoint) subsets.

    This structure efficiently supports two main operations:
    Operation	Meaning
    Find(x)	Finds the representative (parent) of the set to which element x belongs
    Union(x, y)	Merges the two sets that contain x and y

    Helps solve problems where we need to detect whether:
    ✔ Two elements belong to the same group
    ✔ Adding an edge creates a cycle (graphs)


    We maintain two arrays:
    1️⃣ parent[] → stores the parent (leader) of each node
    2️⃣ rank[] or size[] → used to optimize merging


    Union(u,v)
    -> find ultimate parent of u & v i.e. pu, and pv
    -> find rank of pv & pv
    -> connect smaller rank to large rank
    rank[0,0,0,0,0]
    parent[1,2,3,4,5]

    findParent(u,v) -> path compression on every findParent function

    time : O(4 alpha) -> where alpha is constant
    */
public class P32_DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    P32_DisjointSet(int n ){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    //On every findParent we are trying to compression the parent list , so that it can be query in constant
    public int findParent(int node){
        if(node == parent.get(node)){
            return  node;
        }
        int ulP = findParent(parent.get(node));
        parent.set(node, ulP);
        return parent.get(node);
    }

    //Here we calculate the rank for each edge , it's like a growing graph
    public void unionByRank(int u , int v ){
        int ul_pu = findParent(u);
        int ul_pv = findParent(v);

        if(rank.get(ul_pu) < rank.get(ul_pv)){
            parent.set(ul_pu,ul_pv);
        }else if(rank.get(ul_pu) > rank.get(ul_pv)){
            parent.set(ul_pv,ul_pu);
        }else{
            parent.set(ul_pv,ul_pu);
            rank.set(ul_pu,rank.get(ul_pu)+1);
        }
    }

    public static void main(String[] args) {
        P32_DisjointSet ds = new P32_DisjointSet(7);
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);


        if(ds.findParent(3) == ds.findParent(7)){
            System.out.println("Same");
        }else {
            System.out.println("Not Same");
        }
        ds.unionByRank(3,7);
        if(ds.findParent(3) == ds.findParent(7)){
            System.out.println("Same");
        }else {
            System.out.println("Not Same");
        }
    }
}
