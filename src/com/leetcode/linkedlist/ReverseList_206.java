package com.leetcode.linkedlist;

//https://leetcode.cn/problems/reverse-linked-list/
public class ReverseList_206 {

    //设置一个新的头节点
    //每次将当前节点插入到新节点之前
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null){
            ListNode cur = head.next;
            //每次将当前节点插入到新头节点之前
            head.next = newHead;
            //将新头结点修改为当前节点
            newHead = head;
            //head指向下一个节点
            head = cur;
        }
        return newHead;
    }

    public ListNode reverseList_1(ListNode head) {
        //空链表以及只有一个节点得,无需反转
        if (head == null || head.next == null) return head;
        //反转之后的部分
        ListNode newHead = reverseList_1(head.next);
        //加head添加到反转列表之后
        head.next.next = head;
        //head成为末节点
        head.next = null;
        return newHead;
    }
}
