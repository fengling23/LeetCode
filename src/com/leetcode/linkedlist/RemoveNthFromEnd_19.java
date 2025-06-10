package com.leetcode.linkedlist;

import java.util.Stack;

public class RemoveNthFromEnd_19 {
    //快慢指针
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        //找到倒数第N+1个节点， 快慢指针相差N+1步
        //但是slow不能从head开始走n+1步，考虑到删除头节点的情况
        ListNode fast = head, slow = dummy;
        for(int i = 0; i< n; i++){
            fast = fast.next;
        }
        //fast走到null的时候，slow就是倒数第n+1个节点
        while(fast != null){
            fast=fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy =  new ListNode(0, head);
        int length =  getLength(head);
        //找到倒数第n+1个节点
        //从dummy走到null是l+1步，所以从dummy走到倒数n+1个节点只需要走l+1-（n+1）步
        ListNode p = dummy;
        for (int i = 0; i < length-n; i++){
            p = p.next;
        }
        p.next = p.next.next;
        return dummy.next;

    }

    private int getLength(ListNode head){
        int i = 0;
        ListNode p = head;
        while(p!=null){
            p = p.next;
            ++i;
        }
        return i;
    }

    //利用栈的特性，全部压栈，弹出n个以后栈顶元素就是前置节点
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Stack<ListNode> stack = new Stack<>();
        //一定要把dummy节点也入栈，否则删除头节点时候会把全部元素都出栈
        ListNode p = dummy;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        for(int i =0; i < n ; i++){
            stack.pop();
        }

        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }

}
