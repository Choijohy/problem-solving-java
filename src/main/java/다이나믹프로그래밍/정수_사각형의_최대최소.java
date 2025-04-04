package 다이나믹프로그래밍;

import java.util.*;
import java.io.*;
/*
문제: 정수 사각형 최대합[EASY]
유형: dp
공부:
    - 완탐 dfs()는 시간 초과: 대략 O(2^n) 이라고 계산. 각 격자마다 2개의 방향이 존재하기 때문.
    - n은 최대 100이므로 시간 초과.(2^20 -> 약 1,000,000, 2^40 -> 약 1,000,000,000,000 )
    - 행렬에 주어지는 값 조건도 고려해야 하는가? -> answer 타입 결정에 필요한 조건
*/

public class 정수_사각형의_최대최소 {
    static int n;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = grid[0][0];

        // 최좌측 열
        for (int i=1; i<n; i++){
            dp[i][0] = Math.max(grid[i][0], dp[i-1][0]);
        }
        // 최상단 행
        for (int i=1; i<n; i++){
            dp[0][i] = Math.max(grid[0][i], dp[0][i-1]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(grid[i][j],
                Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }


        System.out.println(dp[n-1][n-1]);
    }
}