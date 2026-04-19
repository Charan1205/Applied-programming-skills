/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();

            // Traverse down the tree
            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                } else {
                    result.add(current.val);
                    stack.pop();
                }
            }
            // Traverse up from left
            else if (current.left == prev) {
                if (current.right != null) {
                    stack.push(current.right);
                } else {
                    result.add(current.val);
                    stack.pop();
                }
            }
            // Traverse up from right
            else if (current.right == prev) {
                result.add(current.val);
                stack.pop();
            }

            prev = current;
        }

        return result;
    }
}
