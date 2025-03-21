package 다이나믹프로그래밍;


import java.util.*;
import java.io.*;

public class 최대_증가_수열_2차원 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][m];
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 1;
        int answer = 1;
        for (int i=0;i<n;i++){
            for (int j=0; j<m; j++){
                int cur = grid[i][j];
                //System.out.println("i: "+i+" j: "+j);
                for (int nx=i-1;nx>=0;nx--){
                    for (int ny=j-1;ny>=0;ny--){
                        if (dp[nx][ny] == -1) continue;
                        if (grid[nx][ny] < cur){
                            dp[i][j] = Math.max(dp[i][j],dp[nx][ny] + 1);
                            //System.out.println("nx: "+nx+" ny: "+ny+"->"+dp[i][j]);
                        }

                    }
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }
       System.out.println(answer);
    }
}