package 다이나믹프로그래밍;
import java.util.*;
import java.io.*;

/*
* 문제: 정수 사각형 최장 증가 수열
* 유형: dp
* 공부:
    - dp 활용하여, 중복 계산 줄이기
    - brute force로 풀기 -> 중복 과정 찾기 -> dp로 변
* */

public class LongestGrowingGrid {
    static int n;
    static int[][] grid;
    static int[][] dp;
    static int answer = 0;
    static int count = 0;

    private static int dfs(int x, int y){
        // 이전에 dfs()탐색이 완료된 노드라면
        if (dp[x][y] > 0) {
            //System.out.println("dp반환: "+dp[x][y]);
            return dp[x][y];
        };

        final int[] dx = {1,-1,0,0};
        final int[] dy = {0,0,-1,1};

        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >-1 && nx <n && ny >-1 && ny<n &&
            (grid[nx][ny]>grid[x][y])){
                //System.out.println("nx: "+nx+" ny: "+ny);
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) +1);
            }
        }

        dp[x][y] = Math.max(dp[x][y], 1); // 본인이 말단 노드인 경우
        //System.out.println("return("+x+","+y+") --> "+dp[x][y]);
        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.println("dfs시작-- i: "+i+", j: "+j);
                int count = dfs(i,j);
                answer = Math.max(answer, count);
            }
        }

        System.out.println(answer);

    }
}

