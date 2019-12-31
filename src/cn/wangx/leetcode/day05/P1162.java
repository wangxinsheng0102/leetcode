package cn.wangx.leetcode.day05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Create by wangx On 2019/12/30
 **/
public class P1162 {

    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        grid[0][0] = 1;
        grid[0][1] = 0;
        grid[0][2] = 1;
        grid[1][0] = 0;
        grid[1][1] = 0;
        grid[1][2] = 0;
        grid[2][0] = 1;
        grid[2][1] = 0;
        grid[2][2] = 1;
        P1162 p1162 = new P1162();
        int i = p1162.maxDistance(grid);
        System.out.println(i);
    }


    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        if (queue.isEmpty() || queue.size() == m*n) return -1;
        int[][] next = {{1,0},{-1,0},{0,-1},{0,1}};
        int level = -1;
        while (!queue.isEmpty()){
            int count = queue.size();
            for (int i = 0; i < count ; i++) {
                int[] cur = queue.poll();
                for (int[] nt: next){
                    int nx = cur[0] - nt[0], ny = cur[1] - nt[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0){
                        grid[nx][ny] = 1;
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }
            level++;
        }
        return level;
    }
}
