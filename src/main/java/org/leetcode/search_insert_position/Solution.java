package org.leetcode.search_insert_position;

public class Solution {
    public int searchInsert(int[] nums, int target) {
    int high = nums.length - 1;
    int low = 0;

    while (low <= high) {
      int mid = (high + low) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (target > nums[mid]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
    }
}
