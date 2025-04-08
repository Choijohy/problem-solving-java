package 자료형.array;

import java.util.*;
import java.io.*;

public class TemporalLeader2 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] grid = new int[n][5];
    for (int i =0; i<n; i++){
    	StringTokenizer st = new StringTokenizer(br.readLine());
      	for (int j=0; j<5; j++){
        	grid[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    int[] score = new int[n];

    for (int i=0; i<n; i++){
    	for (int j=0; j<n; j++){
        	for (int k=0; k<5; k++){
            	if ( (i != j) && grid[i][k] == grid[j][k]){
                	score[i] += 1;
                  	break;
                }
            }
        }
    }

    int answer = 1;
    int max = 0;
    for (int i=0; i<n; i++){
    	if(score[i] > max) {
        	answer = i+1;
          	max = score[i];
        }
    }
    System.out.println(answer);
    return ;
  }
}