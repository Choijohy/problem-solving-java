package 다이나믹프로그래밍;

import java.util.Scanner;
public class 막대나누기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] profit = new int[n+1];
        for (int i = 1; i <= n; i++) {
            profit[i] = sc.nextInt();
        }
        // Please write your code here.

        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++){
            int max = profit[i];
            for (int j= i-1; j>0; j--){
                max = Math.max(max, dp[j]+dp[i-j]);
            }
            dp[i] = max;
        }
        System.out.println(dp[n]);
    }

}