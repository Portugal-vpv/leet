package org.leetcode.valid_parenthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Solution {
  public boolean isValid(String s) {
    char[] c = s.toCharArray();
    Map<Character, Character> map = new HashMap<>();
    Stack<Character> stack = new Stack<>();
    map.put('(', ')');
    map.put('{', '}');
    map.put('[', ']');

    for (int i = 0; i < s.length(); i++) {
      if (map.containsKey(c[i])) {
        stack.push(c[i]);
      } else {
        if (stack.empty()) {
          return false;
        }
        char pop = stack.pop();
        if (!map.containsKey(pop) || map.get(pop) != c[i]) {
          return false;
        }
      }

    }
    return stack.empty();
  }

  public Future<String> calculateAsync() throws InterruptedException {
    CompletableFuture<String> future = new CompletableFuture<>();
    Executors.newCachedThreadPool()
        .submit(
            () -> {
              try {
                Thread.sleep(5000);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              future.complete("Hello");
              return;
            });
    return future;
  }

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    Solution solution = new Solution();

    System.out.println(solution.isValid("()"));
  }
}
