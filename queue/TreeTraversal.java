package com.lecture.apnacollege.dsa2.queue;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

    public  void preOrder(MainBinaryTreeYT.Node root){
        //root, left, right
        if(root == null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public  void postOrder(MainBinaryTreeYT.Node root){
        //left, right, root
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public  void inOrder(MainBinaryTreeYT.Node root){
        //left, root,  right
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public void levelOrder(MainBinaryTreeYT.Node root){
        //Level order traversal
        if(root == null)
            return;
        Queue<MainBinaryTreeYT.Node > queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); // null is for printing the next line

       while (!queue.isEmpty()){
           MainBinaryTreeYT.Node curNode = queue.remove();

           if(curNode == null){
                System.out.println();
                if(queue.isEmpty())
                    break;
                else
                    queue.add(null);
           }else {
                System.out.print(curNode.data+" ");
                if(curNode.left!=null)
                    queue.add(curNode.left);
                if(curNode.right!=null)
                    queue.add(curNode.right);
           }
       }

    }
}
