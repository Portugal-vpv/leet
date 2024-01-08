package org.leetcode.index_of_first_occurence;

public class Solution {
  public int strStr(String haystack, String needle) {
    int firstIndex = 0;
    boolean found = false;
    if (haystack.length() < needle.length()) {
      return -1;
    }
    for (int i = 0; i < haystack.length(); i++) {
      char c = haystack.charAt(i);
      if (haystack.charAt(i) == needle.charAt(0)) {
        firstIndex = i;
        for (int j = 0; j < needle.length(); j++) {
          if (haystack.length() > firstIndex + j
              && needle.charAt(j) == haystack.charAt(firstIndex + j)) {
            found = true;
          } else {
            found = false;
            break;
          }
        }
        if (found) {
          break;
        }
      }
    }
    return found ? firstIndex : -1;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.strStr("mississippi", "sipp"));
  }
}
