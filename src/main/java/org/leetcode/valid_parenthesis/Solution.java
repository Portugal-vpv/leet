package org.leetcode.valid_parenthesis;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public boolean isValid(String s) {
    char[] c = s.toCharArray();
    boolean valid = true;
    Map<Character, Character> map = new HashMap<>();
    map.put('(', ')');
    map.put('{', '}');
    map.put('[', ']');

    for (int i = 0; i <= c.length; i++) {
      if (i >= c.length - 1) {
        break;
      }
      if (!map.get(c[i]).equals(c[i + 1])) {
        valid = false;
      }
      i++;
      if (!valid) {
        break;
      }
    }

    return valid;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.isValid("([)]"));
  }
}
