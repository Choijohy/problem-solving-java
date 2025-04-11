package 다이나믹프로그래밍;

import java.util.Scanner;

public class 동전거슬러주기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++)
            coin[i] = sc.nextInt();
        // Please write your code here.

        int[] dp = new int[m+1];

        for (int i=1; i<=m; i++){
            int num = 10001;
            for (int j=0; j<n; j++){
                if (i==coin[j]) {
                    num = 1;
                    break;
                }
                if (i > coin[j]){
                    if (dp[i-coin[j]] != -1)
                        num = Math.min(num,dp[i-coin[j]]+1);
                }
            }
            if (num == 10001) dp[i] = -1;
            else dp[i] = num;
        }
        System.out.println(dp[m]);
    }

}