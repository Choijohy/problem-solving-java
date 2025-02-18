package 다이나믹프로그래밍;

import java.util.*;
import java.io.*;

public class CoinExchange2 {
  public static int solution(int n, int[] coins, int amount){
  	int[] dp = new int[amount+1]; // 금액별 필요한 최소 동전 개수
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i=1; i<=amount; i++){
    	for (int coin: coins){
        	int left = i - coin;
          	if (left == 0) {
                  dp[i] = 1;
                  break;
            }
          	else if(left > 0) {
                  dp[i] = Math.min(dp[i], dp[i] = dp[left] + 1);
            }
          	else break;
        }
    }
    return dp[amount];
  }
  public static void main(String[] args) throws IOException{
  	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] str = br.readLine().split(" ");
    int[] coins = new int[n];
    for (int i=0; i<n; i++){
    	coins[i] = Integer.parseInt(str[i]);
    }
    Arrays.sort(coins);
    int amount = Integer.parseInt(br.readLine());

    System.out.println(solution(n, coins, amount));
    return ;
  }
}