package 구현;

/*
문제: 뱀
유형: 시뮬레이션, 구현, 자료구조(큐, 인접행렬)
공부:
    1) 요구사항을 잘 읽자 - "사과는 먹으면 사라진다"를 반영하지 않아 틀림. 사과가 없을때, "꼬리 영역만" 줄어듬. 다시 길이 1이 되는게 아님.
    2) 헷갈렸던 점: 방향 전환 -> dx, dy 배열에서 상/하/좌/우 순서를 어떻게 배치할지. 몸 길이 1씩 줄어드는건 큐 사용.
*/
import java.util.*;
import java.io.*;

public class Snake{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 격자판
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N+2][N+2];
        for (int i=0; i<=N+1; i++){
            graph[0][i] = 1;
            graph[i][0] = 1;
            graph[N+1][i] =1;
            graph[i][N+1] =1;
        }

        // 사과
        int K = Integer.parseInt(br.readLine());
        int[][] apples = new int[N+1][N+1];
        for (int i=0;i<K;i++){
            String[] str = br.readLine().split(" ");
            apples[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
        }

        // 방향 전환
        int L = Integer.parseInt(br.readLine());
        int[] turns = new int[10001];
        for (int i=0; i<L;i++){
            String[] str = br.readLine().split(" ");
            int time = Integer.parseInt(str[0]);
            String direction = str[1];
            if (direction.equals("L")) turns[time] = 1;
            else if (direction.equals("D")) turns[time] = 2;
        }

        // 게임 시작
        int time = 0; // 플레이 시간
        int x = 1;
        int y = 1;
        graph[1][1] = 1;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1,1});
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int d = 1;
        while (true){
            time ++;
            x += dx[d];
            y += dy[d];
            if (graph[x][y] == 1) break;
            // 사과가 없는 경우 -> 꼬리 줄이기
            if (apples[x][y] == 0){
                if(!queue.isEmpty()){
                    int[] location = queue.poll();
                    graph[location[0]][location[1]] = 0;
                }
            }
            apples[x][y] = 0;
            queue.offer(new int[]{x,y});
            if (turns[time]==1){
                d = d-1 > -1 ? d-1:3;
            } else if(turns[time]==2){
                d = d+1 < 4 ? d+1 :0;
            }
            graph[x][y] = 1;

        }

        System.out.println(time);
        br.close();

    }

}