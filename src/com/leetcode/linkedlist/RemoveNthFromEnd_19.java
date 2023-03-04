package com.leetcode.linkedlist;

public class RemoveNthFromEnd_19 {
    //快慢指针
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        //快指针往前走n步
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        //删除头结点的的时候直接返回头结点的下一个
        if (p1 == null) { return head.next; }

        //head到null需要走length步
        //倒数第n个对象需要从头走length-n步
        //快指针为null的时候(length步), 慢指针为倒数第n个对象(length-n步)
        ListNode p2 = head;
        while (p1 != null && p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        //此时p1为末尾节点
        //p2为倒数第n+1个节点,即删除节点的前节点
        p2.next = p2.next.next;
        return head;
    }

}
