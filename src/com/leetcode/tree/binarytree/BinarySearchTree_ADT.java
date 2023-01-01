package com.leetcode.tree.binarytree;

public class BinarySearchTree_ADT extends BinaryTree{


    public BinaryNode find(int x) {
        return find(x, root);
    }
    public static BinaryNode find(int x, BinaryNode node) {
        if(node == null) return null;

        int comp = Integer.compare(x, node.val);
        if(comp == 0) {
            return node;
        } else if (comp < 0) {
            return find(x, node.left);
        } else {
            return find(x, node.right);
        }
    }
    public boolean contains (int x) {
        return contains(x, root);
    }

    public static boolean contains (int x, BinaryNode node) {
        return find(x, node) != null;
    }

    public BinaryNode insert(int x) {
        return insert(x, root);
    }

    public static BinaryNode insert(int x, BinaryNode node) {
        if (node == null) return new BinaryNode(x);
        int comp = Integer.compare(x, node.val);
        if (comp < 0 ) {
            node.left = insert(x, node.left);
        } else {
            node.left = insert(x, node.left);
        }
        return node;
    }
}
