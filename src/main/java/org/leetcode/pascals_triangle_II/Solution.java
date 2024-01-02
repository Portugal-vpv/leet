package org.leetcode.pascals_triangle_II;

import java.util.ArrayList;
import java.util.List;

class Solution {

  public void print(Object var) {
    System.out.println(var);
  }

  public List<Integer> getRow(int rowIndex) {
    List<Integer> obj = new ArrayList<>();
    if (rowIndex == 0) {
      return List.of(1);
    }
    List<Integer> prevRow = getRow(rowIndex - 1);
    for (int i = 0; i <= rowIndex; i++) {
      if (i == 0) {
        obj.add(prevRow.get(0));
      } else if (i == rowIndex) {
        obj.add(prevRow.get(prevRow.size() -1));
      } else {
        obj.add(prevRow.get(i) + prevRow.get(i - 1));
      }
    }
    return obj;
  }
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.getRow(33));
  }
}
