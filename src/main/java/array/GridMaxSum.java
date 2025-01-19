package array;

import java.util.*;

public class GridMaxSum {
    public static int solution(int size, int[][] grid){
  	int answer = Integer.MIN_VALUE;

      // 가로행, 세로행
    for (int i=0; i< size; i++){
      	int sum1 = 0;
        int sum2 = 0;
    	for (int j=0; j<size;j++) {
            sum1 += grid[i][j];
            sum2 += grid[j][i];
        }
 		answer = Math.max(answer,sum1);
        answer = Math.max(answer,sum2);
    }

    // 대각선
    int sum1= 0;
    int sum2= 0;
    for (int i=0; i< size; i++){
    	sum1 += grid[i][i];
        sum2 += grid[i][size-1-i];
    }
    answer = Math.max(answer,sum1);
    answer = Math.max(answer,sum2);

    return answer;
  }

  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int size = in.nextInt();
    int[][] grid = new int[size][size];
    for (int i=0; i<size; i++){
    	for(int j=0; j<size; j++){
        	grid[i][j] = in.nextInt();
        }
    }
    System.out.println(solution(size, grid));
  }
}
