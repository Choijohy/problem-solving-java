package dfs_bfs;

/*
 문제: 백준 1012(https://www.acmicpc.net/problem/1012)
 자료구조:
    - 2차원 배열
    - BFS 구현을 위한 연결 리스트 기반 큐
 알고리즘:
    - BFS
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class OrganicCabbage {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());

        // Test Case 마다 반복
        for (int i = 0; i < caseNum; i++) {
            String[] gridInfo = br.readLine().split(" ");
            int columns = Integer.parseInt(gridInfo[0]); // 가로 길이
            int rows = Integer.parseInt(gridInfo[1]);    // 세로 길이
            int spot = Integer.parseInt(gridInfo[2]);

            int[][] grid = new int[rows][columns];
            for (int j = 0; j < spot; j++) {
                String[] position = br.readLine().split(" ");
                int col = Integer.parseInt(position[0]);
                int row = Integer.parseInt(position[1]);

                grid[row][col] = 1;
            }
            System.out.println(getEarthWorm(rows, columns, grid));
        }
    }
    public static int getEarthWorm(int rows, int columns, int[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        int[] xList = {0,0,1,-1};
        int[] yList = {1,-1,0,0};
        int count = 0;

        for (int x = 0; x <rows; x++){
            for(int y = 0; y <columns; y++){
                // 배추 심어진 구역일 경우 -> 아래 bfs 탐색되도록 queue에 요소 추가
                if (grid[x][y] == 1){
                    queue.add(new int[]{x, y});
                    grid[x][y] = 0;
                    count ++;
                }

                // bfs로 인근 배추 심어진 구역 탐색
                while(!queue.isEmpty()){
                    int[] current = queue.poll();
                    int currentX = current[0];
                    int currentY = current[1];
                    for (int i = 0; i <4; i++){
                        int newX = currentX + xList[i];
                        int newY = currentY + yList[i];

                        if(newX >= 0 && newX < rows && newY >= 0 && newY < columns){
                            if (grid[newX][newY] == 1){
                                queue.add(new int[]{newX, newY});
                                grid[newX][newY] = 0;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }


}
