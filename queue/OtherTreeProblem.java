package com.lecture.apnacollege.dsa2.queue;

import java.util.LinkedList;
import java.util.Queue;

public class OtherTreeProblem {

    public int countNode(MainBinaryTreeYT.Node root) {

        if (root == null)
            return 0;
        return 1 + countNode(root.left) + countNode(root.right);
    }

    public int sumOfNode(MainBinaryTreeYT.Node root) {

        if (root == null)
            return 0;
        int leftSum = sumOfNode(root.left);
        int rightSum = sumOfNode(root.right);
        return root.data + leftSum + rightSum;
    }

    public int heightOfTree(MainBinaryTreeYT.Node root) {

        if (root == null)
            return 0;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int diameterOfTree(MainBinaryTreeYT.Node root) {
        /*
            Number of nodes in the longest path between two nodes
            Case 01: Diameter through the root node
            Case 02: Diameter not through the root node

        */
        if (root == null)
            return 0;
        int diam1 = diameterOfTree(root.left);
        int diam2 = diameterOfTree(root.right);
        int diam3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;

        return Math.max(diam3, Math.max(diam1, diam2));

    }

    static class TreeInfo {
        int ht;
        int dia;

        TreeInfo(int ht, int dia) {
            this.ht = ht;
            this.dia = dia;
        }
    }


    public TreeInfo diameterOfTree2(MainBinaryTreeYT.Node root) {

        if (root == null)
            return new TreeInfo(0, 0);


        TreeInfo left = diameterOfTree2(root.left);
        TreeInfo right = diameterOfTree2(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;
        int d1 = left.dia;
        int d2 = right.dia;
        int d3 = left.ht + right.ht + 1;
        int myDia = Math.max(Math.max(d1, d2), d3);

        return new TreeInfo(myHeight, myDia);
    }


    public boolean isSubtreeOfAnotherTree(MainBinaryTreeYT.Node root, MainBinaryTreeYT.Node subRoot) {
        if (subRoot == null)
            return true;
        if (root == null)
            return false;

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        boolean left = isIdentical(root.left, subRoot);
        boolean right = isIdentical(root.right, subRoot);

        return left || right;
    }

    public boolean isIdentical(MainBinaryTreeYT.Node root, MainBinaryTreeYT.Node subRoot) {

        if (root == null && subRoot == null)
            return true;

        if (root == null || subRoot == null)
            return false;

        if (root.data == subRoot.data) {
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot);
        }
        return false;
    }


    public int subAtLevel(MainBinaryTreeYT.Node root, int k) {

        if (k == 0) {
            return 0;
        }
        int result = getSumAtKthLevel(root, k, 0);
        return result;
    }

    private int getSumAtKthLevel(MainBinaryTreeYT.Node root, int k, int curLevel) {
        Queue<MainBinaryTreeYT.Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        curLevel += 1;
        int result = 0;
        while (!q.isEmpty()) {
            MainBinaryTreeYT.Node temp = q.remove();
            if (temp == null) {
                System.out.println();
                if (q.isEmpty())
                    break;
                else {
                    q.add(null);
                    curLevel++;
                }

            } else {
                if (curLevel == k) {
                    result += temp.data;
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return result;
    }
}
