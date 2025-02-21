package 다이나믹프로그래밍;

import java.util.*;
import java.io.*;

public class CoinCases {
    public static int solution(List<Integer> coins, int amount) {
        int[] dp = new int[amount + 1]; // 각 금액을 만들 수 있는 경우의 수
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 건수
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine()); // 동전 개수
            String[] str = br.readLine().split(" ");
            List<Integer> coins = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                coins.add(Integer.parseInt(str[j]));
            }
            int amount = Integer.parseInt(br.readLine());
            bw.append(String.valueOf(solution(coins, amount)));
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}