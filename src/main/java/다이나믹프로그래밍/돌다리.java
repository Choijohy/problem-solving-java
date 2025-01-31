package 다이나믹프로그래밍;

/*
문제: 돌다리 건너기
카테고리: dp
기타:
  -   n개의 돌다리를 건너는 경우의 수는 n+1번째까지 오는 경우의 수 !!
*/
import java.util.*;
import java.io.*;

public class 돌다리 {
  public static int solution(int n){
  	int[] dp = new int[n+2]; // 인덱스 = 돌다리 순서
    dp[1] = 1;
    dp[2] = 2;

    for(int i=3; i<n+2; i++){
    	dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n+1];
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    System.out.println(solution(n));
    return ;
  }
}