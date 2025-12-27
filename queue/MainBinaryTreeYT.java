package com.lecture.apnacollege.dsa2.queue;

public class MainBinaryTreeYT {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        private static int index = -1;

        public Node buildTree(int[] nodes) {
            index++;
            if (nodes[index] == -1)
                return null;
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static void main(String[] args) {
        int[] nodeData = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        /* Tree Creation:
                               1
                          2        3
                        4   5          6
        */

        //Create the tree
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree(nodeData);
        System.out.println(root.data);

        //Tree traversal
        TreeTraversal treeTraversal = new TreeTraversal();
        treeTraversal.preOrder(root);
        System.out.println();
        treeTraversal.postOrder(root);
        System.out.println();
        treeTraversal.inOrder(root);
        System.out.println();
        treeTraversal.levelOrder(root);

        //Kth level sum
        OtherTreeProblem otherTreeProblem = new OtherTreeProblem();
        System.out.println(otherTreeProblem.subAtLevel(root, 3));


    }
}
