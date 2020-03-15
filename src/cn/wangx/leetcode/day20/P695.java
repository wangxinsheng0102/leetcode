package cn.wangx.leetcode.day20;

public class P695 {
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int[][] vis = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j <grid[i].length ; j++) {
                if (grid[i][j] == 1){
                    ans = Math.max(dfs1(i,j,grid,vis), ans);
                }
            }
        }
        return ans;

    }
    //沉岛法
    public int dfs(int i,int j,int[][] grid){
        if (i < 0 || j < 0 ||  i >= grid.length || j>= grid[i].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs(i+1,j,grid);
        num += dfs(i-1,j,grid);
        num += dfs(i,j+1,grid);
        num += dfs(i,j-1,grid);
        return num;
    }

    //朋友圈法
    public int dfs1(int i,int j,int [][]grid,int[][] vis){
        if (i < 0 || j < 0 ||  i >= grid.length || j>= grid[i].length || vis[i][j] == 1 || grid[i][j] == 0){
            return 0;
        }
        vis[i][j] = 1;
        int num = 1;
        num += dfs1(i+1,j,grid,vis);
        num += dfs1(i-1,j,grid,vis);
        num += dfs1(i,j+1,grid,vis);
        num += dfs1(i,j-1,grid,vis);
        return num;
    }
}
