package dataStructure.array;

import java.util.*;

public class PeakChecker {
    public static int solution(int size, int[][] grid){
  	int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    // 봉우리 개수
    int answer = 0;
    for (int i=1;i<size+1;i++){
    	for (int j=1; j<size+1;j++){
        	int current = grid[i][j];
          	// 상하좌우 비교
          	boolean isPeak = true;
          	for (int m=0;m<4;m++){
              	int tempRow = i + dx[m];
              	int tempCol = j + dy[m];
            	if (current <= grid[tempRow][tempCol]) {
                	isPeak = false;
                  	break;
                }
            }
          	if (isPeak) answer ++;
        }
    }
    return answer;
  }

  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int size = in.nextInt();
    int[][] grid = new int[size+2][size+2];
    for (int i=0; i<size;i++){
    	for (int j=0; j<size; j++){
        	grid[i+1][j+1] = in.nextInt();
        }
    }
    System.out.println(solution(size, grid));
  }
}
