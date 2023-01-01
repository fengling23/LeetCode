package com.leetcode.tree.binarytree;

public class BinaryNode {

    public int val;

    public BinaryNode left;

    public BinaryNode right;

    BinaryNode (int val) { this.val = val; }

    BinaryNode (int val, BinaryNode left, BinaryNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void visit() {
        System.out.print(val);
    }
}
