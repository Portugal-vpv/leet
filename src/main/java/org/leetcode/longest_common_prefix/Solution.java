package org.leetcode.longest_common_prefix;

import java.util.Arrays;

class Solution {
  public String longestCommonPrefix(String[] strs) {
    StringBuilder sb = new StringBuilder();
    int len = strs.length;

    if (len == 0) {
      return "";
    }

    char[] firstWord = strs[0].toCharArray();
    int i = 0;

    for (char c : firstWord) {
      boolean prefix = true;
      for (String word : strs) {
        if (i >= word.length()) {
          prefix = false;
          break;
        }
        if (word.charAt(i) != c) {
          prefix = false;
          break;
        }
      }
      i += 1;
      if (prefix) {
        sb.append(c);
      } else {
        break;
      }
    }
    return sb.length() == 0 ? "" : sb.toString();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] strings = {"ab", "a"};
    System.out.println(solution.longestCommonPrefix(strings));
  }
}
