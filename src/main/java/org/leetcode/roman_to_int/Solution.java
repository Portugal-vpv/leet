package org.leetcode.roman_to_int;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Solution {
  public int romanToInt(String s) {
    HashMap<Character, Integer> mp = new HashMap<>();
    int len = s.length();
    int value = 0;
    char[] lookupValues = {'I', 'X', 'C'};

    mp.put('I', 1);
    mp.put('V', 5);
    mp.put('X', 10);
    mp.put('L', 50);
    mp.put('C', 100);
    mp.put('D', 500);
    mp.put('M', 1000);

    for (int i = 0; i < len; i++) {
      int finalI = i;
      if (i != 0 && skip(s.charAt(i), s.charAt(i -1))) {
        continue;
      }
      if (Stream.of('I', 'X', 'C').anyMatch(el -> el == s.charAt(finalI)) && i != len - 1) {
        value += lookup(s.charAt(i), s.charAt(i + 1), mp);
      } else {
        value += mp.get(s.charAt(i));
      }
    }
    return value;
  }

  public int lookup(char current, char next, HashMap<Character, Integer> mp) {
    boolean iException = current == 'I' && (next == 'V' || next == 'X');
    boolean xException = current == 'X' && (next == 'L' || next == 'C');
    boolean cException = current == 'C' && (next == 'D' || next == 'M');
    if (iException || xException || cException) {
      return mp.get(next) - mp.get(current);
    }
    return mp.get(current);
  }

  public boolean skip(char current, char prev) {
    boolean iException = prev == 'I' && (current == 'V' || current == 'X');
    boolean xException = prev == 'X' && (current == 'L' || current == 'C');
    boolean cException = prev == 'C' && (current == 'D' || current == 'M');

    return iException || xException || cException;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.romanToInt("MCMXCIV"));
  }
}
