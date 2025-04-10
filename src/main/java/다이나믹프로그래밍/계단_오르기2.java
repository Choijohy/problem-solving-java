package 다이나믹프로그래밍;
/*
* 문제: 계단 오르기 2
* 유형: dp
* 공부:
*   1칸 점프할 수 있는 횟수가 제한됨 -> 1칸 점프한 횟수가 0일때, 1일때, 3일때,,, 케이스 따로 구해줘야함
       -> dp를 2차원 배열로 풀기(dp[i][j]: 1칸 점프를 i번까지 소진했을때, j번까지 점프한의 최댓값)
* */
import java.util.*;
import java.io.*;

public class 계단_오르기2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][4];


        for (int i=0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 0;
        dp[1][1] = coins[1];

        // 2<= n <=3
        for(int i=2; i<=Math.min(3,n); i++){
            for (int j=0; j<4; j++){
                if (j==0) {
                    if (dp[i-2][j] != -1) dp[i][j] = dp[i-2][j]+coins[i];
                }
                else{
                    if (i==j) dp[i][j] = dp[i-1][j-1] + coins[i];
                    else {
                        if (dp[i-1][j-1] != -1) dp[i][j] = Math.max(dp[i-2][j]+coins[i], dp[i-1][j-1]+coins[i]);
                    }
                }
            }
        }

        if (n<=3){
            int answer = -1;
            for (int i=0; i<4; i++){
                answer = Math.max(dp[n][i], answer);
            }
            System.out.println(answer);
            return;
        }

        for (int i=3; i<=n; i++){
            for (int j=0; j<4; j++){
                if(j==0){
                    if(dp[i-2][j] != -1) dp[i][j] = dp[i-2][j] + coins[i];
                }
                else{
                    if (dp[i-1][j-1] != -1){
                        dp[i][j] = Math.max(dp[i-1][j-1]+coins[i], dp[i-2][j]+coins[i]);
                    }
                }
            }
        }

        int answer = -1;
        for (int i=0; i<4; i++){
            answer = Math.max(dp[n][i], answer);
        }
        System.out.println(answer);

    }
}