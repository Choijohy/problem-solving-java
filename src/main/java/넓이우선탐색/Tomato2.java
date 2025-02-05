package 넓이우선탐색;

import java.util.*;
import java.io.*;

public class Tomato2 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] str = br.readLine().split(" ");
    int m = Integer.parseInt(str[0]);
    int n = Integer.parseInt(str[1]);
    int[][] box = new int[n][m];

    Queue<int[]> queue = new ArrayDeque<>();
    int unripe = 0;
    for (int i=0; i<n;i++){
    	String[] temp = br.readLine().split(" ");
        for (int j=0; j<m; j++){
			int status = Integer.parseInt(temp[j]);
          	box[i][j] = status;
          	if (status == 0) unripe ++;
          	else if (status == 1) queue.add(new int[]{i,j});
        }
    }
   	Solution solution = new Solution(m,n,box,queue,unripe);
    bw.append(String.valueOf(solution.solution()));
    br.close();
    bw.flush();
    bw.close();
    return ;
  }
}

class Solution{
  	int m; // 가로
  	int n; // 세로
	int[][] box;
  	Queue<int[]> queue = new ArrayDeque<>();
  	int unripe;


  	Solution(int m, int n, int[][] box, Queue<int[]> queue, int unripe){
    	this.m = m;
      	this.n = n;
      	this.box = box;
      	this.queue = queue;
      	this.unripe = unripe;
    }

  	public int solution(){
      	if (unripe == 0) return 0; // 이미 모두 익은 경우

		int days = -1;
      	int[] dx = {1,-1,0,0};
      	int[] dy = {0,0,1,-1};

      	while (!queue.isEmpty()){
        	int size = queue.size();
          	days ++;
          	for (int i=0; i<size;i++){
            	int[] temp = queue.poll();

              	for (int j=0; j < 4; j++){
                	int nx = temp[0] + dx[j];
                  	int ny = temp[1] + dy[j];
                  	if (nx > -1 && nx < n && ny > -1 && ny < m && (box[nx][ny] == 0)){
                    	box[nx][ny] = 1;
                      	unripe --;
             			queue.add(new int[]{nx,ny});
                    }
                }
            }
        }

	 	if (unripe > 0) return -1;
      	else return days;
    }

}