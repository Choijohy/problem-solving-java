package 깊이우선탐색;

import java.util.*;
import java.io.*;

public class Maze {
  static int count;
  public static void dfs(char[][] grid, int x, int y){
  	int[] dx = {1,-1,0,0};
    int[] dy = {0,0,-1,1};

    if (x== 7 && y == 7) {
    	count ++;
      	return;
    }
    for (int i=0; i<4; i++){
    	int nx = x + dx[i];
      	int ny = y + dy[i];

      	if (nx > 0 && nx <= 7 && ny > 0 && ny <=7 && grid[nx][ny] == '0'){
          	grid[nx][ny] = '1';
        	dfs(grid, nx, ny);
          	grid[nx][ny] = '0';
        }
    }
  }
  public static void main(String[] args) throws IOException{
   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[][] grid = new char[8][8];

    for (int i=1; i<8; i++){
    	String[] str = br.readLine().split(" ");
      	for (int j=1; j< 8; j++){
        	grid[i][j] = str[j-1].charAt(0);
        }
    }
    grid[1][1] = '1';
    dfs(grid,1,1);
    System.out.println(count);
    return ;
  }
}