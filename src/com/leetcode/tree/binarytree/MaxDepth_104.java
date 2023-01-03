package com.leetcode.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth_104 {
    int res = 0;
    int depth = 0;

    //遍历
    public int maxDepth(TreeNode root) {
        //走到叶子节点
        if (root == null) {
            res = Math.max(res, depth);
            return res;
        }
        //进入当前节点高度+1
        depth++;
        maxDepth(root.left);
        maxDepth(root.right);
        depth--;
        //返回当前节点高度-1

        return res;
    }


    //分解, 递归实现
    public int maxDepth1(TreeNode root) {
        //走到叶子节点
        if (root == null) {
            return 0;
        }
        //子树高度加1
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    //层次遍历
    public int maxDepth2(TreeNode root){
        if (root == null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode curr;
        while (!queue.isEmpty()) {
            ++res;

            int preLevelLength = queue.size();
            //取出上一层所有的
            for (int i = 0; i < preLevelLength; i++) {
                curr = queue.poll();
                //再把下一层所有的加进去
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }

        return res;

    }
}
