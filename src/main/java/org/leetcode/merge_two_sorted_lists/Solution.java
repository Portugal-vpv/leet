package org.leetcode.merge_two_sorted_lists;

import java.util.Objects;

class Solution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode tempNode = new ListNode(0);
    ListNode mainNode = tempNode;
    while (!Objects.isNull(list1) && !Objects.isNull(list2)) {
      if (list1.val <= list2.val) {
        mainNode.next = list1;
            list1 = list1.next;
        } else {
        mainNode.next = list2;
            list2 = list2.next;
        }
      mainNode = mainNode.next;
    }

   mainNode.next = list1 != null ? list1 : list2;

    return tempNode.next;
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
  }
}
