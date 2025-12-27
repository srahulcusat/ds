package com.lecture.apnacollege.dsa2.stack;

import java.util.ArrayList;

public class StackUsingArrayList {


    static  class  Stack{
        ArrayList<Integer> arr = new ArrayList<>();

        public  boolean isEmpty(){
            return  arr.size()==0;
        }
        public  void push(int data){
            arr.add(data);
        }

        public  int pop(){
            return arr.remove(arr.size()-1);
        }

        public  int peek(){
            return  arr.get(arr.size()-1);
        }
    }

}
