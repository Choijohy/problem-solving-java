package 다이나믹프로그래밍;

import java.util.*;
import java.io.*;

public class 사각형채우기1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 2;
        int MOD =  1000000007;
        for (int i=2;i<=n; i++){
            dp[i] = (dp[i-1]*2 + dp[i-2] * 3) % MOD;
            for (int j=i-3; j>= 0; j--){
                dp[i] = (dp[i] + dp[j]*2) % MOD;
            }
        }
        System.out.println(dp[n]);

    }
}