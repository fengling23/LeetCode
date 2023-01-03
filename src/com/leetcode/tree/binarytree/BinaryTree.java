package com.leetcode.tree.binarytree;

import com.leetcode.tree.Tree;
import java.util.*;

public class BinaryTree extends Tree {
    public BinaryNode root;

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    public static void preOrderTraversal(BinaryNode node) {
        if (node != null) {
            node.visit();
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public static void preOrderTraversal1(BinaryNode node) {
        Stack<BinaryNode> stack = new Stack<>();
        if (node == null) return;

        stack.push(node);
        while (!stack.isEmpty()) {
            BinaryNode parent = stack.pop();
            parent.visit();
            if (parent.right != null) stack.push(parent.right);
            if (parent.left != null) stack.push(parent.left);
        }
    }

    //非递归实现
    public static void preOrderTraversal2(BinaryNode node) {
        Stack<BinaryNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            //打印当前节点, 并继续访问打印左节点
            if (node != null) {
                stack.push(node);
                node.visit();
                node = node.left;
            }
            //父节点没有了左节点/父节点为叶子结点, 转而访问父节点的右节点
            else {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    public static void inOrderTraversal(BinaryNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            node.visit();
            inOrderTraversal(node.right);
        }
    }

    public static void inOrderTraversal1(BinaryNode node) {
        Stack<BinaryNode> stack = new Stack<>();
        BinaryNode current = node;
        //
        while (current != null || !stack.isEmpty()) {
            //当前节点不为null的时候, 先加入当前节点, 再将current指向左节点
            if (current != null) {
                stack.push(current);
                current = current.left;
            }
            // 如果当前节点为null
            // 则证明父节点已无左节点或者父节点为叶子结点
            // 将父节点出栈, current指向父节点的右节点
            else {
                BinaryNode parent = stack.pop();
                parent.visit();
                current = parent.right;
            }
        }
    }

    public static void inorderTraversal2(BinaryNode root) {
        // 创建一个栈来存储节点
        Stack<BinaryNode> stack = new Stack<>();
        // 当前遍历到的节点
        BinaryNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // 将当前节点的所有左子节点入栈
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            if (!stack.isEmpty()) {
                // 取出栈顶节点并访问
                curr = stack.pop();
                curr.visit();
                // 将当前节点的右子节点作为下一个遍历的节点
                curr = curr.right;
            }

        }
    }

    //后序位置的特点，只有后序位置才能通过返回值获取子树的信息。
    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    public static void postOrderTraversal(BinaryNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            node.visit();
        }
    }

    // 常规实现
    // 将根节点左子树入栈，当访问到叶子结点/null，出栈，查看该叶子结点的父节点是否有右结点，
    // 有的话，如果右结点未访问则将右节点入栈
    // 当一个节点的左右结点都已经访问过或者不包含左右结点，则出栈。
    public static void postOrderTraversal1(BinaryNode root) {

        if (root == null) return;

        Map<BinaryNode, Integer> map = new HashMap<>();
        Stack<BinaryNode> stack = new Stack<>();
        BinaryNode curr = root;
        stack.push(curr);
        while (!stack.isEmpty()) {
            curr = stack.peek();
            //不含左右结点时，出栈
            if (curr.left == null && curr.right == null) {
                curr = stack.pop();
                curr.visit();
                map.put(curr, 1);
            }
            //左节点和右节点均已访问
            else if ((curr.left != null && curr.right == null && map.containsKey(curr.left))
                    || (curr.right != null && curr.left == null && map.containsKey(curr.right))
                    || (curr.left != null && curr.right != null && map.containsKey(curr.left) && map.containsKey(curr.right))) {//包含子节点，但是子节点被访问过，出栈
                curr = stack.pop();
                curr.visit();
                map.put(curr, 1);
            } else {
                //先添加左节点, 直到左节点遇到已遍历的右节点或者到达叶节点
                while (curr.left != null) {
                    if (map.containsKey(curr.left)) {
                        break;
                    }
                    stack.push(curr.left);
                    curr = curr.left;
                }
                //如果右节点不为空且未遍历则接着访问右节点
                if (curr.right != null && !map.containsKey(curr.right)) {
                    stack.push(curr.right);
                }
            }
        }
    }

    //常规实现的优化, 按照递归顺序,只用检测上一个浏览的是当前的右节点,则证明左右节点均已访问
    public static void postOrderTraversal2(BinaryNode root) {

        BinaryNode lastVisited = null;
        Stack<BinaryNode> stack = new Stack<>();
        BinaryNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                BinaryNode parent = stack.peek();
                if (parent.right != null && lastVisited != parent.right) {
                    //右节点未访问泽处理右节点
                    curr = parent.right;
                }
                //左右节点均为null或者右节点已经遍历
                else {
                    parent.visit();
                    lastVisited = stack.pop();
                }
            }
        }
    }

    // 简单版非递归实现：
    // 后序遍历的输出顺序是左、右、根，
    // 当我们采用先序遍历的方法，但是先遍历右子树，实现的效果是根、右、左，刚好和后序遍历的结果想反
    // 所以我们通reverse将顺序反序
    public static void postOrderTraversal3 (BinaryNode root){
        List<BinaryNode> list = new ArrayList<>();
        Stack<BinaryNode> stack = new Stack<>();
        BinaryNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                list.add(curr);
                curr = curr.right;
            } else {
                curr = stack.pop();
                curr = curr.left;
            }
        }

        Collections.reverse(list);
        for (BinaryNode node : list) {
            node.visit();
        }
    }

    public void levelOrderTraversal(){
        levelOrderTraversal(root);
    }

    public static void levelOrderTraversal(BinaryNode root){

        if (root == null) return ;
        ArrayList<ArrayList<BinaryNode>> nodes = new ArrayList<>();
        help(root,0, nodes);
        for (ArrayList<BinaryNode> list: nodes) {
            for (BinaryNode node: list) {
                node.visit();
            }
        }
    }

    private static void help(BinaryNode node, int level, ArrayList<ArrayList<BinaryNode>> nodes) {
        if (level >= nodes.size()) nodes.add(new ArrayList<BinaryNode>());
        nodes.get(level).add(node);
        if (node.left != null) help(node.left, level+1, nodes);
        if (node.right != null) help(node.right, level+1, nodes);
    }

    public static void levelOrderTraversal1(BinaryNode root){

        if (root == null) {
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryNode curr = queue.poll();
            curr.visit();
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(1);
        root.left = new BinaryNode(2);
        root.right = new BinaryNode(3);
        root.left.left = new BinaryNode(4);
        root.left.right = new BinaryNode(5);
        root.right.left = new BinaryNode(6);
        root.right.right = new BinaryNode(7);

        preOrderTraversal(root);
        System.out.println();
        preOrderTraversal1(root);
        System.out.println();
        preOrderTraversal2(root);
        System.out.println();

        inOrderTraversal(root);
        System.out.println();
        inOrderTraversal1(root);
        System.out.println();
        inorderTraversal2(root);
        System.out.println();

        postOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
        System.out.println();
        postOrderTraversal2(root);
        System.out.println();
        postOrderTraversal3(root);
        System.out.println();

        levelOrderTraversal(root);
        System.out.println();
        levelOrderTraversal1(root);
        System.out.println();
    }

}
