package com.leetcode.tree.binarytree.bfs;

import com.leetcode.tree.Tree;
import com.leetcode.tree.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth_111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            //一次取出同一层的所有节点
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();

                if (curr.left == null && curr.right == null) {
                    return depth;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
