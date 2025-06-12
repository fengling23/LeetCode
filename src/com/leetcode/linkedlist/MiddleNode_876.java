package com.leetcode.linkedlist;

public class MiddleNode_876 {
    public ListNode middleNode(ListNode head) {
        //对于偶数个节点，要求返回第二个，所以不能从dummy开始
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
