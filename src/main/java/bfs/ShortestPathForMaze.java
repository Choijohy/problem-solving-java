package bfs;

import java.util.*;
import java.io.*;

public class ShortestPathForMaze {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int targetX = Integer.parseInt(firstLine[0]);
        int targetY = Integer.parseInt(firstLine[1]);

        List<List<Integer>> maze = new ArrayList<>();


        for (int i = 0; i < targetX; i++) {
            String line = br.readLine();
            List<Integer> row = new ArrayList<>();
            for (char c : line.toCharArray()) {
                row.add(c - '0'); // 문자를 숫자로 변환
            }
            maze.add(row);
        }

        // 풀이
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        List<Integer> xList = Arrays.asList(1,-1,0,0);
        List<Integer> yList = Arrays.asList(0,0,1,-1);


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
                if (maze.get(x).get(y) == 1){
                    maze.get(x).set(y, 0);

                    // 상하좌우 인근 경로 탐색 및 해당 경로가 1일 경우 큐에 추가
                    for (int n=0; n<4;n++){
                        int newX = x + xList.get(n);
                        int newY = y + yList.get(n);
                        if (newX >=0 && newX < targetX && newY >= 0 && newY < targetY){
                            if (maze.get(newX).get(newY) == 1){
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
