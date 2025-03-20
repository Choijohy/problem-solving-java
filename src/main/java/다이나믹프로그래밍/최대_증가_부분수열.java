package 다이나믹프로그래밍;


import java.util.*;
import java.io.*;
/*
문제: 최대 증가 부분 수열[EASY]
유형: dp
공부:
    - O(N*M) 풀이 vs O(N)
*/
public class 최대_증가_부분수열 {
    static final int MAX_VALUE = 10000;
    static int n;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] num = new int[n+1];
        int[][] dp = new int[n+1][MAX_VALUE+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <=MAX_VALUE; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            num[i+1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= MAX_VALUE; j++) {
                int cur = num[i];
                if(cur != j) dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = dp[i-1][j];
                    for (int k=0; k<cur;k++){
                        if (dp[i-1][k] != -1) dp[i][j] = Math.max(dp[i-1][k] +1 ,dp[i][j]);
                    }
                }
            }
        }

        int answer = -1;
        for (int i=1; i<=MAX_VALUE;i++){
            answer = Math.max(answer, dp[n][i]);
        }
        System.out.println(answer);
    }
}