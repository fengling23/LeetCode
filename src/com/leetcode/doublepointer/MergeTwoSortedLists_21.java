package com.leetcode.doublepointer;

public class MergeTwoSortedLists_21 {

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //快慢指针的while写法
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        while(list1 != null && list2 != null) {

            if(list1.val > list2.val) {
                p.next = list2;
                list2 = list2.next;
            } else {
                p.next = list1;
                list1 = list1.next;
            }
            p = p.next;
        }
        p.next = list1 != null ? list1 : list2;
        return dummy.next;
    }

    //快慢指针的递归写法
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 ==null) return list2;
        if (list2 ==null) return list1;
        if(list1.val < list2.val) {
            list1.next = mergeTwoLists2(list1.next,list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1,list2.next);
            return list2;
        }
    }

    
}
