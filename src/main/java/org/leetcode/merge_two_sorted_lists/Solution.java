package org.leetcode.merge_two_sorted_lists;

import java.util.List;
import java.util.Objects;

class Solution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode mergedList = new ListNode();
    do {
        if (!Objects.isNull(list1) && Objects.isNull(list2)) {
            int val = list1.val;
            list1 = list1.next;
            mergedList.next = new ListNode(val, new ListNode());
        }

        if (Objects.isNull(list1) && !Objects.isNull(list2)) {
            int val = list2.val;
            list2 = list2.next;
            mergedList.next = new ListNode(val);
        }

        if (list1.val > list2.val) {
            int val = list1.val;
            list1 = list1.next;
            mergedList.next = new ListNode(val);
        } else {
            int val = list2.val;
            list2 = list2.next;
            mergedList.next = new ListNode(val);
        }
    } while(!Objects.isNull(list1) && !Objects.isNull(list2));

//    if (Objects.isNull(list1.val) && Objects.isNull(list2.val)) {
//      return null;
//    }
//
//    if (list1.val > list2.val) {
//      int val = list1.val;
//      list1 = list1.next;
//      System.out.println(val);
//      mergedList = new ListNode(val, mergeTwoLists(list1, list2));
//
//    } else {
//      int val = list2.val;
//      list2 = list2.next;
//      System.out.println(val);
//      mergedList = new ListNode(val, mergeTwoLists(list1, list2));
//    }

    return mergedList;
  }

  public static void main(String[] args) {
    ListNode l = new ListNode(1);
    ListNode l1 = new ListNode(2);
    ListNode l2 = new ListNode(3);
    ListNode l3 = new ListNode(4);
    ListNode l4 = new ListNode(5);
    ListNode l5 = new ListNode(6);
    ListNode l6 = new ListNode(7);
    ListNode l7 = new ListNode(8);

    l.next = l2;
    l2.next = l4;
    l4.next = l6;

    l1.next = l3;
    l3.next = l5;
    l5.next = l7;

    Solution s = new Solution();
    ListNode result = s.mergeTwoLists(l, l1);

    do {
      System.out.println(result.val);
    } while (!Objects.isNull(result.next));
  }
}
