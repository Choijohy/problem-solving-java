package 넓이우선탐색;
/*
문제: 로봇 청소기
유형: BFS + 구현
공부:
    수식으로 풀기
    1) 방향전환: 3->2->1->0->3->2 .... d = (d+3)%4
    2) 후진: 3->1->3->1.. / 2->0->2->0 ... d = (d+2)%4
*/

import java.util.*;
import java.io.*;


class RobotCleaner{
    public static int solution(int N, int M, int x, int y, int d, int[][] graph){
        Queue<int[]> queue = new ArrayDeque<>();
        graph[x][y] = 2;
        int answer = 1;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        queue.add(new int[]{x,y});
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            x = cur[0];
            y = cur[1];
            boolean flag = false;
            for(int i=0; i<4;i++){
                d = (d+3)%4;
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx>-1 && nx<N && ny>-1 && ny<M && graph[nx][ny] == 0){
                        graph[nx][ny] = 2; // 청소
                        answer++; // 청소 칸 + 1
                        queue.add(new int[]{nx,ny}); // 현재 방향으로 전진
                        flag = true;
                        break;
                }
            }
            if (!flag){
                int td = (d+2)%4;
                int nx = x + dx[td];
                int ny = y + dy[td];
                if (nx>-1 && nx<N && ny>-1 && ny<M){
                    if (graph[nx][ny] == 2) queue.add(new int[]{nx,ny});
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]); // 행 개수
        int M = Integer.parseInt(str[1]); // 열 개수
        str = br.readLine().split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        int d = Integer.parseInt(str[2]);
        int[][] graph = new int[N][M];
        for (int i=0; i< N; i++){
            str = br.readLine().split(" ");
            for (int j=0; j< M; j++){
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }

        System.out.println(solution(N,M,x,y,d,graph));
        br.close();
    }
}