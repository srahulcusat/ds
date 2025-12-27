package com.lecture.apnacollege.dsa2.stack;

import java.util.LinkedList;

public class HashMapImpl {

    static class MyHashMap<K, V> {


        class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        LinkedList<Node> buckets[];

        private int N = 5;
        private int n = 0;

        MyHashMap() {
            buckets = new LinkedList[N];
            for (int i = 0; i < N; i++)
                buckets[i] = new LinkedList<>();
        }

        public void put(K key, V value) {
            int bi = getHashCode(key);
            int di = searchNode(bi, key);

            if (di == -1) {
                buckets[bi].add(new Node(key, value));
                n++;
            } else {
                buckets[bi].get(di).value = value;
            }

            int lamda = n / N;
            if (lamda > 2) {
                rehash();
            }

        }

        private void rehash() {

            LinkedList<Node> oldBuckets[] = buckets;

            buckets = new LinkedList[2 * N];

            for (int i = 0; i < 2 * N; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    put(ll.get(j).key, ll.get(j).value);
                }
            }

        }

        public V get(K key) {
            int bi = getHashCode(key);
            int di = searchNode(bi, key);
            if (di == -1)
                return null;
            return buckets[bi].get(di).value;
        }

        public K remove(K key) {
            int bi = getHashCode(key);
            int di = searchNode(bi, key);

            if (di == -1)
                return null;
            buckets[bi].remove(di);
            n--;
            return key;
        }

        public  int size(){
            return n;
        }

        private int searchNode(int bi, K key) {
            LinkedList<Node> temp = buckets[bi];

            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i).key == key)
                    return i;
            }
            return -1;
        }

        private int getHashCode(K key) {
            return Math.abs(key.hashCode()) % N;
        }


    }


    public static void main(String[] args) {
        MyHashMap<String , Integer > m = new MyHashMap<>();
        m.put("rahul",123);
        m.put("kumar",83);


        System.out.println(m.get("rahul"));
        m.remove("rahul");
        System.out.println(m.size());
    }
}
