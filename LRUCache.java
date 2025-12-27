package com.test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache <T> {

    private final int capacity;
    // hashMap for each key it will store the address of Node
    private final Map<String , Node> hashMap ; // to get the cache value in constant time
    private final DoubleLinkedList innerList ; // put the cache value in constant time
    private  int size ;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<>();
        innerList = new DoubleLinkedList();
        size  = 0;
    }

    public T get(String key ){
        Node currNode = hashMap.get(key);
        if(currNode == null){
            return null;
        }
        innerList.moveNodeToFront(currNode);
        return currNode.value;
    }

    public void put(String key , T value){
        Node currNode = hashMap.get(key);
        if(currNode != null) {
            currNode.value = value;
            innerList.moveNodeToFront(currNode);
            return;
        }

        if(size == capacity){
            hashMap.remove(innerList.getRearKey());
            innerList.removeFromRear();
            size--;
        }

        Node newNode = new Node(key,value);
        innerList.addNodeToFront(newNode);
        hashMap.put(key,newNode);
        size++;


    }

    private class Node{
        String key;
        T value;
        Node next;
        Node prev;

        Node(String key , T value){
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private class DoubleLinkedList{
         Node front ;
         Node rear ;

        DoubleLinkedList(){
            this.front = this.rear = null;
        }

        private void moveNodeToFront(Node node ){

            if(front == node){
                return ;
            }

            //detach the node
            if(node == rear){
                rear= rear.prev;
                rear.next = null;
            }else{
                node.prev.next = node.next;
                node.next.prev = node.prev ;
            }

            node.prev = null;
            node.next = front ;
            front.prev = node;
            front = node;

        }
        private void addNodeToFront(Node node){

            if(rear == null){
                front = rear = node;
                return ;
            }
            node.next = front;
            front.prev = node;
            front = node;

        }
        private void removeFromRear(){

            if(rear == null){
                return;
            }

            if(front == rear){
                front = rear = null;
            }else{
                rear = rear.prev;
                rear.next = null;
            }

        }
        private String getRearKey(){
            return rear.key;
        }
    }
}

