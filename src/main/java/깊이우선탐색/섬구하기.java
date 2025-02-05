package 깊이우선탐색;

import java.util.*;
import java.io.*;

public class 섬구하기 {
  public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[][] graph = new int[n][n];
    for (int i=0; i<n; i++){
    	String[] str = br.readLine().split(" ");
      	for (int j=0; j<n; j++){
        	graph[i][j] = Integer.parseInt(str[j]);
        }
    }

    Solution_섬구하기 solution = new Solution_섬구하기(n, graph);
	bw.append(String.valueOf(solution.solution()));

	br.close();
	bw.flush();
    bw.close();
	return ;
  }
}

class Solution_섬구하기{
  	int n;
	int[][] graph;
  	private static final int[] dx = {1,-1,0,0, -1,1,-1,1};
  	private static final int[] dy = {0,0,1,-1,-1,-1,1,1};

    Solution_섬구하기(int n , int[][] graph){
        this.n = n;
        this.graph = graph;
    }

  	public int solution(){
      	int answer = 0;
    	for (int i=0; i<n; i++){
          	for (int j=0; j<n; j++){
        		if (graph[i][j] == 1) {
                  answer ++;
                  graph[i][j] = 0; // 시작 노드의 방문처리
                  dfs(i,j);
                }
        	}
    	}
      	return answer;
    }
  	public void dfs(int x, int y){
  		for (int i=0; i<8; i++){
        	int nx = x + dx[i];
          	int ny = y + dy[i];
        	if (nx > -1 && nx < n && ny > -1 && ny <n && (graph[nx][ny] == 1)){
              	graph[nx][ny] = 0;
            	dfs(nx, ny);
            }
        }
    }
}