package numberofislands;

import java.util.Arrays;

class Solution {
   public int numIslands(char[][] grid) {
        if(grid == null || grid.length < 1 || grid[0].length < 1){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[] root = new int[row * col];
        Arrays.fill(root, -1);
        int n = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                root[i*col + j] = i*col + j;
                if(grid[i][j] == '1'){
                    n++;
                }
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    int p = i * col + j;
                    int q;
                    if((i+1) < row && grid[i+1][j] == '1'){
                        q = p + col;
                        n = union(root, p, q, n);
                    }
                    if((j+1) < col && grid[i][j+1] == '1'){
                        q = p + 1;
                        n = union(root, p, q, n);
                    }
                }
            }
        }
        return n;
    }
    private int union(int[] root, int p, int q, int count){
        int proot = find(root, p);
        int qroot = find(root, q);
        if(proot!= qroot){
            root[proot] = qroot;
            count--;
        }
        return count;
    }
    private int find(int[] root, int p){
        while(p != root[p]){
            root[p] = root[root[p]];
            p = root[p];
        }
        return p;
    }
}
