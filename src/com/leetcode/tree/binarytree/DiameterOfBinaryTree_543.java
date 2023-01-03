package com.leetcode.tree.binarytree;

import java.util.HashMap;
import java.util.Map;

public class DiameterOfBinaryTree_543 {


    // 深度是路线上的节点数, 直径是路线上的边数目
    // 每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和。
    // 遍历整棵树中的每个节点，然后通过每个节点的左右子树的最大深度算出每个节点的「直径」，最后把所有「直径」求个最大值
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int rootDiameter = maxDepth(root.left) + maxDepth(root.right);
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        //但是不一定非要经过根节点(比如根节点只有一个右子树, 且右子树两个子树深度和大于右子树)
        return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
    }

    //添加map存储高度, 避免重复计算
    static Map<TreeNode, Integer> map = new HashMap<>();
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) return map.get(root);
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        int height = 1 + Math.max(leftHeight, rightHeight);
        map.put(root, height);
        return height;
    }

    //必须放在外面, 传递基础变量在方法中的修改出方法后不会生效
    public int diameter = 0;

    public int diameterOfBinaryTree1(TreeNode root) {
        maxDepth1(root);
        return diameter;
    }

    //优化: 计算深度的时候一并更新直径
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = maxDepth1(root.left);
        int rightHeight = maxDepth1(root.right);
        diameter = Math.max(diameter, leftHeight+rightHeight);
        int height = 1 + Math.max(leftHeight, rightHeight);
        return height;
    }




}
