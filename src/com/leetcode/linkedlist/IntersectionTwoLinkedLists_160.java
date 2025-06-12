package com.leetcode.linkedlist;

//核心思想是保证同步抵达相交点
public class IntersectionTwoLinkedLists_160 {

    //分别计算长度LA LB，长的那个指针先走LA-LB步
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int la =0, lb =0;
        ListNode p1 =headA, p2 =headB;
        while(p1 != null){ p1 =p1.next; ++la;}
        while(p2 != null){ p2 =p2.next; ++lb;}

        p1 = headA;
        p2 = headB;
        if(la > lb) {
            for(int i = 0; i< la -lb; i++){
                p1 = p1.next;
            }
        } else {
            for (int i =0; i< lb-la; i++){
                p2 = p2.next;
            }
        }

        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    //p1遍历LA完成以后再遍历LB
    //p2遍历LB完成以后再走LA
    //这样他两相遇的时候就都走完了各自都有的以及一遍公共的
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p1 =headA, p2 =headB;
        while(p1 != p2) {
            p1 = p1 == null? headB : p1.next;
            p2 = p2 == null? headA : p2.next;
        }
        return p1;
    }
}
