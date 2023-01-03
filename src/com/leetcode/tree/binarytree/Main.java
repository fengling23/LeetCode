package com.leetcode.tree.binarytree;

public class Main {
    public static void main(String[] args) {
        DiameterOfBinaryTree_543 o = new DiameterOfBinaryTree_543();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(-7);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(-3);
        root.right.right.left = new TreeNode(-4);

        root.right.left = new TreeNode(-9);
        root.right.left.left = new TreeNode(9);
        root.right.left.left.left = new TreeNode(6);
        root.right.left.left.left.left = new TreeNode(0);
        root.right.left.left.left.left.right = new TreeNode(-1);
        root.right.left.left.left.right = new TreeNode(6);
        root.right.left.left.left.right.left = new TreeNode(-4);

        root.right.left.right = new TreeNode(-7);
        root.right.left.right.left = new TreeNode(-6);
        root.right.left.right.left.left = new TreeNode(5);
        root.right.left.right.right = new TreeNode(-6);
        root.right.left.right.right.left = new TreeNode(9);
        root.right.left.right.right.left.left = new TreeNode(-2);

        int res =  o.diameterOfBinaryTree1(root);
        System.out.println(res);
    }
}

