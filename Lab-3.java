// Problem 1: Balanced Brackets

import java.util.Stack;

public class BalancedBrackets {

    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        String openBrackets = "([{";
        String closeBrackets = ")]}";

        for (char ch : input.toCharArray()) {
            if (openBrackets.indexOf(ch) != -1) {
                stack.push(ch);
            } else if (closeBrackets.indexOf(ch) != -1) {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!areMatchingBrackets(top, ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean areMatchingBrackets(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        String input = "{[()]}";
        if (isBalanced(input)) {
            System.out.println("The entered String has Balanced Brackets");
        } else {
            System.out.println("The entered String does not contain Balanced Brackets");
        }
    }
}







// Problem 2: Find a Pair with a Given Sum in Binary Search Tree

import java.util.HashSet;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BSTPairWithSum {
    Node root;

    public boolean findPairWithSum(Node root, int sum) {
        HashSet<Integer> set = new HashSet<>();
        return findPair(root, sum, set);
    }

    private boolean findPair(Node node, int sum, HashSet<Integer> set) {
        if (node == null) {
            return false;
        }

        if (findPair(node.left, sum, set)) {
            return true;
        }

        if (set.contains(sum - node.data)) {
            System.out.println("Pair found: (" + (sum - node.data) + ", " + node.data + ")");
            return true;
        }

        set.add(node.data);

        return findPair(node.right, sum, set);
    }
}

public class DriverClass {
    public static void main(String[] args) {
        BSTPairWithSum tree = new BSTPairWithSum();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(40);
        tree.root.left.right = new Node(50);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(70);

        int sum = 130;
        if (!tree.findPairWithSum(tree.root, sum)) {
            System.out.println("Pair with sum " + sum + " not found.");
        }
    }
}
