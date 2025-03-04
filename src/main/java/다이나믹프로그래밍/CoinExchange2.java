package 다이나믹프로그래밍;

import java.util.*;
import java.io.*;

public class CoinExchanger2 {
  public static int solution(int[] coins, int m){
  		int[] dp = new int[m+1];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0] = 0;
    	for (int amount=1; amount<=m ; amount++){
        	for (int i=0; i<coins.length; i++){
            	int coin = coins[i];
             	if (coin > amount) break;
              	else dp[amount] = Math.min(dp[amount], dp[amount-coin] + 1); // 각 코인을 사용할때 마다 최솟값 갱신
            }
        }
    	return dp[m];
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] str= br.readLine().split(" ");
    int[] coins = new int[n];
    for (int i=0; i<n; i++){
    	coins[i] = Integer.parseInt(str[i]);
    }
    int m = Integer.parseInt(br.readLine());
    Arrays.sort(coins);
   	System.out.println(solution(coins, m));

    return ;
  }
}