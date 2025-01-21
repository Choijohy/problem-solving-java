package 넓이우선탐색;

/*
 문제: 백준 2178(https://www.acmicpc.net/problem/2178)
 자료구조:
    - 2차원 배열
    - BFS 구현을 위한 연결 리스트 기반 큐
 알고리즘:
    - BFS
    - 최단거리를 구해야 하므로 DFS가 아닌 BFS 선택
 */

import java.util.*;
import java.io.*;

public class ShortestPathForMaze {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int targetX = Integer.parseInt(firstLine[0]);
        int targetY = Integer.parseInt(firstLine[1]);

        int[][] maze = new int[targetX][targetY];


        for (int i = 0; i < targetX; i++) {
            String line = br.readLine();
            for (int j = 0; j < targetY; j++){
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        // 풀이
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        int[] xList = {0,0,1,-1};
        int[] yList = {1,-1,0,0};

        int cnt = 1;
        while (!queue.isEmpty()){
            int size = queue.size();

            // 1 depth씩 인근 경로 추적할때마다 cnt + 1
            for (int i = 0; i<size; i++){
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                // 목적지 노드일 경우
                if (x+1 == targetX && y+1 == targetY){
                    System.out.println(cnt);
                    return;
                }
                if (maze[x][y] == 1){
                    maze[x][y] = 0;

                    // 상하좌우 인근 경로 탐색 및 해당 경로가 1일 경우 큐에 추가
                    for (int n=0; n<4;n++){
                        int newX = x + xList[n];
                        int newY = y + yList[n];
                        if (newX >=0 && newX < targetX && newY >= 0 && newY < targetY){
                            if (maze[newX][newY] == 1){
                                queue.add(new int[]{newX, newY});
                            }
                        }
                    }
                }
            }
            cnt ++;
        }
        System.out.println(cnt);
    }
}
