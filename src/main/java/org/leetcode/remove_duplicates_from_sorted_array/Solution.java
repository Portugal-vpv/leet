package org.leetcode.remove_duplicates_from_sorted_array;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
  public int removeDuplicates(int[] nums) {
    int[] expectedNums = new int[nums.length];
    int k = 0;
    int ref = 0;
    expectedNums[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != expectedNums[ref]) {
        ref += 1;
        expectedNums[ref] = nums[i];
      } else {
        k += 1;
      }
    }
    nums = new int[expectedNums.length - k];
    System.arraycopy(expectedNums, 0, nums, 0, expectedNums.length - k);
    Arrays.stream(nums).forEach(System.out::println);

    return k;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.removeDuplicates(new int[] {1, 1, 2});
  }
}
