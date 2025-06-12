package com.leetcode.linkedlist;

public class ReverseListBetween_92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = null, rightNode = null;

        //找到left的前置节点以及最右边的节点
        if(left == 1) prev = dummy;
        ListNode p = dummy;
        int index = 0;
        while(p != null){
            p = p.next;
            index++;
            if(index == left - 1) { prev = p; }
            if(index == right) {
                rightNode = p;
                break;
            }
        }


        ListNode leftNode = prev.next;
        ListNode after = rightNode.next;

        //断开前后链接， 形成独立链表再反转
        rightNode.next = null;
        prev.next = null;
        reverseLinkedList(leftNode);

        //将反转后的节点分别与前后对接
        prev.next = rightNode;
        leftNode.next = after;
        return dummy.next;

    }

    public void reverseLinkedList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;

        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    }

    public void reverseLinkedList2(ListNode head){
        if (head == null || head.next == null) {
            return;
        }

        reverseLinkedList2(head.next);

        head.next.next = head;

        head.next = null;
    }
}
