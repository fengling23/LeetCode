package com.leetcode.doublepointer.speedpointer;

import com.leetcode.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode_160 {

    //hashset
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        if (headA == null || headB == null) return null;

        ListNode p = headA;
        do { set.add(p); } while ((p = p.next) != null) ;
        p = headB;
        do {
            if(set.contains(p)) return p;
        } while ((p = p.next) != null);
        return null;
    }

    // 解决这个问题的关键是，通过某些方式，让p1和p2能够同时到达相交节点c1
    // 让p1遍历完链表A之后开始遍历链表B，让p2遍历完链表B之后开始遍历链表A (都走过了各自独有的以及工有)
    // 当指针 pA pB 指向同一个节点或者都为空时，返回它们指向的节点或者 null
    private ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        //pA pB都为null的时候, ==返回true
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
