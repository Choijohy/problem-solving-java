package 넓이우선탐색;

import java.util.*;
import java.io.*;

public class 미로찾기 {
      static int n = 7;
      static int[][] graph = new int[n+1][n+1];

      private static int bfs(){
            if (graph[1][1] == 1) return -1;

            int count = -1;
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{1,1});
            graph[1][1] = 1;

            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,1,-1};

            while (!queue.isEmpty()){
                count ++;
                int size = queue.size();
                for (int i=0; i<size; i++){
                  int[] temp = queue.poll();
                  if (temp[0] == n && temp[1] == n) {
                    return count;
                  }
                  for (int j=0;j<4;j++){
                      int nx = temp[0]+dx[j];
                      int ny = temp[1]+dy[j];
                      if (nx > 0 && nx <= n && ny > 0 && ny <= n && graph[nx][ny] != 1){
                          graph[nx][ny] = 1;
                          queue.offer(new int[]{nx,ny});
                      }
                  }
                }
            }
            return -1;
        }

  public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int i=1; i<n+1; i++){
    	String[] str = br.readLine().split(" ");
      	for (int j=1; j<n+1; j++){
        	graph[i][j] = Integer.parseInt(str[j-1]);
        }
    }

    bw.append(String.valueOf(bfs()));

    br.close();
    bw.flush();
    bw.close();
    return ;
  }
}