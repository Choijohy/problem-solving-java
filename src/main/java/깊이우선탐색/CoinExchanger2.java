package 깊이우선탐색;

import java.util.*;
import java.io.*;

public class CoinExchanger2 {
  static int m;
  static boolean flag = false;
  static Integer[] coins;
  static int answer = Integer.MAX_VALUE;

  public static void dfs(int L, int sum){
    if(L > answer) return;
    for (int i=0; i<coins.length; i++){
      int temp = sum + coins[i];
      if (temp == m) {
      	answer = Math.min(L+1, answer);
      }else if (temp < m){
      	dfs(L+1, temp);
      }
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] str= br.readLine().split(" ");
    coins = new Integer[n];
    for (int i=0; i<n; i++){
    	coins[i] = Integer.parseInt(str[i]);
    }
    Arrays.sort(coins, Collections.reverseOrder());
    m = Integer.parseInt(br.readLine());
    dfs(0,0);
   	System.out.println(answer);
    return ;
  }
}