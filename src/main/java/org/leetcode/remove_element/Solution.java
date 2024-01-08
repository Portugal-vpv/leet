package org.leetcode.remove_element;

import java.util.Arrays;

public class Solution {
  public int removeElement(int[] nums, int val) {
    int i = 0;

    for (final int num : nums) {
      if (num != val) {
        nums[i++] = num;
      }
    }

    return i;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.removeElement(new int[] {0, 1, 2, 2, 3, 0, 4, 2}, 2));
  }
}
