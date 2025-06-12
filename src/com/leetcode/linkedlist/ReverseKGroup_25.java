package com.leetcode.linkedlist;

public class ReverseKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;

        ListNode p2 = head;
        for (int i = 0; i < k; i ++){
            //如果长度小于k，则意味着不用翻转
            if(p2 == null) { return head;}
            p2 = p2.next;
        }
        //此时p2是第K+1个节点
        //先反转链表的前K个节点
        ListNode newHead = reverseN(head, k);
        //再对剩下的部分做reverseKGroup
        ListNode otherHead = reverseKGroup(p2, k);
        //反转后head成为尾节点,再连接剩下部分
        head.next = otherHead;
        return newHead;

    }

    //先反转链表的前K个节点
    //每次依次取当前节点放到newHead之前
    public ListNode reverseN(ListNode head, int n) {
        if(head == null && head.next == null) return head;
        ListNode cur = head;
        ListNode newHead = null;
        int step = 0;
        while(step < n) {
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
            ++step;
        }
        //此时cur是第n+1个节点, head是反转后的尾节点
        head.next = cur;
        return newHead;
    }
}
