package com.leetcode.linkedlist;

public class PartitionLinkedLIst_86 {
    //将原链表拆分为两个， 分别存储<x和>=x的数据
    //最后再拼接回来
    public ListNode partition(ListNode head, int x) {
        ListNode p = head;
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1, p2 = dummy2;

        while(p!=null){
            if(p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2=p2.next;
            }

            //需要将原有链接断开，不然会影响最终拼接的链表
            ListNode temp = p;
            p = p.next;
            temp.next = null;
        }

        //拼接两个链表
        p1.next = dummy2.next;
        return dummy1.next;

    }
}
