package minpathsum;

class Solution {
    public int minPathSum(int[][] grid) {
        return callDFS(grid, 0, 0);
    }

    private int callDFS(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length)
            return Integer.MAX_VALUE;
        else if (row == grid.length - 1 && col == grid[0].length - 1) // Base case
            return grid[row][col];
        else if (grid[row][col] < 101) {
            grid[row][col] += 101 + Math.min(callDFS(grid, row + 1, col), callDFS(grid, row, col + 1));
        }

        return grid[row][col] - 101;
    }
}
