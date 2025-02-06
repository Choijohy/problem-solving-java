package 스택큐;
/*
* 문제: 인형뽑기
* 카테고리 : 스택
* 기타:
*   - peek(): 제거 없이, 스택의 맨 꼭대기 요소 반환
*   - ArrayDeque의 getLast():
*/

import java.util.*;
import java.io.*;

public class 인형뽑기 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[][] board = new int[n][n];
    for (int i=0; i<n; i++){
    	String[] temp = br.readLine().split(" ");
      	for (int j=0;j<n; j++){
        	board[i][j] = Integer.parseInt(temp[j]);
        }
    }
    int m = Integer.parseInt(br.readLine());
    int[] moves = new int[m];
    String[] temp = br.readLine().split(" ");
    for (int i=0; i<m;i++){
    	moves[i] = Integer.parseInt(temp[i]);
    }

    Solution solution = new Solution(n, board, m , moves);
    bw.append(String.valueOf(solution.solution()));

    br.close();
    bw.flush();
    bw.close();
    return ;
  }
}

class Solution{
  	int n;
	int[][] board;
  	int m;
  	int[] moves;

  	Solution(int n, int[][] board, int m, int[] moves){
    	this.n = n;
      	this.board = board;
      	this.m = m;
      	this.moves = moves;
    }
  	public int solution(){
      	ArrayDeque<Integer> bucket = new ArrayDeque<>();
    	int answer = 0;
      	for (int i=0; i<m; i++){
        	int target = moves[i];
          	for (int j=0; j<n;j++){
            	int doll = board[j][target-1];
              	if (doll!= 0){
                    board[j][target-1] = 0;
                  	if (!bucket.isEmpty() && doll == bucket.getFirst()){// 맨 꼭대기 인형과 같으면 pop
                      	bucket.pop();
                      	answer += 2;
                    }else{ // 빈 바구니이거나, 꼭대기 인형과 다르면 Push
                      bucket.push(doll);
                    }
                  	break;
                }
            }
        }
      	return answer;
    }
}