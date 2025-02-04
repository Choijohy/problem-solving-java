package 깊이우선탐색;

import java.util.*;
import java.io.*;

public class 최대점수구하기 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	String[] str = br.readLine().split(" ");
    int n = Integer.parseInt(str[0]); // 문제 개수
    int m = Integer.parseInt(str[1]); // 제한 시간
    int[][] problems = new int[n][2]; // 점수, 소요 시간
    for (int i=0; i<n; i++){
    	String[] temp = br.readLine().split(" ");
      	problems[i] = new int[] {Integer.parseInt(temp[0]),Integer.parseInt(temp[1])};
    }

    MaxScoreCalculator maxScoreCalculator = new MaxScoreCalculator(n,m,problems);
    maxScoreCalculator.dfs(0,0,0);
    bw.append(String.valueOf(maxScoreCalculator.answer));
    bw.newLine();

   	br.close();
    bw.flush();
    bw.close();
    return ;
  }
}

class MaxScoreCalculator{
  	int n;
  	int timeLimit;
  	int[][] problems;
  	int answer;

  	MaxScoreCalculator(
    	int n,
      	int m,
      	int[][] problems
    ){
    	this.n =n;
      	this.timeLimit = m;
      	this.problems = problems;
      	answer = 0;
    }

	public void dfs(int i, int score, int time){
      	if (time > timeLimit) return;
      	if (i == n) {
            answer = Math.max(answer,score);
            return;
        }
    	dfs(i+1, score + problems[i][0], time + problems[i][1]); // i번째 문제 풀 경우
      	dfs(i+1, score, time); // 안 풀 경우
    }
}