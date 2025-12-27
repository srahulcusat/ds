package com.lecture.apnacollege.dsa2.queue;

public class QueueY {

   static class Queue {
        static int[] arr;
        static int size;
        static int rear = -1;

        Queue(int size) {
            this.size = size;
            arr = new int[size];
        }

        public  boolean isEmpty() {
            return rear == -1;
        }

        public    void add (int data){
            if(rear == size-1){
                System.out.println("Queue is full");
                return;
            }else{
                arr[++rear] = data;
            }
        }
        public  int remove (){
          if(rear == -1)
                return -1;
          int front = arr[0];
          for(int i =0;i<rear;i++){
              arr[i] =arr[i+1];
          }
          rear--;
          return  front;
        }

        public   int peek(){
            if(rear == -1)
                return -1;
            return  arr[0];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(3);
        q.add(2);
        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }

}
