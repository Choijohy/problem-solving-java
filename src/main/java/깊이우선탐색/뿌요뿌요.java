package 깊이우선탐색;

import java.util.*;
import java.io.*;

public class 뿌요뿌요 {
    static int[][] grid;
    static boolean[][] visited;
    static int n;
    static int sum;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void dfs(int x, int y){
        visited[x][y] = true;
        sum++;
        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>-1 && nx<n && ny>-1 && ny<n && !visited[nx][ny]){
                if (grid[x][y] == grid[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx,ny);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }

        int bomb = 0;
        int maxBlock = 0;
        // Please write your code here.
        for (int i=0; i<n ; i++){
            for (int j=0; j<n; j++){
                if (!visited[i][j]) dfs(i,j);
                if (sum >=4) bomb++;
                maxBlock = Math.max(maxBlock, sum);
                sum = 0;
            }
        }
        System.out.println(bomb+" "+maxBlock);
    }
}