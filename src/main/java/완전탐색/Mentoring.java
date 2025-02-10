package 완전탐색;

import java.util.*;
import java.io.*;

public class Mentoring {
  public static void main(String[] args) throws IOException{
   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] str = br.readLine().split(" ");
    int n = Integer.parseInt(str[0]); // 학생수
    int m = Integer.parseInt(str[1]); // 시험 개수

    int[][] scores = new int[m+1][n+1];
    for(int i=1; i<=m;i++){
      	String[] score = br.readLine().split(" ");
    	for (int j=1; j<=n; j++){
            int student = Integer.parseInt(score[j-1]);
        	scores[i][student] = j;
        }
    }
    Solution solution = new Solution(m,n,scores);
    bw.append(String.valueOf(solution.solution()));

    br.close();
    bw.flush();
    br.close();

    return ;
  }
}


class Solution{
	int m,n = 0;
  	int[][] scores;

  Solution(int m, int n, int[][] scores){
  	this.m = m;
    this.n = n;
    this.scores = scores;
  }

  public int solution(){
    	boolean isMentee = true;
    	int[] result = new int[n+1];

    	for (int i=1; i<=n; i++){
        	int count = 0;
            for (int j=1;j<=n; j++){ // 한 명씩 비교
            	if (i ==j) continue; // 본인에 대한 비교는 제외
              	else{
                      for (int k=1; k<=m; k++) { // 모든 시험에 대하여 성적 비교
                          if (scores[k][i] < scores[k][j]) { //2) 본인 보다 등수가 낮은 경우
                              isMentee = false;
                              break;
                          }
                      }
                }
                if (isMentee) count ++;
            	else isMentee = true;
           }
           result[i] = count; // i학생의 멘티
        }
        int answer = 0;
        for (int x: result) {
            answer += x;
        }
        return answer;
  }
}