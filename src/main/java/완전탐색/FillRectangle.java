package 완전탐색;

import java.io.*;
public class FillRectangle {
    public static int n;
    public static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));
        n = Integer.parseInt(br.readLine());
        dp =  new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.print(dp[n]);
    }
}