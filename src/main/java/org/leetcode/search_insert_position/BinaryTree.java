package org.leetcode.search_insert_position;

public class BinaryTree {
  public Node root;

  public void add(int value) {
    root = addRecursive(root, value);
  }

  public boolean containsNode(int value) {
    return containsNodeRecursive(root, value);
  }

  private Node addRecursive(Node current, int val) {
    if (current == null) {
      return new Node(val);
    }

    if (val < current.value) {
      current.left = addRecursive(current.left, val);
    } else if (val > current.value) {
      current.right = addRecursive(current.right, val);
    } else {
      return current;
    }

    return current;
  }

  private boolean containsNodeRecursive(Node current, int value) {
    if (current == null) {
      return false;
    }

    if (value == current.value) {
      return true;
    }

    if (value < current.value) {
      return containsNodeRecursive(current.left, value);
    } else {
      return containsNodeRecursive(current.right, value);
    }
  }

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    bt.add(1);
    bt.add(2);
    bt.add(3);
    bt.add(4);
    bt.add(5);
    bt.add(6);
    bt.add(7);

    System.out.println(bt.containsNode(1));
    System.out.println(bt.containsNode(2));
    System.out.println(bt.containsNode(3));
    System.out.println(bt.containsNode(4));
    System.out.println(bt.containsNode(5));
    System.out.println(bt.containsNode(6));
  }
}
