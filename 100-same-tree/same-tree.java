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

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both are null, they are the same
        if (p == null && q == null) return true;

        // If one is null and the other isn’t, not the same
        if (p == null || q == null) return false;

        // Check current node values and recurse for left and right
        return (p.val == q.val)
            && isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }
}
