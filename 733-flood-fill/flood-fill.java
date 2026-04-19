class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        
        // If the starting pixel is already the target color, no work is needed
        if (originalColor != color) {
            dfs(image, sr, sc, originalColor, color);
        }
        
        return image;
    }

    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        // Boundary checks and color match check
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != originalColor) {
            return;
        }

        // Update the color
        image[r][c] = newColor;

        // Recurse in 4 directions
        dfs(image, r + 1, c, originalColor, newColor); // Down
        dfs(image, r - 1, c, originalColor, newColor); // Up
        dfs(image, r, c + 1, originalColor, newColor); // Right
        dfs(image, r, c - 1, originalColor, newColor); // Left
    }
}