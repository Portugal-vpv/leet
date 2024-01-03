package org.leetcode.valid_parenthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

    Future<String> completableFuture = solution.calculateAsync();

    String result = completableFuture.get();
    System.out.print(result);
    System.out.println(solution.isValid("([)]"));
  }
}
