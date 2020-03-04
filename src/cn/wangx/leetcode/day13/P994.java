package cn.wangx.leetcode.day13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    //BFS
    public int orangesRotting(int[][] grid) {
        int[][] pos = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;//新鲜橘子的数量
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                if (grid[i][j] == 1){
                    count++; //记录新鲜橘子的数量
                }else if (grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        int minus = 0;//经过的时间
        while (count > 0 && !queue.isEmpty()){
            minus++;
            int s = queue.size();
            for (int i = 0; i < s ; i++) {
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];
                if (r-1>=0 && grid[r-1][c] == 1){
                    grid[r-1][c] = 2;
                    System.out.println(grid[r-1][c]);
                    count--;
                    queue.add(new int[]{r-1,c});
                }

                if (r+1 < n && grid[r+1][c] == 1){
                    grid[r+1][c] = 2;
                    count--;
                    queue.add(new int[]{r+1,c});
                }

                if (c-1 >= 0 && grid[r][c-1] == 1){
                    grid[r][c-1] = 2;
                    count--;
                    queue.add(new int[]{r,c-1});
                }

                if (c+1 < m && grid[r][c+1] == 1){
                    grid[r][c+1] = 2;
                    count--;
                    queue.add(new int[]{r,c+1});
                }

            }
        }

        if (count > 0){
            minus = -1;
        }
        System.out.println(minus);
        return minus;
    }
}

public class P994 {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};

        Solution solution = new Solution();
        solution.orangesRotting(grid);
    }

}
