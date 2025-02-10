package 다이나믹프로그래밍;
/*
문제: 최대점수 구하기
카테고리: dp(냅색 알고리즘)
결과: x
풀이 요약:
    - 문제 개수(1<=N<=50), 제한 시간 (10<=M<=300) -> 문제 개수가 50까지 가므로, bfs로 풀이 x(깊이가 50까지는 시간 초과)
    - 사용 가능 자원이 유한개(한 문제는 한 번 밖에 못품): dp 뒤에서부터 순회

*/

import java.util.*;
import java.io.*;

public class 최대문제점수 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] str = br.readLine().split(" ");
    int n = Integer.parseInt(str[0]);
    int m = Integer.parseInt(str[1]);

    List<int[]> problems = new ArrayList<>();
    for (int i=0; i<n; i++){
    	String[] problem = br.readLine().split(" ");
      	problems.add(new int[]{Integer.parseInt(problem[0]), Integer.parseInt(problem[1])});
    }
    Solution_최대문제수 solution = new Solution_최대문제수(n,m,problems);
    bw.append(String.valueOf(solution.solution()));

    br.close();
    bw.flush();
    bw.close();
    return ;
  }
}

class Solution_최대문제수 {
	int n, m = 0;
  	List<int[]> problems;
  	Solution_최대문제수(int n, int m, List<int[]> problems){
    	this.n = n;
      	this.m = m;
      	this.problems = problems;
    }
  	public int solution(){
		int[] dp = new int[m+1];
      	dp[0] = 0;
  		for (int[] p: problems){
        	int score = p[0];
          	int time = p[1];
          	for (int j=m; j>=time; j--){
            	dp[j] = Math.max(dp[j], dp[j-time] + score);
            }
        }
    	return dp[m];
    }
}