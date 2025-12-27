package com.lecture.apnacollege.dsa2.queue;

public class CircularQueueY {

    static class Queue {
        int size;
        int[] arr;
        int rear = -1;
        int front = -1;

        Queue(int size) {
            arr = new int[size];
            this.size = size;
        }

        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public boolean isFull() {
            return ((rear + 1) % size) == front;
        }

        public void add(int data) {
            if (isFull()) {
                return;
            }
            if (front == -1)
                front = 0;
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public int remove() {
            if (isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            int result = arr[front];
            //single element arr
            if(front == rear ){
                rear = -1;
                front =-1;
            }else{
                front = (front+1)%size;
            }
            return result;
        }

        public int peek() {
            if (isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
      /*
       Circular queue using array
        add, remove and peek all is in O(1)

       */

        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q.remove());
        q.add(6);
        System.out.println(q.remove());
        q.add(7);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

    }
}
