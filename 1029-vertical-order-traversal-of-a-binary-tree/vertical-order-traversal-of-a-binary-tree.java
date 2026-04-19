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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map: column -> list of (row, value)
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        // Queue for BFS: node, row, col
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0, 0});

        while (!queue.isEmpty()) {
            Object[] arr = queue.poll();
            TreeNode node = (TreeNode) arr[0];
            int row = (int) arr[1];
            int col = (int) arr[2];

            if (node != null) {
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(new int[]{row, node.val});

                queue.offer(new Object[]{node.left, row + 1, col - 1});
                queue.offer(new Object[]{node.right, row + 1, col + 1});
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (List<int[]> list : map.values()) {
            // Sort by row first, then value
            Collections.sort(list, (a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            });

            List<Integer> colVals = new ArrayList<>();
            for (int[] pair : list) colVals.add(pair[1]);
            result.add(colVals);
        }

        return result;
    }
}
