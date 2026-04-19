import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                } else dist[i][j] = Integer.MAX_VALUE;
            }
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] d : dirs) {
                int x = cell[0] + d[0], y = cell[1] + d[1];
                if (x >= 0 && y >= 0 && x < m && y < n && dist[x][y] > dist[cell[0]][cell[1]] + 1) {
                    dist[x][y] = dist[cell[0]][cell[1]] + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return dist;
    }
}
