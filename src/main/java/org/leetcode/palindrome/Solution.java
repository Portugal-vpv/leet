package org.leetcode.palindrome;

public class Solution {
  public boolean isPalindrome(int x) {
    String val = String.valueOf(x);
    int len = val.length();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++) {
      sb.append(val.charAt(len - 1 - i));
    }
    return sb.toString().equals(val);
  }

  public boolean isPalindrome2(int x) {
    String val = String.valueOf(x);
    int len = val.length();
    boolean isEven = Math.floorMod(x,2) == 0;
    if (isEven) {
      for (int i = 0; i < len; i++) {
        if (val.charAt(len - 1 - i) != val.charAt(i)) {
          return false;
        }
      }
      return true;
    }
    for (int i = 0; i < len; i++) {
      if (val.charAt(len - 1 - i) != val.charAt(i) && i != (len - 1)/2) {
        return false;
      }
    }
    return true;

  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.isPalindrome2(1221));
  }
}
