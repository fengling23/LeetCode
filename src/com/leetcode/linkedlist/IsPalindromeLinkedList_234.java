package com.leetcode.linkedlist;

import java.util.List;
import java.util.Stack;

public class IsPalindromeLinkedList_234 {

    //利用栈的特性
    public static boolean isPalindrome(ListNode head) {
        //int类型节省空间
        Stack<Integer> nodes = new Stack<>();
        ListNode cur = head;
        while(cur != null) {
            nodes.push(cur.val);
            cur = cur.next;
        }

        while (head != null) {
            if( nodes.pop() != head.val) return false;
            head = head.next;
        }

        return true;
    }

    private static ListNode cur;

    //递归实现
    public static boolean isPalindrome_1(ListNode head) {
        cur = head;
        return palindromeCheck(head);
    }

    //递归函数用栈来保存参数
    //1.node为null时,返回TRUE,回到上一层函数
    //2.node走到最后一个节点时, current为头结点
    //3.node为倒数第二个节点时,current为第二个节点
    //...知道最外层函数

    private static boolean palindromeCheck(ListNode node) {
        //检测结束
        if (node == null)
            return true;
        //判断其余部分是不是回文字符串
        boolean res = palindromeCheck(node.next) && (node.val == cur.val);
        //当前层中修改入参未生效于外层函数入参, 需提取为全局变量
        cur = cur.next;
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        //head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome_3(head));
    }

    //避免重复比较,找出中点,比较前半部分和后半部分
    public static boolean isPalindrome_2(ListNode head) {

        Stack<Integer> nodes = new Stack<>();
        //快指针结束的时候,慢指针为中点
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            nodes.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        //偶数情况时需要将左中点也放进去
        if(fast.next != null)
            nodes.push(slow.val);

        while (slow.next != null) {
            slow = slow.next;
            if( nodes.pop() != slow.val) return false;
        }

        return true;
    }

    //O(1)空间复杂度,在上面的基础上需要将后半部分链表反转
    public static boolean isPalindrome_3(ListNode head) {
        //快指针结束的时候,慢指针为中点
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode left = head;
        ListNode rightStart = reverse(slow.next);
        ListNode right = rightStart;
        while (right != null) {
            if( head.val != right.val) return false;
            head = head.next;
            right = right.next;
        }

        //还原链表
        slow.next = reverse(rightStart);
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null){
            ListNode t = head.next;
            head.next = newHead;
            newHead = head;
            head = t;
        }
        return newHead;
    }



}
