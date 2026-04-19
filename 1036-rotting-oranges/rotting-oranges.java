import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, fresh = 0, minutes = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) q.offer(new int[]{i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] d : dirs) {
                    int x = cur[0] + d[0], y = cur[1] + d[1];
                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] != 1) continue;
                    grid[x][y] = 2;
                    fresh--;
                    q.offer(new int[]{x, y});
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}
