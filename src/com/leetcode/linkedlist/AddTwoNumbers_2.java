package com.leetcode.linkedlist;

public class AddTwoNumbers_2 {
    //总体思路: 诸位相加, 没值补0
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null){
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2 + carry;
            int mod = sum % 10;
            carry = sum/10;

            ListNode curr = new ListNode(mod);
            if(head == null){
                head = tail = curr;
            } else {
                tail.next = curr;
                tail = tail.next;
            }

            if(l1 != null){ l1 = l1.next;}
            if(l2 != null){ l2 = l2.next;}
        }
        //处理最后一位
        if(carry == 1){
            tail.next = new ListNode(carry);
        }
        return head;
    }

    //增加dummy节点，避免特殊处理
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 =l2;
        ListNode dummy = new ListNode(0), cur = dummy;
        int carry = 0;
        while (p1 !=null || p2 !=null) {
            int v1 = p1 != null ? p1.val : 0;
            int v2 = p2 != null ? p2.val : 0;
            int val = (v1 + v2 + carry) % 10;
            cur.next = new ListNode(val);
            carry = (v1 + v2 + carry) / 10;
            if(p1 != null) p1 = p1.next;
            if(p2 != null) p2 = p2.next;
            cur = cur.next;
        }

        if(carry > 0 ){
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 =l2;
        ListNode dummy = new ListNode(0), cur = dummy;
        int prev = 0;
        while (p1 !=null && p2 !=null) {
            int val = (p1.val + p2.val) % 10 + prev;
            cur.next = new ListNode(val);
            prev = (p1.val + p2.val) / 10;
            p1 = p1.next;
            p2 = p2.next;
            cur = cur.next;
        }

        //忽略了停止后cur.next.val + prev > 10可能导致的后面进位的处理
        cur.next = p1 != null ? p1 : p2;
        if(cur.next != null){
            cur.next.val = cur.next.val + prev;
        }

        return dummy.next;
    }

}
