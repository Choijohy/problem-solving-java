package 다이나믹프로그래밍;

import java.util.*;
import java.io.*;
/*
문제: 서로 다른 BST(이진 트리) 개수 세기
유형: DP
공부:
    - 이전 케이스의 합이 현재 케이스(subproblem 그대로 합치기)
*/

public class BSTCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i=2; i<=n; i++){
            int sum = 0;
            for (int j=0; j<i; j++){
                sum += dp[j]*dp[i-1-j];
            }
            dp[i] = sum;
        }

        System.out.println(dp[n]);
    }
}