package com.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class HasCycle_141 {

    //利用hashset判断有无next指针指向之前的节点
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            //add不为true则证明已存在
            if (!set.add(p)) return true;
            p=p.next;
        }
        return false;
    }

    //快慢指针相遇判断
    public boolean hasCycle1(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
