package 구현;

/*
문제: 벽이 있는 충돌 실험
유형: 시뮬레이션
기타:
*/

import java.util.*;
import java.io.*;

public class 벽이_있는_충돌_실험 {
    static int N, M;
    static int[][] grid;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};

    private static void copyGrid(int[][] tempGrid){
        for (int i=0;i<N;i++){
            for (int j=0; j<N;j++){
                if(tempGrid[i][j] <=1) grid[i][j] = tempGrid[i][j];
                else grid[i][j] = 0;
            }
        }
    }
    private static void clearMarble(int[][] tempGrid, Queue<int[]> queue){
        int size = queue.size();
        for (int i=0; i<size; i++){
            int[] cur = queue.poll();
            if (tempGrid[cur[0]][cur[1]] <= 1)  queue.offer(cur);
        }
    }

    private static int[][] move(Queue<int[]> queue){
        int[][] tempGrid = new int[N][N];
        int size = queue.size();
        for (int i=0; i<size; i++){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx>-1 && nx<N && ny>-1 && ny<N){
                tempGrid[nx][ny] += 1;
                queue.offer(new int[]{nx,ny,d});
            } else {
                tempGrid[x][y] += 1;
                queue.offer(new int[]{x,y,(d+2)%4});
            }
        }
        return tempGrid;
    }

    private static void solution(Queue<int[]> queue){
        int time = 2*N;

        while(time-- > 0){
            // 이동하거나 방향 바꾸기
            int[][] tempGrid = move(queue);
            clearMarble(tempGrid, queue);
            copyGrid(tempGrid);
            if (queue.isEmpty())break;
        }

        System.out.println(queue.size());

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        HashMap<Character,Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('U',1);
        map.put('L',2);
        map.put('D',3);

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            grid = new int[N][N];
            Queue<int[]> queue = new ArrayDeque<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                int d = map.get(st.nextToken().charAt(0));
                grid[x][y] = 1;
                queue.offer(new int[]{x,y,d});
            }

            solution(queue);

        }
}
    }