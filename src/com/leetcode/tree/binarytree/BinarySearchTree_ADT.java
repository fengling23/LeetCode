package com.leetcode.tree.binarytree;

public class BinarySearchTree_ADT extends BinaryTree{

    public BinaryNode findMin() {
        return findMin(root);
    }
    public static BinaryNode findMin(BinaryNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public BinaryNode findMax() {
        return findMax(root);
    }

    public static BinaryNode findMax(BinaryNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

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

    public static BinaryNode find1(int x, BinaryNode node) {
        if(node == null) return null;

        BinaryNode curr = node;
        while (curr != null) {
            int comp = Integer.compare(x, curr.val);
            if(comp == 0) {
                return node;
            } else if (comp < 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return null;
    }
    public boolean contains (int x) {
        return contains(x, root);
    }

    public static boolean contains (int x, BinaryNode node) {
        return find(x, node) != null;
    }

    public BinaryNode insert(int x) {
        return root = insert(x, root);
    }

    public static BinaryNode insert(int x, BinaryNode node) {

        if (node == null) {
            node = new BinaryNode(x);
            return node;
        }
        int comp = Integer.compare(x, node.val);
        if (comp < 0 ) {
            node.left = insert(x, node.left);
        } else {
            node.right = insert(x, node.right);
        }
        return node;
    }

    public static BinaryNode insert1(int x, BinaryNode root) {
        BinaryNode node = new BinaryNode(x);
        if (root == null) return node;
        BinaryNode curr = root;
        while (curr != null) {
            int comp = Integer.compare(x, node.val);
            if (comp < 0 ) {
                if (curr.left == null) {
                    curr.left = node;
                    break;
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = node;
                    break;
                }
                curr = curr.right;
            }
        }

        return root;
    }

    public BinaryNode remove(int x) {
        return remove1(x, root);
    }



    // 递归实现
    // 待删除的节点为叶子节点：直接将其从树中删除即可。
    // 待删除的节点只有左子树或右子树：直接将其子树顶替到其位置即可。
    // 待删除的节点既有左子树又有右子树：此时需要将父节点的右节点替换为右子树中大于待删除节点的最小节点 或者父节点的左节点替换为左子树中小于待删除节点的最大节点来顶替
    // 会有两种结果
    public static BinaryNode remove(int key, BinaryNode root) {
        //叶子结点
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = remove(key, root.left);
        } else if (key > root.val) {
            root.right = remove(key, root.right);
        } else {
            //左子树为null,右子树顶替
            if (root.left == null) {
                return root.right;
            }
            //右子树为null,左子树顶替
            else if (root.right == null) {
                return root.left;
            } else {
                BinaryNode minNode = findMin(root.right);
                // 将当前节点的值改为右子树里最小的
                root.val = minNode.val;
                // 递归删除右子树里最小值的节点
                root.right = remove(root.val, root.right);
            }
        }

        return root;
    }

    public static BinaryNode remove1(int key, BinaryNode root) {
        //叶子结点
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = remove(key, root.left);
        } else if (key > root.val) {
            root.right = remove(key, root.right);
        } else {
            //左子树为null,右子树顶替
            if (root.left == null) {
                return root.right;
            }
            //右子树为null,左子树顶替
            else if (root.right == null) {
                return root.left;
            } else {
                BinaryNode maxNode = findMax(root.left);
                // 将当前节点的值改为左子树里最大的
                root.val = maxNode.val;
                // 递归删除左子树里最大值的节点
                root.left = remove(root.val, root.left);
            }
        }

        return root;
    }

    // 非递归实现
    // 返回删除之后的树的根节点
    public static BinaryNode remove2(int x, BinaryNode root) {
        BinaryNode curr = root, parent = null;
        boolean left_child = true;
        //parent比current少走一步
        while (curr != null && Integer.compare(x, curr.val) != 0 ) {
            parent = curr;
            int comp = Integer.compare(x, curr.val);
            if (comp < 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if (curr == null) return null;
        //叶子节点
        if (curr.left == null && curr.right == null){
            //删除只有一个节点的根节点
            if( parent == null) { root = null; }
            //非根节点时,父节点的对应指针设空
            else {
                if (left_child) parent.left = null;
                else parent.right = null;
            }
        }
        //只有一个子树
        else if (curr.left == null || curr.left == null) {
            BinaryNode child = curr.left != null ? curr.left : curr.right;
            //删除只有一个子树的根节点,将子节点提拔为根节点
            if (parent == null) { root = child; }
            //用子节点替代删除节点的位置
            else {
                if (left_child)  parent.left = child;
                else parent.right = child;
            }
        }
        //存在两个子树
        else {
            /*
                // 可以递归调用
                BinaryNode maxNode = findMax(root.left);
                // 将当前节点的值改为右子树里最小的
                root.val = maxNode.val;
                // 再删除右子树里最小值的节点
                root.left = remove(root.val, root.left);
            */

            // 完全非递归
            // 根节点时重新构建
            if (parent == null) {
                // 以左节点为根或者右节点为根, 合并两个二叉搜索树
                //root = mergeTree(curr.left, curr.right);

                /*
                // 因为左子树的所有节点值均小于右子树中所有节点, 所以可以简单将左子树设为右子树最小节点的左子树 或者将右子树设为左子树最大节点的右子树来完成合并
                BinaryNode maxNode = findMax(curr.left);
                maxNode.right = curr.right;
                root = curr.left;
                */
                //优化解法提高时间复杂度
                root = mergeSortedTree(curr.left, curr.right);


            }
            // 非根节点时
            // 让左子树或者右子树取代原先节点位置,另一子树放到替代子树的最大节点的右子树或者最小节点的左子树
            else {
                /*
                // 如果删除节点为父节点的左节点,
                // 1) 将删除节点的右子树设置为父节点的左子树, 删除节点的左子树设置为删除节点右子树中最小节点的左子树
                // 2) 将删除节点的左子树设置为父节点的左子树, 删除节点的右子树设置为删除节点左子树中最大节点的右子树
                // 如果删除节点为父节点的右节点
                // 1) 将删除节点的左子树设置为父节点的右子树, 删除节点的右子树设置为删除节点左子树中最大节点的右子树
                // 2) 将删除节点的右子树设置为父节点的右子树, 删除节点的左子树设置为删除节点右子树中最小节点的左子树
                // 缺点: 高度不是很平衡
                if(left_child) parent.left = curr.left;
                else parent.right = curr.left;

                BinaryNode maxNode = findMax(curr.left);
                maxNode.right = curr.right;
                */
                //优化时间复杂度的解法
                if(left_child) parent.left = mergeSortedTree(curr.left, curr.right);
                else parent.right = mergeSortedTree(curr.left, curr.right);
            }

        }


        return root;
    }

    //递归实现合并两个二叉搜索树
    //以left为根
    public static BinaryNode mergeTree(BinaryNode left, BinaryNode right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else{
            mergeTree(left, right.left);
            insert(right.val, left);
            mergeTree(left, right.right);
            return left;
        }
    }

    // 合并两个二叉搜索树, left中所有节点均小于right中的节点
    // 选择高度较低的作为根节点., 优化时间复杂度
    public static BinaryNode mergeSortedTree(BinaryNode left, BinaryNode right) {
        BinaryNode pl = left, pr = right;
        while (pl != null && pr != null) {
            //先找到了左树中最大的
            if (pl.right == null) {
                pl.right = right;
                return left;
            } else if (pr.left == null)  {
                pr.left = left;
                return right;
            }

            //左树中最大节点
            pl = pl.right;
            //右树中最下节点
            pr = pr.left;
        }
        return left != null ? left : right;
    }

    /*public static int func(int val) {
        val = 1;
        return val;
    }

    public static Integer func(Integer val) {
        val = new Integer(1);
        return val;
    }
    public static BinaryNode func(BinaryNode node) {
        node = new BinaryNode(1);
        return node;
    }
    public static void main(String[] args) {
        int val = 0;
        func(val);
        System.out.println(val);
        val = func(val);
        System.out.println(val);

        Integer VAL = new Integer(0);
        //引用对象地址改变不生效
        func(VAL);
        System.out.println(VAL);
        //成员变量为基础类型时也不生效
        func(VAL.intValue());
        System.out.println(VAL);
        //生效
        VAL = func(VAL);
        System.out.println(VAL);


        //传入对象地址
        BinaryNode node = new BinaryNode(0);
        //引用对象地址改变不生效
        func(node);
        node.visit();
        //成员变量为基础属性改变不生效
        func(node.val);
        node.visit();
        // 成员变量为引用对象
        func(node.left);
        // because "node.left" is null
        // node.left.visit();

        //以下生效
        node.val = func(node.val);
        node.left = func(node.left);
        node = func(node);
        node.visit();
    }*/

    public static void main(String[] args) {
        BinarySearchTree_ADT treeAdt = new BinarySearchTree_ADT();
        treeAdt.insert(5);
        treeAdt.insert(3);
        treeAdt.insert(6);
        treeAdt.insert(2);
        treeAdt.insert(4);
        treeAdt.insert(7);
        treeAdt.inOrderTraversal();
        System.out.println();
        System.out.println(treeAdt.contains(1));
        System.out.println(treeAdt.contains(7));
        treeAdt.remove(5);
        treeAdt.inOrderTraversal();
        System.out.println();

        BinaryNode root = new BinaryNode(5);
        root.left = new BinaryNode(3);
        root.right = new BinaryNode(6);
        root.left.left = new BinaryNode(2);
        root.left.right = new BinaryNode(4);
        root.right.right = new BinaryNode(7);
        inOrderTraversal(root);
        System.out.println();
        root = remove2(3,root);
        inOrderTraversal(root);
        System.out.println();
    }

}
